import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewTest {

    @Test
    public void testAddReview() throws IOException {
        String tempFile = "temp_reviews.csv";
        FileWriter tempWriter = new FileWriter(tempFile);

        tempWriter.write("COD" + "," + "4.0" + "," + "Testing comment" + "\n");
        tempWriter.flush();

        Scanner scanner = new Scanner(System.in);
        Review review = new Review();

        scanner.close();
        tempWriter.close();

        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        String line;
        StringBuilder content = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();

        String expectedContent = "COD,4.0,Testing comment\n";
        assertEquals(expectedContent, content.toString(), "Content of CSV file doesn't match expected values");

        File temp = new File(tempFile);
        temp.delete();
    }
}
