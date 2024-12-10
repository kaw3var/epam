package vol9;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;

class FileNumberProcessTest {

    private static final String validFile = "test_numbers.txt";
    private static final String invalidFile = "invalid_numbers.txt";
    
    @BeforeEach
    void setUp() throws IOException {
        // Создание тестового файла с числами для проверки
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(validFile))) {
            writer.write("12.5\n");
            writer.write("3.14\n");
            writer.write("-7.8\n");
            writer.write("0.0\n");
            writer.write("45.6\n");
            writer.write("5.53\n");
            writer.write("75.8\n");
            writer.write("1.12\n");
        }
    }

    // Тест на корректное чтение чисел из файла
    @Test
    void testReadNumbersFrom_ValidFile() throws Exception {
        List<Double> numbers = FileNumberProcess.readNumbersFromFile(validFile);

        assertEquals(8, numbers.size(), "Должно быть 8 чисел в файле.");
        assertTrue(numbers.contains(12.5), "Число 12.5 должно быть в списке.");
        assertTrue(numbers.contains(3.14), "Число 3.14 должно быть в списке.");
        assertTrue(numbers.contains(-7.8), "Число -7.8 должно быть в списке.");
    }

    // Тест на отсутствие файла
    @Test
    void testReadNumbersFrom_InvalidFile() {
        assertThrows(FileNotFoundException.class, () -> {
            FileNumberProcess.readNumbersFromFile(invalidFile);
        }, "Файл не должен существовать.");
    }

    // Тест на некорректное чтение в файле
    @Test
    void testReadNumbersFrom_InvalidNumber() throws IOException {
        // Создаём файл с некорректным числом
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("invalid_number.txt"))) {
            writer.write("12.5\n");
            writer.write("abc\n");
            writer.write("3.14\n");
        }

        assertThrows(FileNumberProcess.InvalidNumberException.class, () -> {
            FileNumberProcess.readNumbersFromFile("invalid_number.txt");
        }, "Должно быть выброшено исключение для некорректного числа.");
    }

    @Test
    void testCalculateSum() throws Exception {
        List<Double> numbers = Arrays.asList(12.5, 3.14, -7.8, 0.0, 45.6, 5.53, 75.8, 1.12);
        double sum = FileNumberProcess.calculateSum(numbers);
        
        assertEquals(135.89, sum, "Сумма чисел должна быть 135.89");
    }

    @Test
    void testCalculateAvg() throws Exception {
        List<Double> numbers = Arrays.asList(12.5, 3.14, -7.8, 0.0, 45.6, 5.53, 75.8, 1.12);
        double average = FileNumberProcess.calculateAverage(numbers);
        
        assertEquals(16.98625, average, "Среднее значение должно быть 16.98625");
    }

    @Test
    void testCalculateAvg_EmptyList() {
        List<Double> numbers = new ArrayList<>();
        
        assertThrows(ArithmeticException.class, () -> {
            FileNumberProcess.calculateAverage(numbers);
        }, "Должно быть выброшено исключение при расчёте среднего значения для пустого списка.");
    }

    // Удаление временных файлов созданные после теста
    @AfterEach
    void tearDown() {
        new File(validFile).delete();
        new File("invalid_number.txt").delete();
    }
}