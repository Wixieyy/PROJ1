import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class VervolgVraag extends EnqueteVraag {

    public VervolgVraag() {

    }

    public VervolgVraag(String vraag, String antwoord) {
        super(vraag, antwoord);
    }
        public static String vervolgVragen(Scanner scanner) {

            List<String> vervolgVraag = null;
            String vervolgAntwoord = "";
            try {
                vervolgVraag = EnqueteVraag.readQuestionsFromCSV("vervolgVragen.csv");
                for (String vraag : vervolgVraag) {
                    System.out.println(vraag);
                    vervolgAntwoord = scanner.nextLine();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return vervolgVraag + "," + vervolgAntwoord;
        }
    }