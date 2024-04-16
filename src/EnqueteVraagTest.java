import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

public class EnqueteVraagTest {

    @Test
    public void testReadQuestionsFromCSV() {
        try {
            List<String> questions = EnqueteVraag.readQuestionsFromCSV("openVragen.csv");
            assertEquals(3, questions.size());
            assertEquals("open vragen test: wat is je naam?", questions.get(0));
            assertEquals("open vragen test1: wat is je leeftijd?", questions.get(1));
             assertEquals("open vragen test2 : wat is je afkomst?", questions.get(2));
        } catch (IOException e) {
            fail("IOException thrown while reading questions from CSV");
        }
    }
}
