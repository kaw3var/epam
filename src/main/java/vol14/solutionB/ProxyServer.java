package vol14.solutionB;

import java.io.*;
import java.net.*;

public class ProxyServer {
    private static final int PROXY_PORT = 8080;  // Порт для прокси-сервера
    private static final String SERVER_HOST = "localhost";  // Адрес сервера
    private static final int SERVER_PORT = 9090;  // Порт сервера

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PROXY_PORT)) {
            System.out.println("Proxy server started on port " + PROXY_PORT);

            while (true) {
                // Принимаем соединение от клиента
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Создаем отдельный поток для обработки этого клиента
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Error starting proxy server: " + e.getMessage());
        }
    }

    static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter clientWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                 Socket serverSocket = new Socket(SERVER_HOST, SERVER_PORT);
                 BufferedReader serverReader = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
                 PrintWriter serverWriter = new PrintWriter(serverSocket.getOutputStream(), true)) {

                System.out.println("Forwarding messages between client and server...");

                String clientMessage;
                while ((clientMessage = clientReader.readLine()) != null) {
                    // Изменяем сообщение перед отправкой на сервер
                    String modifiedMessage = modifyMessage(clientMessage);
                    System.out.println("Forwarding message to server: " + modifiedMessage);
                    serverWriter.println(modifiedMessage);

                    // Получаем ответ от сервера и отправляем клиенту
                    String serverResponse = serverReader.readLine();
                    if (serverResponse == null) {
                        System.out.println("Server closed the connection.");
                        break;
                    }
                    System.out.println("Forwarding response to client: " + serverResponse);
                    clientWriter.println(serverResponse);
                }
            } catch (IOException e) {
                System.err.println("Error in client-server communication: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e.getMessage());
                }
            }
        }

        String modifyMessage(String message) {
            int shift = 3; // Сдвиг на 3 символа
            StringBuilder encryptedMessage = new StringBuilder();

            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    c = (char) ((c - base + shift) % 26 + base);
                }
                encryptedMessage.append(c);
            }
            return encryptedMessage.toString();
        }
    }
}
