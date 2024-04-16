import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class EnqueteVraag {
    private String vraag;
    private String antwoord;

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




//
//public class EnqueteVraag extends Review {
//    public String vraag;
//    public String antwoord;
//
//    public EnqueteVraag(String vraag, String antwoord) {
//        super("", 0.0);
//        this.vraag = vraag;
//        this.antwoord = antwoord;
//    }
//
//    public EnqueteVraag() throws IOException {
//        List<String> questions = readQuestionsFromCSV("vragenList.csv");
//    }
//
//    public EnqueteVraag(String filename) throws IOException {
//        super("", 0.0);
//        List<String> questions = readQuestionsFromCSV(filename);
//    }
//    private static List<String> readQuestionsFromCSV(String filename) throws IOException {
//        List<String> questions = new ArrayList<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                questions.add(line);
//            }
//        }
//        return questions;
//    }
//
//
//    public void conductSurvey(Random random, Scanner scanner, List<String> questions) {
//        for (int i = 0; i < 5; i++) {
//            String vraag = questions.get(0);
//            System.out.println("Question " + (i + 1) + ": " + vraag);
//            String antwoord = scanner.nextLine();
//        }
//        scanner.close();
//    }
//
//
//    public String getVraag() {
//        return vraag;
//    }
//
//    public void setVraag(String vraag) {
//        this.vraag = vraag;
//    }
//
//    public String getAntwoord() {
//        return antwoord;
//    }
//
//    public void setAntwoord(String antwoord) {
//        this.antwoord = antwoord;
//    }
//}

//    /*public void conductSurvey(List<GeslotenVraag> geslotenVragen, List<OpenVraag> openVragen, Random random, Scanner scanner) {
//        for (int i = 0; i < 5; i++) {
//            boolean isClosedQuestion = random.nextBoolean();
//
//            if (isClosedQuestion) {
//                GeslotenVraag geslotenVraag = geslotenVragen.get(random.nextInt(geslotenVragen.size()));
//
//                System.out.println("Question " + (i + 1) + ":");
//                geslotenVraag.displayVraag();
//
//                String antwoord = scanner.nextLine();
//
//            } else {
//                OpenVraag openVraag = openVragen.get(random.nextInt(openVragen.size()));
//                System.out.println("Question " + (i + 1) + ": " + openVraag.getVraag());
//
//                String antwoord = scanner.nextLine();
//
//            }
//        }
//        scanner.close();
//   /* }

