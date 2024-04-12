import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Korting extends Menu{
    private double oudePrijs;
    private double nieuwePrijs;
    private String gameNaam;

    public Korting() {

    }

    public Korting(double oudePrijs, double nieuwePrijs, String gameNaam) {
//      super(0, 0.0, 0.0, null, null, null);
        this.oudePrijs = oudePrijs;
        this.nieuwePrijs = nieuwePrijs;
        this.gameNaam = gameNaam;



        List<Double> Korting = new ArrayList<>();
        Korting.add(55.0);

        List<Double> Review = new ArrayList<>();
        Review.add(1.5);

        List<Double> nieuwePrijzenMetKorting = new ArrayList<>();
        for (int i = 0; i < Korting.size(); i++) {
            if (Review.get(i) < 2.0) {
                double oudePrijs2 = Korting.get(i);
                double korting = 0.2;
                double nieuwePrijs2 = oudePrijs * (1 - korting);
                nieuwePrijzenMetKorting.add(nieuwePrijs);
            }

            System.out.println("Game: " + gameNaam);
            System.out.println("Oude prijs: " + oudePrijs);
            System.out.println("Nieuwe prijs met korting: " + nieuwePrijs);
        }
    }

    public ArrayList<String[]> showKortinglijst() {
        String csvFile = "kortingen.csv";
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
}

