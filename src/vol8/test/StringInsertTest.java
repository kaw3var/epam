package vol8.test;

import org.junit.jupiter.api.Test;
import vol8.solutionA.StringInsert;

import static org.junit.jupiter.api.Assertions.*;

public class StringInsertTest {

    private static final String TEXT = "В тексте после k-го символа вставить заданную подстроку";
    private static final String SUBSTRING = "ВСТАВКА";

    @Test
    public void testInsertSubstringMiddle() {
        String result = StringInsert.insertSubstring(TEXT, 18, SUBSTRING);
        assertEquals("В тексте после k-гоВСТАВКА символа вставить заданную подстроку", result);
    }

    @Test
    public void testInsertSubstringAtStart() {
        String result = StringInsert.insertSubstring(TEXT, 0, SUBSTRING);
        assertEquals("ВВСТАВКА тексте после k-го символа вставить заданную подстроку", result);
    }

    @Test
    public void testInsertSubstringAtEnd() {
        String result = StringInsert.insertSubstring(TEXT, TEXT.length() - 1, SUBSTRING);
        assertEquals("В тексте после k-го символа вставить заданную подстрокуВСТАВКА", result);
    }

    @Test
    public void testInsertSubstringOutOfBoundsPositive() {
        String result = StringInsert.insertSubstring(TEXT, 100, SUBSTRING);
        assertEquals("В тексте после k-го символа вставить заданную подстрокуВСТАВКА", result);
    }

    @Test
    public void testInsertSubstringOutOfBoundsNegative() {
        String result = StringInsert.insertSubstring(TEXT, -1, SUBSTRING);
        assertEquals("ВСТАВКАВ тексте после k-го символа вставить заданную подстроку", result);
    }
}
