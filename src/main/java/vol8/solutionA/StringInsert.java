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

        StringBuilder stringBuilder = new StringBuilder(text);
        stringBuilder.insert(k + 1, substring);

        return stringBuilder.toString();
    }
}
