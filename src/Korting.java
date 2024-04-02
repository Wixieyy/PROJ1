public class Korting {
    private double oudePrijs;
    private double nieuwePrijs;
    private String gameNaam;

    public Korting(double oudePrijs, double nieuwePrijs, String gameNaam) {
        this.oudePrijs = oudePrijs;
        this.nieuwePrijs = nieuwePrijs;
        this.gameNaam = gameNaam;
    }

    public double getOudePrijs() {
        return oudePrijs;
    }

    public double getNieuwePrijs() {
        return nieuwePrijs;
    }
}
