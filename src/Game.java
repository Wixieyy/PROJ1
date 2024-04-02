public class Game {
    private double prijs;
    private String naam;
    private String genre;
    private double score;
    private String review;

    public Game(double prijs, String naam, String genre, double score, String review) {
        this.prijs = prijs;
        this.naam = naam;
        this.genre = genre;
        this.score = score;
        this.review = review;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
