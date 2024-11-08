import vol4.SolutionA.*;
import vol4.SolutionB.*;
import vol5.GradeBook;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.print("Введите размер массива: ");
//        int size = scanner.nextInt();
//        List<Integer> array = new ArrayList<>(size);
//        for (int i = 0; i < size; i++) {
//            int num = scanner.nextInt();
//            array.add(num);
//        }

//        SolutionB.evenAndOdd(array);
//        SolutionB.minMax(array);
//        SolutionB.dividedBy3Else9(array);
//        SolutionB.dividedBy5And7(array);
//        SolutionB.isSimple(array);
//        SolutionB.uniqueThreeDigits(array);
//        SolutionB.sortedArray(array);
//        SolutionB.frequencySort(array);
//        SolutionB.checkHappyNumbers(array);
//        SolutionB.checkPalindrome(array);
//        SolutionB.findHalfSum(array);

        /** Глава 2 Вариант А*/

//        scanner.nextLine();
//        String[] numbers = new String[size];
//        System.out.println("Введите числа: ");
//        for (int i = 0; i < size; i++) {
//            numbers[i] = scanner.nextLine();
//        }
//
//        SolutionA.NumberOperations.findShortestAndLongest(numbers);
//        SolutionA.NumberOperations.sortByLength(numbers, true);
//        SolutionA.NumberOperations.printNumbersByAverageLength(numbers);
//        SolutionA.NumberOperations.findNumberWithMinUniqueDigits(numbers);
//        SolutionA.NumberOperations.findNumbersWithOnlyEvenDigits(numbers);
//        SolutionA.NumberOperations.findNumberWithIncreasingDigits(numbers);
//        SolutionA.NumberOperations.findNumberWithUniqueDigits(numbers);
//        SolutionA.NumberOperations.findSecondPalindrome(numbers);
//
//        SolutionA.NumberOperations.findQuadraticRoots(1, -3, 2);
//
//        System.out.println("\nРазработчик: Жамбалов Батор Аюрович");
//        System.out.println("Дата получения задания: 01.10.2024");
//        System.out.println("Дата сдачи задания: " + new java.util.Date());

        /** Глава 4 Вариант А Задание 4*/
//        Столица
        City capital = new City("Москва");

//        Государство
        State state = new State("Россия", capital);

//        Области
        Region moscowRegion = new Region("Московская область", 45900, new City("Москва"));
        Region leningradRegion = new Region("Ленинградская область", 84500, new City("Санкт-Петербург"));
        Region krasnodarRegion = new Region("Краснодарский край", 76000, new City("Краснодар"));

//        Создание района, добавление в город, добавление в область
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

//        Добавление области в государство
        state.addRegion(moscowRegion);
        state.addRegion(leningradRegion);
        state.addRegion(krasnodarRegion);

//        Вывод
        state.printCapital();
        state.printRegionCount();
        state.printTotalArea();
        state.printRegionalCenters();

        /** Глава 4 Вариант Б Задание 4*/
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


        /** Глава 5 Задание 4*/
        GradeBook gradeBook = new GradeBook("Олег", "Тиньков", "Б762-1", 12);

        GradeBook.Session session1 = gradeBook.new Session("Сессия 1 2024");

        session1.addSubject("ООП", true, "Хорошо");
        session1.addSubject("База данных", true, "Отлично");
        session1.addSubject("Веб-разработка", false, "Зачет");
        session1.addSubject("Операционные системы", true, "Хорошо");

        gradeBook.addSession(session1);
        gradeBook.printGradeBook();

        scanner.close();
    }
}