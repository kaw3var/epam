package vol14.solutionA;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    private Thread serverThread;
    private ServerSocket testServerSocket;

    @BeforeEach
    void setUp() {
        try {
            testServerSocket = new ServerSocket(0); // Выбираем доступный порт
            int serverPort = testServerSocket.getLocalPort();

            serverThread = new Thread(() -> {
                Server.main(new String[]{String.valueOf(serverPort)});
            });
            serverThread.setDaemon(true);
            serverThread.start();

            waitForServerToStart(serverPort); // Новая функция ожидания запуска
        } catch (IOException e) {
            fail("Failed to set up test server: " + e.getMessage());
        }
    }

    private void waitForServerToStart(int port) {
        for (int i = 0; i < 5; i++) {
            try (Socket socket = new Socket("localhost", port)) {
                if (socket.isConnected()) {
                    return;
                }
            } catch (IOException ignored) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        fail("Server did not start within the expected time.");
    }

    @AfterEach
    void tearDown() {
        try {
            if (testServerSocket != null && !testServerSocket.isClosed()) {
                testServerSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing test server socket: " + e.getMessage());
        }
        serverThread.interrupt();
        Server.shutdown(); // Если добавить метод завершения работы сервера
    }

    @Test
    void testClientConnection() throws IOException {
        try (Socket clientSocket = new Socket("localhost", testServerSocket.getLocalPort())) {
            assertTrue(clientSocket.isConnected(), "Client should connect to the server successfully.");
        }
    }

    @Test
    void testMessageSending() throws IOException {
        int port = testServerSocket.getLocalPort();

        try (Socket clientSocket = new Socket("localhost", port)) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Отправляем сообщение на сервер
            writer.write("Hello Server!");
            writer.newLine();
            writer.flush();

            // Ждем ответа от сервера
            Thread.sleep(500);

            // Проверяем, что сервер ответил
            assertTrue(reader.ready(), "Server should respond to the message.");
            String serverResponse = reader.readLine();
            assertNotNull(serverResponse, "Server response should not be null.");
            assertEquals("Message received: Hello Server!", serverResponse, "Server response should match expected message.");
        } catch (InterruptedException e) {
            fail("Test interrupted: " + e.getMessage());
        }
    }

    @Test
    void testClientDisconnection() throws IOException, InterruptedException {
        int port = testServerSocket.getLocalPort();

        try (Socket clientSocket = new Socket("localhost", port)) {
            assertTrue(clientSocket.isConnected(), "Client should connect successfully.");
        }

        // Ждём удаления клиента из списка
        Thread.sleep(500);

        // Проверяем список клиентов
        CopyOnWriteArrayList<?> clients = getConnectedClients();
        assertTrue(clients.isEmpty(), "Client list should be empty after disconnection.");
    }

    // Вспомогательный метод для получения списка клиентов через рефлексию
    private CopyOnWriteArrayList<?> getConnectedClients() {
        try {
            var field = Server.class.getDeclaredField("connectedClients");
            field.setAccessible(true);
            return (CopyOnWriteArrayList<?>) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to access connected clients: " + e.getMessage());
            return null;
        }
    }
}
