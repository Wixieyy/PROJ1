public class Ranglijst {
    private String games;
    private double score;
    private double prijs;
    private String genre;

    public Ranglijst(String games, double score, double prijs, String genre) {
        this.games = games;
        this.score = score;
        this.prijs = prijs;
        this.genre = genre;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
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
}
