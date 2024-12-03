package vol1.a;

public class A5 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Ошибка: введите целые числа в качестве аргументов командной строки.");
            return;
        }

        int sum = 0;
        int multi = 1;

        for (String arg : args) {
            try {
                int number = Integer.parseInt(arg);
                sum += number;
                multi *= number;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: '" + arg + "' не является целым числом.");
                return;
            }
        }

        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + multi);
    }
}
