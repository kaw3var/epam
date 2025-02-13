package vol14.solutionA;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private static final int SERVER_PORT = 6000; // Порт сервера
    private static final List<ClientHandler> connectedClients = new CopyOnWriteArrayList<>(); // Список клиентов
    public static volatile boolean isRunning = true;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is running on port " + SERVER_PORT);

            // Поток для отправки сообщений клиентам
            Thread messageSenderThread = new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                // Ожидание подключения клиентов
                while (isRunning) {
                    if (connectedClients.isEmpty()) {
                        System.out.println("No connected clients");
                        try {
                            Thread.sleep(2500);
                        } catch (InterruptedException e) {
                            System.out.println("Message sender thread interrupted. Exiting..");
                            return;
                        }
                        continue;
                    }

                    System.out.println("Connected clients:");
                    for (int i = 0; i < connectedClients.size(); i++) {
                        System.out.println("ID " + i + ": " + connectedClients.get(i).getClientInfo());
                    }

                    // Отправка сообщения после нажатия Enter
                    System.out.println("Press Enter to write message..");
                    String inputEnter = scanner.nextLine();
                    if (inputEnter.isEmpty() && isRunning) {
                        try {
                            System.out.print("Enter ID of clients to send message (comma-separated): ");
                            String input = scanner.nextLine();
                            List<ClientHandler> selectedClients = parseClientSelection(input);

                            System.out.print("Enter a message to send: ");
                            String message = scanner.nextLine();
                            if (message.trim().isEmpty()) {
                                System.out.println("Cannot send an empty message");
                                continue;
                            }
                            sendMessageToSelectedClients(message, selectedClients);
                        } catch (Exception e) {
                            System.out.println("Error in Enter key listener: " + e.getMessage());
                        }
                    }
                }
                System.out.println("Message sender threat has stopped");
            });
            messageSenderThread.setDaemon(true);
            messageSenderThread.start();

            // Ожидание подключения клиентов
            waitToConnectClient(serverSocket);
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        } finally {
            shutdown();
        }
    }

    private static void waitToConnectClient(ServerSocket serverSocket) throws IOException {
        while (isRunning) {
            Socket clientSocket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            connectedClients.add(clientHandler);
            new Thread(clientHandler).start();
            System.out.println("New client connected: " + clientHandler.getClientInfo());
        }
    }

    private static List<ClientHandler> parseClientSelection(String input) {
        List<ClientHandler> selectedClients = new ArrayList<>();
        if (input == null || input.trim().isEmpty()) {
            System.out.println("No client IDs provided");
            return selectedClients;
        }
        try {
            String[] indices = input.split(",");
            for (String index : indices) {
                int clientIndex = Integer.parseInt(index.trim());
                if (clientIndex >= 0 && clientIndex < connectedClients.size()) {
                    selectedClients.add(connectedClients.get(clientIndex));
                } else {
                    System.out.println("Invalid client ID: " + clientIndex);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please enter ID as comma-separated numbers");
        }
        return selectedClients;
    }

    private static void sendMessageToSelectedClients(String message, List<ClientHandler> selectedClients) {
        if (selectedClients.isEmpty()) {
            System.out.println("No clients selected. Message not sent");
            return;
        }
        for (ClientHandler clientHandler : selectedClients) {
            boolean success  = clientHandler.sendMessage(message);
            String status = success ? " sent successfully" : " failed to send";
            System.out.println("Message to " + clientHandler.getClientInfo() + status);
        }
    }

    // Остановка всех потоков
    public static void shutdown() {
        isRunning = false;
        connectedClients.forEach(client -> {
            try {
                client.socket.close();
            } catch (IOException ignored) {}
        });
        connectedClients.clear();
        System.out.println("Server shut down");
    }

    // Вспомогательный класс для работы с клиентами
    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private final BufferedWriter writer;

        ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Message from " + getClientInfo() + ": " + message);

                    // Отправляем подтверждение клиенту
                    writer.write("Message received: " + message);
                    writer.newLine();
                    writer.flush();
                }
            } catch (IOException e) {
                System.err.println("Client disconnected: " + getClientInfo());
            } finally {
                try {
                    socket.close();
                    connectedClients.remove(this);
                    System.out.println("Client removed: " + getClientInfo());
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e.getMessage());
                }
            }
        }

        public boolean sendMessage(String message) {
            try {
                writer.write(message);
                writer.newLine();
                writer.flush();
                return true;
            } catch (IOException e) {
                System.err.println("Failed to send message to " + getClientInfo() + ": " + e.getMessage());
                return false;
            }
        }

        public String getClientInfo() {
            return socket.getInetAddress() + ":" + socket.getPort();
        }
    }
}
