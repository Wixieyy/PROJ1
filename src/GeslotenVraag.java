public class GeslotenVraag extends EnqueteVraag {
    private String[] opties;

    public GeslotenVraag(String vraag, String[] opties, String antwoord) {
        super(vraag, antwoord);
        this.opties = opties;
    }

    // Method to validate the answer for multiple-choice questions
    public boolean validateAntwoord(String gekozenOptie) {
        for (String optie : opties) {
            if (optie.equalsIgnoreCase(gekozenOptie)) {
                return true;
            }
        }
        return false;
    }

    // Method to display the question and options
    public void displayVraag() {
        System.out.println(getVraag());
        for (int i = 0; i < opties.length; i++) {
            System.out.println((char)('A' + i) + ". " + opties[i]);
        }
    }
}