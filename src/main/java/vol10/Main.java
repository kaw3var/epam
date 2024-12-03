package vol10;

import vol10.solutionA.WordMatcher;
import vol10.solutionB.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Чтение текста из файла input.txt
            List<String> lines = Files.readAllLines(Paths.get("input.txt"));

            // Нахождение подходящих слов
            List<String> matchingWords = WordMatcher.findMatchingWords(lines);

            // Форматирование результата
            StringBuilder output = new StringBuilder();
            if (!matchingWords.isEmpty()) {
                for (int i = 0; i < matchingWords.size(); i += 2) {
                    output.append(matchingWords.get(i))
                            .append(" -> ")
                            .append(matchingWords.get(i + 1))
                            .append(System.lineSeparator());
                }
            } else {
                output.append("No matching words found").append(System.lineSeparator());
            }

            // Запись результата в output.txt
            Files.write(Paths.get("output.txt"), output.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            // Вывод результата на экран
            System.out.println("Результат записан в файл output.txt:");
            System.out.println(output);
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }

        // vol10.solutionB

        Salad salad = new Salad();

        // Добавление овощей в салат
        salad.addIngredient(new Carrot(130));
        salad.addIngredient(new Tomato(150));
        salad.addIngredient(new Cucumber(180));

        // Подсчет калорийности
        System.out.println("Общая калорийность салата: " + salad.getTotalCalories() + " ккал");

        // Сортировка по весу
        salad.sortIngredientsByWeight();
        System.out.println("Сортированные ингредиенты по весу: " + salad);

        // Поиск овощей по диапазону калорийности
        double minCalories = 10;
        double maxCalories = 50;
        List<Vegetable> veggiesInRange = salad.findVegetablesByCaloriesRange(minCalories, maxCalories);
        System.out.println("Овощи в диапазоне " + minCalories + " - " + maxCalories + " ккал: " + veggiesInRange);

        // Сохранение салата в файл
        String filename = "salad.ser";
        SaladConnector.saveSalad(salad, filename);

        // Загрузка салата из файла
        Salad loadedSalad = SaladConnector.loadSalad(filename);
        System.out.println("Загруженный салат из файла:");
        System.out.println(loadedSalad);

        // vol10.solutionС

    }
}
