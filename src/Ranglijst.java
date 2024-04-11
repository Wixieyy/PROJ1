import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ranglijst extends Game {
    private int positie;
    private double score;
    private double prijs;
    private String genre;

    public Ranglijst(int positie, double score, double prijs, String genre, String naam, ArrayList<String> games) {
        super(naam, games);
        this.positie = positie;
        this.score = score;
        this.prijs = prijs;
        this.genre = genre;
    }

    public Ranglijst() {
        super(null, null);
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public ArrayList<String> showRanglijst() {
        String csvFile = "gamesList.csv"; // Replace this with the path to your CSV file
        String line;
        String csvSplitBy = ","; // Assuming comma-separated values
        ArrayList<String> names = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Split the line by the comma to get individual fields
                String[] fields = line.split(csvSplitBy);
                // Add the name (index 0) to the list
                names.add(fields[0].trim().replaceAll("^\"|\"$", ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print out all the names
        for (String name : names) {
            System.out.println(name);
        }

        return names;
    }

    public void sortRanglijst() {
        String csvFile = "gamesList.csv"; // Replace this with the path to your CSV file
        String line;
        String csvSplitBy = ","; // Assuming comma-separated values

        List<ArrayList<String>> allFields = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Split the line by the comma to get individual fields
                String[] splitFields = line.split(csvSplitBy);
                ArrayList<String> fields = new ArrayList<>();
                for (String field : splitFields) {
                    // Remove leading and trailing whitespace and quotes
                    fields.add(field.trim().replaceAll("^\"|\"$", ""));
                }
                allFields.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort allFields based on the value of fields.get(2) in descending order
        allFields.sort((fields1, fields2) -> {
            // Extract the value of fields.get(2) as a double
            double value1 = 0.0;
            double value2 = 0.0;
            try {
                value1 = Double.parseDouble(fields1.get(2).replaceAll("[^0-9.]", ""));
                value2 = Double.parseDouble(fields2.get(2).replaceAll("[^0-9.]", ""));
            } catch (NumberFormatException ignored) {
                // Handle cases where the value cannot be parsed as a double
            }
            return Double.compare(value2, value1); // Compare in descending order
        });

        // Print sorted fields
        for (ArrayList<String> fields : allFields) {
            System.out.println(fields.get(0));
        }
    }

    public void avgScoreRanglijst() {
        String csvFile = "gamesList.csv"; // Replace this with the path to your CSV file
        String line;
        String csvSplitBy = ","; // Assuming comma-separated values

        List<Double> scores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Split the line by the comma to get individual fields
                String[] splitFields = line.split(csvSplitBy);
                // Extract the score from the third field and convert it to a double
                double score = Double.parseDouble(splitFields[2].trim().replaceAll("[^0-9.]", ""));
                scores.add(score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calculate the sum of all scores
        double sum = 0.0;
        for (double score : scores) {
            sum += score;
        }

        // Calculate the average score
        double average = sum / scores.size();

        System.out.println("Average Score: " + average);
    }
        public List<String> getGames() {
            List<String> games = new ArrayList<>();
            String csvFile = "gamesList.csv";
            String csvSplitBy = ",";
            String line;

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    // Split the line by the comma to get individual fields
                    ArrayList<String> fields = new ArrayList<>(List.of(line.split(csvSplitBy)));
                    // Add game name to the list
                    games.add(fields.get(0).substring(1)); // Remove leading whitespace
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return games;
        }
    }

