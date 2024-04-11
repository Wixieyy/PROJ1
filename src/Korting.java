import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Korting extends Ranglijst {
    private double oudePrijs;
    private double nieuwePrijs;
    private String gameNaam;

    public Korting(double oudePrijs, double nieuwePrijs, String gameNaam) {
//        super(0, 0.0, 0.0, null, null, null);
        this.oudePrijs = oudePrijs;
        this.nieuwePrijs = nieuwePrijs;
        this.gameNaam = gameNaam;

// Voorbeeld van oude prijzen
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
}

