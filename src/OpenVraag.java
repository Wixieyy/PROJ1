import java.util.ArrayList;

public class OpenVraag extends EnqueteVraag {
    String vraag;
    private String antwoord;

    public OpenVraag(String vraag, String antwoord) {
        super(vraag, antwoord);
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

    public ArrayList<String> getvragen (){

        ReadFiles readFiles = new ReadFiles();

        ArrayList<String> vragenlijst = new ArrayList<String>();

//        for (int i = 0; i < vragenlijst.size(); i++){
//        vragenlijst.add(readFiles.readVragenlijst());
//        }

        return vragenlijst;
    }

    public void ToonVragen () {

        System.out.println(getvragen());

    }
}