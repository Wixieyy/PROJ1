import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ranglijst extends Menu {
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


    public ArrayList<String[]> showRanglijst() {
        String csvFile = "gamesList.csv";
        String line;
        String csvSplitBy = ",";
        ArrayList<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(csvSplitBy);
                String[] rowData = new String[2];
                rowData[0] = fields[0].trim().replaceAll("^\"|\"$", "");
                rowData[1] = fields[1].trim().replaceAll("^\"|\"$", "");
                data.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] row : data) {
            System.out.println(row[0] + ", " + row[1] + " euro");
        }

        return data;
    }

    public void sortRanglijst() {
        String csvFile = "gamesList.csv";
        String line;
        String csvSplitBy = ",";

        List<ArrayList<String>> allFields = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] splitFields = line.split(csvSplitBy);
                ArrayList<String> fields = new ArrayList<>();
                for (String field : splitFields) {
                    fields.add(field.trim().replaceAll("^\"|\"$", ""));
                }
                allFields.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        allFields.sort((fields1, fields2) -> {
            double value1 = 0.0;
            double value2 = 0.0;
            try {
                value1 = Double.parseDouble(fields1.get(2).replaceAll("[^0-9.]", ""));
                value2 = Double.parseDouble(fields2.get(2).replaceAll("[^0-9.]", ""));
            } catch (NumberFormatException ignored) {
            }
            return Double.compare(value2, value1);
        });

        for (ArrayList<String> fields : allFields) {
            System.out.println(fields.get(0) + ", " + fields.get(1) + " euro");
        }
    }

    public void avgScoreRanglijst() {
        String csvFile = "gamesList.csv";
        String line;
        String csvSplitBy = ",";

        List<Double> scores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] splitFields = line.split(csvSplitBy);
                double score = Double.parseDouble(splitFields[2].trim().replaceAll("[^0-9.]", ""));
                scores.add(score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        double sum = 0.0;
        for (double score : scores) {
            sum += score;
        }

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
                    ArrayList<String> fields = new ArrayList<>(List.of(line.split(csvSplitBy)));
                    games.add(fields.get(0).substring(1));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return games;
        }
    }

