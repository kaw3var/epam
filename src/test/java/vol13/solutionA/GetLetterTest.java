package vol13.solutionA;

import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetLetterTest {

    @Test
    void testGetUsersWithMinLetterLength() throws SQLException {
        GetLetter getLetter = new GetLetter();
        List<Person> users = getLetter.getUsersWithMinLetterLength();
        assertNotNull(users);
        assertTrue(users.size() > 0);
    }

    @Test
    void testGetUsersWithReceivedSubject() throws SQLException {
        GetLetter getLetter = new GetLetter();
        List<Person> users = getLetter.getUsersWithReceivedSubject("Java");
        assertNotNull(users);
        assertTrue(users.size() > 0);
    }

    @Test
    void testGetUsersWithoutReceivedSubject() throws SQLException {
        GetLetter getLetter = new GetLetter();
        List<Person> users = getLetter.getUsersWithoutReceivedSubject("Java");
        assertNotNull(users);
        assertTrue(users.size() > 0);
    }
}
