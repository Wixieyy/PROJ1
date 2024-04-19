import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class EnqueteVraag {
    protected String vraag;
    protected String antwoord;

    public EnqueteVraag() {}
    public EnqueteVraag(String vraag, String antwoord) {
        this.vraag = vraag;
        this.antwoord = antwoord;
    }

    public void voerEnqueteUit() {
        OpenGeslotenVraag.geslotenVragen();
    }

    public static List<String> readQuestionsFromCSV(String filename) throws IOException {
        List<String> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                questions.add(line);
            }
        }
        return questions;
    }
}
