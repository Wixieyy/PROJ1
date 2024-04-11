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

    @Override
    public String toString() {
        return "Review: " + getNaam() + ", Score: " + score;
    }
}
