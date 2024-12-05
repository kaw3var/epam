package vol9;

import java.io.*;
import java.util.*;
import java.util.Locale;

public class MyException {
    public static List<Double> readNumbersFromFile(String filename) throws FileNotFoundException, InvalidNumberException {
        List<Double> numbers = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Locale locale = Locale.UK;
                    Double number = parseNumber(line, locale);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    throw new InvalidNumberException("Некорректное число: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Файл не найден: " + filename);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + e.getMessage());
        }

        return numbers;
    }

    public static Double parseNumber(String numberStr, Locale locale) throws NumberFormatException {
        try {
            // Пытаемся преобразовать строку в число с учетом локали
            return Double.parseDouble(numberStr.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Не удалось преобразовать строку в число: " + numberStr);
        }
    }

    public static double calculateSum(List<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }

    public static double calculateAverage(List<Double> numbers) {
        if (numbers.isEmpty()) {
            throw new ArithmeticException("Невозможно вычислить среднее значение для пустого списка.");
        }
        return calculateSum(numbers) / numbers.size();
    }

    // Пользовательское исключение для некорректных чисел
    public static class InvalidNumberException extends Exception {
        public InvalidNumberException(String message) {
            super(message);
        }
    }
}
