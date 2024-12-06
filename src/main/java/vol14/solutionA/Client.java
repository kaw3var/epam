package vol14.solutionA;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Адрес сервера
        int serverPort = 6000; // Порт сервера

        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to server. Waiting for messages...");

            // Чтение сообщений от сервера
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Message from server: " + message);
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
