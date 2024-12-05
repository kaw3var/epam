package vol12;

import vol12.solutionA.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int numberOfOperators = 3;
        int numberOfClients = 10;

        CallCenter callCenter = new CallCenter(numberOfOperators);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfClients);

        for (int i = 1; i <= numberOfClients; i++) {
            executorService.submit(new Client("Клиентpackage vol12.solutionA;\n" +
                    "\n" +
                    "import org.junit.jupiter.api.Test;\n" +
                    "import static org.junit.jupiter.api.Assertions.*;\n" +
                    "\n" +
                    "import java.util.concurrent.*;\n" +
                    "\n" +
                    "class CallCenterTest {\n" +
                    "\n" +
                    "    @Test\n" +
                    "    void testCallCenterHandlesCalls() throws InterruptedException {\n" +
                    "        // Создаем CallCenter с 2 операторами\n" +
                    "        CallCenter callCenter = new CallCenter(2);\n" +
                    "\n" +
                    "        // Создаем клиентов\n" +
                    "        Client client1 = new Client(\"Client-1\", callCenter);\n" +
                    "        Client client2 = new Client(\"Client-2\", callCenter);\n" +
                    "        Client client3 = new Client(\"Client-3\", callCenter);\n" +
                    "\n" +
                    "        // Создаем ExecutorService для запуска потоков\n" +
                    "        ExecutorService executor = Executors.newFixedThreadPool(3);\n" +
                    "\n" +
                    "        // Запускаем клиентов в потоках\n" +
                    "        executor.submit(client1);\n" +
                    "        executor.submit(client2);\n" +
                    "        executor.submit(client3);\n" +
                    "\n" +
                    "        // Ждем завершения работы клиентов\n" +
                    "        executor.shutdown();\n" +
                    "        executor.awaitTermination(10, TimeUnit.SECONDS);\n" +
                    "\n" +
                    "        // Проверяем, что тест прошел без ошибок\n" +
                    "        assertTrue(executor.isTerminated(), \"Не все потоки завершили выполнение.\");\n" +
                    "    }\n" +
                    "\n" +
                    "    @Test\n" +
                    "    void testOperatorQueueHandling() throws InterruptedException {\n" +
                    "        // Создаем CallCenter с 1 оператором\n" +
                    "        CallCenter callCenter = new CallCenter(1);\n" +
                    "\n" +
                    "        // Создаем 3 клиентов\n" +
                    "        Client client1 = new Client(\"Client-1\", callCenter);\n" +
                    "        Client client2 = new Client(\"Client-2\", callCenter);\n" +
                    "        Client client3 = new Client(\"Client-3\", callCenter);\n" +
                    "\n" +
                    "        // Создаем ExecutorService для запуска потоков\n" +
                    "        ExecutorService executor = Executors.newFixedThreadPool(3);\n" +
                    "\n" +
                    "        // Запускаем клиентов в потоках\n" +
                    "        executor.submit(client1);\n" +
                    "        executor.submit(client2);\n" +
                    "        executor.submit(client3);\n" +
                    "\n" +
                    "        // Ждем завершения работы клиентов\n" +
                    "        executor.shutdown();\n" +
                    "        executor.awaitTermination(10, TimeUnit.SECONDS);\n" +
                    "\n" +
                    "        // Проверяем, что все клиенты были обслужены\n" +
                    "        // Поскольку у нас 1 оператор, клиентов должно обслужить по очереди.\n" +
                    "        assertTrue(executor.isTerminated(), \"Не все потоки завершили выполнение.\");\n" +
                    "    }\n" +
                    "}\n-" + i, callCenter));
        }

        executorService.shutdown();
    }
}
