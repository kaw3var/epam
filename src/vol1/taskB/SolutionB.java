package vol1.taskB;

import java.util.*;

public class SolutionB {
    public static void isEmpty(ArrayList<Integer> arr) {
        if (arr.isEmpty()) {
            System.out.println("Список пустой");
        }
    }

    public static void evenAndOdd(ArrayList<Integer> arr) {
        isEmpty(arr);
        for (int el : arr) {
            if (el % 2 == 0) {
                System.out.println("Четное: " + el);
            } else {
                System.out.println("Нечетное: " + el);
            }
        }
    }

    public static void minMax(ArrayList<Integer> arr) {
        isEmpty(arr);
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

    public static void dividedBy3Else9(ArrayList<Integer> arr) {
        isEmpty(arr);
        for (int el : arr) {
            if (el % 3 == 0) {
                System.out.print(el + " ");
            }
        }
        System.out.println();
    }

    public static void dividedBy5And7(ArrayList<Integer> arr) {
        isEmpty(arr);
        for (int el : arr) {
            if (el % 5 == 0 & el % 7 == 0) {
                System.out.print(el + " ");
            }
        }
        System.out.println();
    }

    public static void isSimple(ArrayList<Integer> arr) {
        isEmpty(arr);
        for (int el : arr) {
            if (isPrime(el)) {
                System.out.println(el + " ");
            }
        }
        System.out.println();
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

    public static void uniqueThreeDigits(ArrayList<Integer> arr) {
        for (int el : arr) {
            if (hasUniqueDigits(el)) {
                System.out.println(el + " ");
            }
        }
        System.out.println();
    }

    public static boolean hasUniqueDigits(int num) {
        int hundred = num / 100;
        int ten = num / 10 % 10;
        int unit = num % 10;
        return hundred != ten && hundred != unit && ten != unit;
    }

    public static void sortedArray(ArrayList<Integer> arr) {
        isEmpty(arr);
        ArrayList<Integer> tempArr = new ArrayList<>();
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

    public static void frequencySort(ArrayList<Integer> arr) {
        isEmpty(arr);
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
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
}