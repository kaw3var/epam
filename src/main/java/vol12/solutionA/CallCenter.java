package vol12.solutionA;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class CallCenter {
    private final BlockingQueue<Operator> operatorsQueue;

    // Конструктор CallCenter
    // @param numberOfOperators количество операторов в CallCenter
    public CallCenter(int numberOfOperators) {
        this.operatorsQueue = new LinkedBlockingQueue<>();
        for (int i = 1; i <= numberOfOperators; i++) {
            operatorsQueue.offer(new Operator("Operator-" + i));
        }
    }

    // Метод для обработки вызова клиента
    // @param client клиент, который вызывает CallCenter
    public void handleCall(Client client) {
        try {
            Operator operator = operatorsQueue.poll(5, TimeUnit.SECONDS);
            if (operator != null) {
                operator.handle(client);
                operatorsQueue.offer(operator); // Возврат оператора в очередь
            } else {
                System.out.println(client.getName() + " не дождался ответа и положил трубку.");
                client.callAgain(this); // Клиент перезванивает
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Произошла ошибка в работе CallCenter.");
        }
    }
}