package vol8.solutionA;

import java.util.Scanner;

// В тексте ПОСЛЕ k-го символа вставить заданную подстроку

public class StringInsert {
    public static String insertSubstring(String text, int k, String substring) {
        if (text == null || substring == null) {
            throw new IllegalArgumentException("Текст и подстрока не должны быть null");
        }
        if (k < 0) {
            // Если k меньше 0, то подстрока вставляется в начало текста
            return substring + text;
        } else if (k >= text.length()) {
            // Если k больше, то подстрока вставляется в конец
            return text + substring;
        }

        String beforeK = text.substring(0, k + 1);
        String afterK = text.substring(k + 1);

        return beforeK + substring + afterK;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        System.out.print("Введите подстроку для вставки: ");
        String substring = scanner.nextLine();

        System.out.print("Введите позицию k: ");
        int k = scanner.nextInt();

        try {
            String result = insertSubstring(text, k, substring);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
