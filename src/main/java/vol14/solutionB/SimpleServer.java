package vol14.solutionB;

import java.io.*;
import java.net.*;

public class SimpleServer {
    private static final int PORT = 9090;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }

    static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String encryptedMessage = reader.readLine();
                if (encryptedMessage == null) {
                    System.out.println("Client closed the connection");
                    return;
                }
                System.out.println("Received from proxy: " + encryptedMessage);

                String decryptedMessage = decryptMessage(encryptedMessage);
                System.out.println("Decrypted message: " + decryptedMessage);

                String response = "Server received your message: " + decryptedMessage;
                System.out.println("Sending response to client: " + response);
                writer.println(response);
            } catch (IOException e) {
                System.err.println("Error in server-client communication: " + e.getMessage());
            } finally {
                System.out.println("Finished processing client request");
            }
        }
    }

    static String decryptMessage(String encryptedMessage) {
        int shift = 3; // Должен совпадать со сдвигом в прокси-сервере
        StringBuilder decryptedMessage = new StringBuilder();

        for (char c : encryptedMessage.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base - shift + 26) % 26 + base);
            }
            decryptedMessage.append(c);
        }

        return decryptedMessage.toString();
    }

}
