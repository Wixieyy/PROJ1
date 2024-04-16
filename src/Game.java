import java.util.ArrayList;

public class Game extends Ranglijst {
    protected ArrayList<String> games;
    private double prijs;
    private String naam;
    private String genre;
    private double score;
    private String review;

    public Game(ArrayList<String> games, double prijs, String naam, String genre, double score, String review) {
        this.games = games;
        this.prijs = prijs;
        this.naam = naam;
        this.genre = genre;
        this.score = score;
        this.review = review;
    }

    public Game(String naam, ArrayList<String> games) {
        this.naam = naam;
        this.games= games;
    }

    public Game() {

    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }


    public double getScore() {
        return score;
    }
}
