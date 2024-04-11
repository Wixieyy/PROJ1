import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EnqueteVraag extends Review {
    private String vraag;
    protected String antwoord;

    public EnqueteVraag(String vraag, String antwoord) {
        super("", 0.0); // Calling superclass constructor with empty string and 0.0 score
        this.vraag = vraag;
        this.antwoord = antwoord;
    }

    public String getVraag() {
        return vraag;
    }

    public void setVraag(String vraag) {
        this.vraag = vraag;
    }

    public String getAntwoord() {
        return antwoord;
    }

    public void setAntwoord(String antwoord) {
        this.antwoord = antwoord;
    }

    public void conductSurvey(List<GeslotenVraag> geslotenVragen, List<OpenVraag> openVragen, Random random, Scanner scanner) {
        // Conduct the survey
        for (int i = 0; i < 5; i++) {
            // Randomly choose between closed and open questions
            boolean isClosedQuestion = random.nextBoolean();

            if (isClosedQuestion) {
                // Randomly select a closed question
                GeslotenVraag geslotenVraag = geslotenVragen.get(random.nextInt(geslotenVragen.size()));

                // Display the closed question
                System.out.println("Question " + (i + 1) + ":");
                geslotenVraag.displayVraag();

                // Get user input
                String antwoord = scanner.nextLine();

                // Save the answer
                // Proceed to the next question
            } else {
                // Randomly select an open question
                OpenVraag openVraag = openVragen.get(random.nextInt(openVragen.size()));

                // Display the open question
                System.out.println("Question " + (i + 1) + ": " + openVraag.getVraag());

                // Get user input
                String antwoord = scanner.nextLine();

                // Save the answer
                // Proceed to the next question
            }
        }

        // Close resources
        scanner.close();
    }
}
