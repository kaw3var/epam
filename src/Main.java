import vol1.taskB.*;
import vol2.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        List<Integer> array = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            int num = scanner.nextInt();
            array.add(num);
        }

//        SolutionB.evenAndOdd(array);
//        SolutionB.minMax(array);
//        SolutionB.dividedBy3Else9(array);
//        SolutionB.dividedBy5And7(array);
//        SolutionB.isSimple(array);
//        SolutionB.uniqueThreeDigits(array);
//        SolutionB.sortedArray(array);
        SolutionB.frequencySort(array);
        SolutionB.checkHappyNumbers(array);
        SolutionB.checkPalindrome(array);
        SolutionB.findHalfSum(array);

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

        scanner.close();
    }
}