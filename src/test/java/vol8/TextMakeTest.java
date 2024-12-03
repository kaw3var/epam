package vol8;

import org.junit.jupiter.api.Test;
import vol8.solutionB.TextMake;
import vol8.solutionB.Word;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TextMakeTest {

    @Test
    void testFindWordsInQuestionsByLength() {
        String text = "Что было написано на лице Пола в его последние мгновения? Он не улыбался. Он не выглядел удовлетворённым. " +
                "Однако на его лице читалось явное облегчение. О чём он хотел сказать перед смертью? Какие лица были у моих прошлых родителей, " +
                "когда они умерли? Почему? Почему я не пошёл увидеть их?";

        TextMake make = new TextMake(text);

        // Проверка слов длиной 5
        Set<Word> wordsOfLength5 = make.findWordsInQuestionsByLength(5);
        assertEquals(5, wordsOfLength5.size());
        assertTrue(wordsOfLength5.contains(new Word("пошёл")));
        assertTrue(wordsOfLength5.contains(new Word("какие")));
        assertTrue(wordsOfLength5.contains(new Word("перед")));
        assertTrue(wordsOfLength5.contains(new Word("когда")));
        assertTrue(wordsOfLength5.contains(new Word("хотел")));

        // Проверка слов длиной 6
        Set<Word> wordsOfLength6 = make.findWordsInQuestionsByLength(6);
        assertEquals(2, wordsOfLength6.size());
        assertTrue(wordsOfLength6.contains(new Word("умерли")));
        assertTrue(wordsOfLength6.contains(new Word("почему")));

        // Проверка слов длиной 7
        Set<Word> wordsOfLength7 = make.findWordsInQuestionsByLength(7);
        assertEquals(4, wordsOfLength7.size());
        assertTrue(wordsOfLength7.contains(new Word("увидеть")));
        assertTrue(wordsOfLength7.contains(new Word("сказать")));
        assertTrue(wordsOfLength7.contains(new Word("смертью")));
        assertTrue(wordsOfLength7.contains(new Word("прошлых")));
    }

    @Test
    void testEmptyText() {
        String text = "";
        TextMake make = new TextMake(text);

        Set<Word> result = make.findWordsInQuestionsByLength(5);
        assertTrue(result.isEmpty());
    }

    @Test
    void testNoQuestions() {
        String text = "Он не улыбался. Он не выглядел удовлетворённым. " +
                "Однако на его лице читалось явное облегчение.";

        TextMake make = new TextMake(text);

        Set<Word> result = make.findWordsInQuestionsByLength(5);
        assertTrue(result.isEmpty());
    }

    @Test
    void testTextWithTabsAndSpaces() {
        String text = "Что\tбыло\t\tнаписано на  лице Пола в его   последние мгновения? " +
                "Какие лица    были  у моих прошлых  родителей, когда  они  умерли? " +
                "Почему?  Почему\tя не   пошёл увидеть их?";

        TextMake make = new TextMake(text);

        Set<Word> result = make.findWordsInQuestionsByLength(5);
        assertTrue(result.contains(new Word("какие")));
        assertTrue(result.contains(new Word("пошёл")));
        assertTrue(result.contains(new Word("когда")));
    }
}
