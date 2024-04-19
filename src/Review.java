import java.io.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class Review extends Game {
    private String tekst;
    private double score;

    public Review(String tekst, double score, String game) {
        super(null, 0.0, null, null, 0.0, null);
        this.tekst = tekst;
        this.score = score;
        this.setNaam(game);

    }

    public Review() {
        super();
    }

    public String getTekst() {
        return tekst;
    }

    public double getScore() {
        return score;
    }

    public void addReview(Scanner scanner, String selectedGame) {
        System.out.println("Geef de game een gameplay score (1-5):");
        double gameplayScore = scanner.nextDouble();

        System.out.println("Geef de game een graphics score (1-5):");
        double graphicsScore = scanner.nextDouble();

        System.out.println("Geef de game een storyline score (1-5):");
        double storylineScore  = scanner.nextDouble();
        scanner.nextLine();



        double totalScore = (gameplayScore + graphicsScore + storylineScore) / 3;

        System.out.println("Wilt u een opmerking geven bij dit spel (J/N)");
        String choice = scanner.nextLine();


        if (choice.equalsIgnoreCase("J")) {
            System.out.println("Voeg je opmerking toe:");
            tekst = scanner.nextLine();
        }

        else if (choice.equalsIgnoreCase("N")) {
            tekst = "Geen opmerking";
        }

        try (FileWriter writer = new FileWriter("Reviews.csv", true)) {
            writer.write(selectedGame + "," + gameplayScore + "," + graphicsScore + "," + storylineScore + "," + totalScore + "," + tekst + "\n");
            System.out.printf("Review added: %s, Gameplay: %.2f, Graphics: %.2f, Storyline: %.2f, Totalescore: %.2f, Comment: %s\n",selectedGame,gameplayScore,graphicsScore,storylineScore,totalScore,tekst);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> showReviews() {
        String filePath = "Reviews.csv";
        List<String> reviews = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#.##"); // DecimalFormat for rounding

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Split the CSV line by commas
                String gameName = parts[0]; // First part is game name
                double gameplayScore = Double.parseDouble(parts[1]); // Second part is gameplay score
                double graphicsScore = Double.parseDouble(parts[2]); // Third part is graphics score
                double storylineScore = Double.parseDouble(parts[3]); // Fourth part is storyline score
                double totalScore = Double.parseDouble(parts[4]); // Fifth part is total score
                String comment = parts[5]; // Sixth part is the comment

                // Round the scores to two decimal places
                gameplayScore = Double.parseDouble(df.format(gameplayScore));
                graphicsScore = Double.parseDouble(df.format(graphicsScore));
                storylineScore = Double.parseDouble(df.format(storylineScore));
                totalScore = Double.parseDouble(df.format(totalScore));

                // Format the review string
                String review = "Review: " + gameName + ", gameplay: " + gameplayScore +
                        ", graphics: " + graphicsScore + ", storyline: " + storylineScore +
                        ", Score: " + totalScore + ", Opmerking: " + comment;

                reviews.add(review); // Add the formatted review string to the list
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }

        return reviews;
    }

    @Override
    public String toString() {
        List<String> reviews = showReviews(); // Get the list of reviews from the CSV file
        StringBuilder stringBuilder = new StringBuilder();

        // Iterate over each review and append it to the StringBuilder
        for (String review : reviews) {
            stringBuilder.append(review).append("\n"); // Append each review followed by a newline character
        }

        return stringBuilder.toString();
    }

    public void printReviews() {
        System.out.println(toString());
    }
}




//
//public static List<String> showReviews() {
//    String filePath = "Reviews.csv";
//    List<String> lines = new ArrayList<>();
//
//    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//        String line;
//        while ((line = br.readLine()) != null) {
//            lines.add(line);
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//
//    return lines;
//}
//
//@Override
//public String toString() {
//    return "Review: " + getNaam() + ", gameplay: " + gameplayScore + ", graphics: " + graphicsScore + ", storyline: " + storylineScore + ", Score: " + totalScore + ", Opmerking: " + tekst;
//}