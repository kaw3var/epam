package vol1.a;

public class A4 {
    public static void main(String[] args) {
        String samplePassword = "qwerty";
        if (args.length > 0) {
            String inputPassword = args[0];

            if (inputPassword.equals(samplePassword)) {
                System.out.println("Пароль верен!");
            } else {
                System.out.println("Пароль неверен.");
            }
        } else {
            System.out.println("Ошибка: введите пароль через аргументы командной строки.");
        }
    }
}
