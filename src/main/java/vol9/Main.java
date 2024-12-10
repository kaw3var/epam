package vol9;

import java.io.FileNotFoundException;
import java.util.List;

import static vol9.FileNumberProcess.*;

public class Main {
    public static void main(String[] args) {
        String filename = "numbers.txt";
        try {
            List<Double> numbers = readNumbersFromFile(filename);
            if (numbers.isEmpty()) {
                System.out.println("Ошибка: Файл пуст.");
            } else {
                double sum = calculateSum(numbers);
                double average = calculateAverage(numbers);

                System.out.println("Сумма чисел: " + sum);
                System.out.println("Среднее значение: " + average);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден.");
        } catch (InvalidNumberException e) {
            System.out.println("Ошибка: Некорректное число в файле.");
        } catch (OutOfMemoryError e) {
            System.out.println("Ошибка: Недостаточно памяти для обработки данных.");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Невозможно вычислить среднее значение для пустого списка.");
        }
    }
}