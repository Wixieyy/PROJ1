import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class Review extends Game {
    private String tekst;
    private double score;

    public Review(String tekst, double score) {
        super(null, 0.0, null, null, 0.0, null);
        this.tekst = tekst;
        this.score = score;
    }

    public Review() {
        super();
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    public void addReview(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Geef de game een score (1-5):");
        double score  = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Wilt u een opmerking geven bij dit spel (J/N)");
        String choice = scanner.nextLine();


        if (choice.equalsIgnoreCase("Y")) {
            System.out.println("Voeg je opmerking toe:");
            tekst = scanner.nextLine();
        } else {
            tekst = null;
        }

        try (FileWriter writer = new FileWriter("Reviews.csv", true)) {
            writer.write(score + "," + tekst + "\n");
            System.out.println("Review added: Score: " + score + ", Comment: " + tekst);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> showReviews() {
        String filePath = "Reviews.csv";
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }


    @Override
    public String toString() {
        return "Review: " + getNaam() + ", Score: " + score;
    }
    }





