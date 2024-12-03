package vol1.taskB;

import java.util.*;

public class SolutionB {
    public static void isEmpty(List<Integer> arr) {
        if (arr.isEmpty()) {
            System.out.println("Список пустой");
        }
    }

    public static void evenAndOdd(List<Integer> arr) {
        isEmpty(arr);
        System.out.println("Задание B1");
        for (int el : arr) {
            if (el % 2 == 0) {
                System.out.println("Четное: " + el);
            } else {
                System.out.println("Нечетное: " + el);
            }
        }
    }

    public static void minMax(List<Integer> arr) {
        isEmpty(arr);
        System.out.println("Задание B2");
        int max = arr.get(0);
        int min = arr.get(0);
        for (int el : arr) {
            if (max < el) {
                max = el;
            }
            if (min > el) {
                min = el;
            }
        }
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
    }

    public static void dividedBy3Else9(List<Integer> arr) {
        isEmpty(arr);
        System.out.println("Задание B3");
        for (int el : arr) {
            if (el % 3 == 0) {
                System.out.println(el + " ");
            }
        }
    }

    public static void dividedBy5And7(List<Integer> arr) {
        isEmpty(arr);
        System.out.println("Задание B4");
        for (int el : arr) {
            if (el % 5 == 0 & el % 7 == 0) {
                System.out.println(el + " ");
            }
        }
    }

    public static void isSimple(List<Integer> arr) {
        isEmpty(arr);
        System.out.println("Задание B5");
        for (int el : arr) {
            if (isPrime(el)) {
                System.out.println(el + " ");
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void uniqueThreeDigits(List<Integer> arr) {
        System.out.println("Задание B6");
        for (int el : arr) {
            if (hasUniqueDigits(el)) {
                System.out.println(el + " ");
            }
        }
    }

    public static boolean hasUniqueDigits(int num) {
        int hundred = num / 100;
        int ten = num / 10 % 10;
        int unit = num % 10;
        return hundred != ten && hundred != unit && ten != unit;
    }

    public static void sortedArray(List<Integer> arr) {
        isEmpty(arr);
        System.out.println("Задание B7");
        List<Integer> tempArr = new ArrayList<>();
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr.get(j) > arr.get(i + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }

    public static void frequencySort(List<Integer> arr) {
        isEmpty(arr);
        System.out.println("Задание В8");
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int freqComparison = o2.getValue().compareTo(o1.getValue());
                if (freqComparison == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return freqComparison;
            }
        });


        System.out.println("Числа в порядке частоты убывания");
        for (Map.Entry<Integer, Integer> entry : entryList) {
            System.out.println("Число: " + entry.getKey() + ",\tЧастота: " +entry.getValue());
        }
    }

    public static void checkHappyNumbers(List<Integer> numbers) {
        System.out.println("Задание В9");
        for (int number : numbers) {
            if (isHappy(number)) {
                System.out.println(number + " счастливое число.");
            } else {
                System.out.println(number + " не счастливое число.");
            }
        }
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        while (n != 1 && !seenNumbers.contains(n)) {
            seenNumbers.add(n);
            n = sumOfSquaresOfDigits(n);
        }
        return n == 1;
    }

    private static int sumOfSquaresOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void checkPalindrome(List<Integer> numbers) {
        System.out.println("Задание В10");
        for (int number : numbers) {
            if (isPalindrome(number)) {
                System.out.println(number + " палиндром.");
            } else {
                System.out.println(number + " не палиндром.");
            }
        }
    }

    public static boolean isPalindrome(int n) {
        String original = Integer.toString(n);
        String reversed = new StringBuilder(original).reverse().toString();
        return original.equals(reversed);
    }

    public static void findHalfSum(List<Integer> numbers) {
        System.out.println("Задание В11");
        for (int i = 1; i < numbers.size() - 1; i++) {
            int halfSum = (numbers.get(i - 1) + numbers.get(i + 1)) / 2;
            if (numbers.get(i) == halfSum) {
                System.out.println("Элемент " + numbers.get(i) + " равен полусумме соседних элементов.");
            }
        }
    }
}