package vol1.a;

import java.util.Random;

public class A3 {
    public static void main(String[] args) {
        Random random = new Random();
        if (args.length > 0) {
            try {
                int count = Integer.parseInt(args[0]);

                System.out.println("Случайные числа с переходом на новую строку:");
                for (int i = 0; i < count; i++) {
                    System.out.println(random.nextInt(100));
                }

                System.out.println("\nСлучайные числа без перехода на новую строку:");
                for (int i = 0; i < count; i++) {
                    System.out.print(random.nextInt(100) + " ");
                }

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: аргумент должен быть числом.");
            }
        } else {
            System.out.println("Ошибка: введите количество случайных чисел через аргументы командной строки.");
        }
    }
}
