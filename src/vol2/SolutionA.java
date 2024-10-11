package vol2;

public class SolutionA {
    public static class NumberOperations {

        /** Метод нахождения самого короткого и самого длинного числа */
        public static void findShortestAndLongest(String[] numbers) {
            System.out.println("Задание А1");
            String shortest = numbers[0];
            String longest = numbers[0];

            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i].length() < shortest.length()) {
                    shortest = numbers[i];
                }
                if (numbers[i].length() > longest.length()) {
                    longest = numbers[i];
                }
            }

            System.out.println("Самое короткое число: " + shortest + ", длина: " + shortest.length());
            System.out.println("Самое длинное число: " + longest + ", длина: " + longest.length());
        }

        /** Метод упорядочивания чисел по длине */
        public static void sortByLength(String[] numbers, boolean ascending) {
            System.out.println("Задание А2");
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = 0; j < numbers.length - i - 1; j++) {
                    if (ascending) {
                        if (numbers[j].length() > numbers[j + 1].length()) {
                            String temp = numbers[j];
                            numbers[j] = numbers[j + 1];
                            numbers[j + 1] = temp;
                        }
                    } else {
                        if (numbers[j].length() < numbers[j + 1].length()) {
                            String temp = numbers[j];
                            numbers[j] = numbers[j + 1];
                            numbers[j + 1] = temp;
                        }
                    }
                }
            }

            System.out.println("Числа в порядке " + (ascending ? "возрастания" : "убывания") + " длины:");
            for (String number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

        /** Метод вывода чисел, длина которых меньше или больше средней */
        public static void printNumbersByAverageLength(String[] numbers) {
            System.out.println("Задание А3");
            int totalLength = 0;
            for (String number : numbers) {
                totalLength += number.length();
            }
            double averageLength = (double) totalLength / numbers.length;

            System.out.println("Числа, длина которых меньше средней (" + averageLength + "):");
            for (String number : numbers) {
                if (number.length() < averageLength) {
                    System.out.println(number + " (длина: " + number.length() + ")");
                }
            }
        }

        /** Метод нахождения числа с минимальным количеством различных цифр */
        public static void findNumberWithMinUniqueDigits(String[] numbers) {
            System.out.println("Задание А4");
            String result = numbers[0];
            int minUniqueDigits = countUniqueDigits(numbers[0]);

            for (int i = 1; i < numbers.length; i++) {
                int uniqueDigits = countUniqueDigits(numbers[i]);
                if (uniqueDigits < minUniqueDigits) {
                    result = numbers[i];
                    minUniqueDigits = uniqueDigits;
                }
            }

            System.out.println("Число с минимальным количеством различных цифр: " + result);
        }

        private static int countUniqueDigits(String number) {
            boolean[] digits = new boolean[10];
            int count = 0;

            for (int i = 0; i < number.length(); i++) {
                int digit = Character.getNumericValue(number.charAt(i));
                if (!digits[digit]) {
                    digits[digit] = true;
                    count++;
                }
            }

            return count;
        }

        /** Метод нахождения количества чисел с только четными цифрами */
        public static void findNumbersWithOnlyEvenDigits(String[] numbers) {
            System.out.println("Задание А5");
            int countEvenOddEqual = 0;
            System.out.println("Числа, содержащие только четные цифры:");

            for (String number : numbers) {
                if (containsOnlyEvenDigits(number)) {
                    System.out.print(number + " ");
                    if (hasEqualEvenAndOddDigits(number)) {
                        countEvenOddEqual++;
                    }
                }
            }
            System.out.println("\nКоличество чисел с равным количеством четных и нечетных цифр: " + countEvenOddEqual);
        }

        private static boolean containsOnlyEvenDigits(String number) {
            for (int i = 0; i < number.length(); i++) {
                int digit = Character.getNumericValue(number.charAt(i));
                if (digit % 2 != 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean hasEqualEvenAndOddDigits(String number) {
            int evenCount = 0;
            int oddCount = 0;

            for (int i = 0; i < number.length(); i++) {
                int digit = Character.getNumericValue(number.charAt(i));
                if (digit % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }

            return evenCount == oddCount;
        }

        /** Метод нахождения числа, в котором цифры идут в строгом порядке возрастания */
        public static void findNumberWithIncreasingDigits(String[] numbers) {
            System.out.println("Задание А6");
            String result = "Не найдено";
            for (String number : numbers) {
                if (isDigitsIncreasing(number)) {
                    result = number;
                    break;
                }
            }

            System.out.println("Число с цифрами в строгом порядке возрастания: " + result);
        }

        private static boolean isDigitsIncreasing(String number) {
            for (int i = 1; i < number.length(); i++) {
                if (number.charAt(i) <= number.charAt(i - 1)) {
                    return false;
                }
            }
            return true;
        }

        /** Метод нахождения числа, состоящего только из различных цифр */
        public static void findNumberWithUniqueDigits(String[] numbers) {
            System.out.println("Задание А7");
            String result = "Не найдено";
            for (String number : numbers) {
                if (hasUniqueDigits(number)) {
                    result = number;
                    break;
                }
            }

            System.out.println("Число, состоящее только из различных цифр: " + result);
        }

        private static boolean hasUniqueDigits(String number) {
            boolean[] digits = new boolean[10];
            for (int i = 0; i < number.length(); i++) {
                int digit = Character.getNumericValue(number.charAt(i));
                if (digits[digit]) {
                    return false;
                }
                digits[digit] = true;
            }
            return true;
        }

        /** Метод нахождения второго числа-палиндрома */
        public static void findSecondPalindrome(String[] numbers) {
            System.out.println("Задание А8");
            int palindromeCount = 0;
            for (String number : numbers) {
                if (isPalindrome(number)) {
                    palindromeCount++;
                    if (palindromeCount == 2) {
                        System.out.println("Второе число-палиндром: " + number);
                        return;
                    }
                }
            }
            System.out.println("Второе число-палиндром не найдено");
        }

        private static boolean isPalindrome(String number) {
            int len = number.length();
            for (int i = 0; i < len / 2; i++) {
                if (number.charAt(i) != number.charAt(len - 1 - i)) {
                    return false;
                }
            }
            return true;
        }

        /** Метод нахождения корней квадратного уравнения */
        public static void findQuadraticRoots(double a, double b, double c) {
            System.out.println("Задание А9");
            double discriminant = b * b - 4 * a * c;
            if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("Корни уравнения: " + root1 + " и " + root2);
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                System.out.println("Корень уравнения: " + root);
            } else {
                System.out.println("Уравнение не имеет действительных корней");
            }
        }
    }
}
