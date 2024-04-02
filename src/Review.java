public class Review {
    private String tekst;
    private double score;

    public Review(String tekst, double score) {
        this.tekst = tekst;
        this.score = score;
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
}
