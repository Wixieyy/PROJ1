import java.io.*;
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
        System.out.println("Geef de game een score (1-5):");
        double score  = scanner.nextDouble();
        scanner.nextLine();

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
            writer.write(selectedGame + "," + score + "," + tekst + "\n");
            System.out.println("Review added: " + selectedGame + "Score: " + score + ", Comment: " + tekst);
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





