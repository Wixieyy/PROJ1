import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class OpenGeslotenVraag extends EnqueteVraag {
    private String[] opties;

    public OpenGeslotenVraag(String vraag, String[] opties, String antwoord) {
        super(vraag, antwoord);
        this.opties = opties;
    }

    public static void geslotenVragen() {
        List<String> openVraag = new ArrayList<>();
        List<String> geslotenVraag = new ArrayList<>();
        try {
            openVraag = readQuestionsFromCSV("openVragen.csv");
            geslotenVraag = readQuestionsFromCSV("geslotenVragen.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }


        conductSurveyGesloten(new Scanner(System.in), geslotenVraag, openVraag);
    }

    public static void conductSurveyGesloten(Scanner scanner, List<String> geslotenVraag, List<String> openVraag) {
        try (FileWriter writer = new FileWriter(new File("enqueteAntwoorden.csv"), true)) {
            for (String gVraag : geslotenVraag) {
                System.out.println("Question: " + gVraag);

                if (scanner.hasNextLine()) { // Check if there is input available
                    String geslotenAntwoord = scanner.nextLine();

                    String vervolgData = null;

                    if (geslotenAntwoord.equals("a")) {
                        System.out.println("Vervolgvraag: ");
                        vervolgData = VervolgVraag.vervolgVragen(scanner);
                    } else {
                        vervolgData = "Geen vervolg vraag";
                    }

                    writer.write(gVraag + "," + geslotenAntwoord + "," + vervolgData);
                    writer.append('\n');
                    writer.flush();
                }
            }
            for (String oVraag : openVraag) {
                System.out.println("Question: " + oVraag);
                if (scanner.hasNextLine()) {
                    String openAntwoord = scanner.nextLine();

                    writer.write(oVraag + "," + openAntwoord);
                    writer.append('\n');
                    writer.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
