package vol4;

import vol4.solutionA.*;
import vol4.solutionB.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Столица
        City capital = new City("Москва");

        // Государство
        State state = new State("Россия", capital);

        // Области
        Region moscowRegion = new Region("Московская область", 45900, new City("Москва"));
        Region leningradRegion = new Region("Ленинградская область", 84500, new City("Санкт-Петербург"));
        Region krasnodarRegion = new Region("Краснодарский край", 76000, new City("Краснодар"));

        // Создание района, добавление в город, добавление в область
        District sergievPosadDistrict = new District("Сергиево-Посадский район");
        District domodedovoDistrict = new District("Домодедовский район");
        District novorossiyskDistrict = new District("Новороссийский район");
        District sochiDistrict = new District("Сочинский район");

        sergievPosadDistrict.addCity(new City("Сергиев Посад"));
        domodedovoDistrict.addCity(new City("Домодедово"));
        novorossiyskDistrict.addCity(new City("Новороссийск"));
        sochiDistrict.addCity(new City("Сочи"));

        moscowRegion.addDistrict(sergievPosadDistrict);
        moscowRegion.addDistrict(domodedovoDistrict);
        krasnodarRegion.addDistrict(novorossiyskDistrict);
        krasnodarRegion.addDistrict(sochiDistrict);

        // Добавление области в государство
        state.addRegion(moscowRegion);
        state.addRegion(leningradRegion);
        state.addRegion(krasnodarRegion);

        // Вывод данных
        System.out.println("Столица государства " + state.getName() + ": " + state.getCapital().getName());
        System.out.println("Количество областей: " + state.getRegionCount());
        System.out.println("Общая площадь государства: " + state.getTotalArea() + " км²");
        System.out.println("Областные центры:");
        for (City regionalCenter : state.getRegionalCenters()) {
            System.out.println(" --- " + regionalCenter.getName());
        }

        /** Глава 4 Вариант Б Задание 4 **/
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
    }
}
