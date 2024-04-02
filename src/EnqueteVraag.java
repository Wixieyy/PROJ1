public class EnqueteVraag {
    String vraag;
    private String antwoord;

    public EnqueteVraag(String vraag, String antwoord) {
        this.vraag = vraag;
        this.antwoord = antwoord;
    }

    public String getVraag() {
        return vraag;
    }

    public void setVraag(String vraag) {
        this.vraag = vraag;
    }

    public String getAntwoord() {
        return antwoord;
    }

    public void setAntwoord(String antwoord) {
        this.antwoord = antwoord;
    }
}
