package vol8.solutionC;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SentenceFilterTest {

    @Test
    public void testMinimizeSentences() {
        String text = "Вчера я видел интересный фильм. Фильм был очень увлекательным. " +
                "Мы с друзьями поехали в парк. Погода была замечательная. Вечером мы пошли в кино на новый фильм.";

        List<String> result = SentenceFilter.minimizeSentences(text);

        assertEquals(3, result.size());
        assertTrue(result.contains("Вчера я видел интересный фильм."));
        assertTrue(result.contains("Фильм был очень увлекательным."));
        assertTrue(result.contains("Вечером мы пошли в кино на новый фильм."));
    }

    @Test
    public void testEmptyText() {
        String text = "";
        List<String> result = SentenceFilter.minimizeSentences(text);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleSentence() {
        String text = "Вчера я видел интересный фильм.";
        List<String> result = SentenceFilter.minimizeSentences(text);
        assertEquals(1, result.size());
        assertTrue(result.contains("Вчера я видел интересный фильм."));
    }

    @Test
    public void testNoCommonWords() {
        String text = "Я люблю котов. У меня есть собака.";
        List<String> result = SentenceFilter.minimizeSentences(text);
        assertEquals(1, result.size());
    }
}
