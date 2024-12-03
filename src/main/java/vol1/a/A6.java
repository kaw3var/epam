package vol1.a;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class A6 {
    public static void main(String[] args) {
        String developerSurname = "Жамбалов";

        LocalDateTime taskReceived = LocalDateTime.now();
        LocalDateTime taskSubmitted = taskReceived.plusMinutes(5);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("Фамилия разработчика: " + developerSurname);
        System.out.println("Дата и время получения задания: " + taskReceived.format(formatter));
        System.out.println("Дата и время сдачи задания: " + taskSubmitted.format(formatter));
    }
}
