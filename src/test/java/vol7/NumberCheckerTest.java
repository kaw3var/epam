package vol7;
import org.junit.jupiter.api.Test;
import vol7.NumberChecker;

import static org.junit.jupiter.api.Assertions.*;

public class NumberCheckerTest {

    @Test
    public void testDivisibleBy13() {
        NumberChecker isDivisibleBy13 = number -> number % 13 == 0;

        // Тест корректных случаев
        assertTrue(isDivisibleBy13.checkDivide(13), "13 должно быть делимым на 13");
        assertTrue(isDivisibleBy13.checkDivide(26), "26 должно быть делимым на 13");
        assertTrue(isDivisibleBy13.checkDivide(0), "0 должно быть делимым на 13");

        // Тест некорректных случаев
        assertFalse(isDivisibleBy13.checkDivide(12), "12 не должно быть делимым на 13");
        assertFalse(isDivisibleBy13.checkDivide(27), "27 не должно быть делимым на 13");
        assertFalse(isDivisibleBy13.checkDivide(-1), "-1 не должно быть делимым на 13");
    }

    @Test
    public void testNegativeNumbers() {
        // Лямбда-выражение для проверки делимости на 13
        NumberChecker isDivisibleBy13 = number -> number % 13 == 0;

        // Тест отрицательных чисел
        assertTrue(isDivisibleBy13.checkDivide(-13), "-13 должно быть делимым на 13");
        assertTrue(isDivisibleBy13.checkDivide(-26), "-26 должно быть делимым на 13");
        assertFalse(isDivisibleBy13.checkDivide(-12), "-12 не должно быть делимым на 13");
    }
}
