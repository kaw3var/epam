package vol11.solutionA;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PoemSorterTest {

//    Тест на сортировку по длине
    @Test
    void testSortPoemLinesByLength_withValidLines() {
        List<String> input = Arrays.asList(
                "Быть или не быть, вот в чем вопрос. Достойно ль",
                "Смиряться под ударами судьбы",
                "Иль надо оказать сопротивленье",
                "И в смертной схватке с целым морем бед"
        );
        List<String> expected = Arrays.asList(
                "Смиряться под ударами судьбы",
                "Иль надо оказать сопротивленье",
                "И в смертной схватке с целым морем бед",
                "Быть или не быть, вот в чем вопрос. Достойно ль"
        );

        List<String> result = PoemSorter.sortPoemLinesByLength(input);
        assertEquals(expected, result, "Сортировка строк по длине выполнена неверно");
    }

//    Тест на пустой входной список
    @Test
    void testSortPoemLinesByLength_withEmptyList() {
        List<String> input = Collections.emptyList();
        List<String> result = PoemSorter.sortPoemLinesByLength(input);

        assertTrue(result.isEmpty(), "Результат должен быть пустым для пустого входного списка");
    }

//    Тест на null
    @Test
    void testSortPoemLinesByLength_withNullInput() {
        List<String> result = PoemSorter.sortPoemLinesByLength(null);

        assertTrue(result.isEmpty(), "Результат должен быть пустым для null входного значения");
    }

//    Тест на равную длину строк
    @Test
    void testSortPoemLinesByLength_withEqualLengthLines() {
        List<String> input = Arrays.asList("Строка", "Другая", "Курьер");
        List<String> expected = Arrays.asList("Строка", "Другая", "Курьер");

        List<String> result = PoemSorter.sortPoemLinesByLength(input);
        assertEquals(expected, result, "Порядок строк одинаковой длины должен сохраняться");
    }

//    Тест на список из одной строки
    @Test
    void testSortPoemLinesByLength_withSingleLine() {
        List<String> input = Collections.singletonList("Только одна строка");
        List<String> result = PoemSorter.sortPoemLinesByLength(input);

        assertEquals(input, result, "Список из одной строки должен остаться неизменным");
    }
}
