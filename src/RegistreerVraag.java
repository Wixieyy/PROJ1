import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegistreerVraag extends EnqueteVraag {

    public RegistreerVraag(String vraag, String antwoord){
        super(vraag, antwoord);
    }

    public void addVraagMenu (Scanner scanner, String vraag) throws IOException {
        FileWriter writer;
        String filepath;
        int choice;
        boolean meerVragen = true;

        System.out.println("Wat voor vraag wilt u aanmaken?\n");


        while (meerVragen) {
            System.out.println("1.openvraag\n2.geslotenvraag\n3.vervolgvraag");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // openvraag
                    filepath = "openVragen.csv";
                    writer = new FileWriter(filepath, true);

                    System.out.println("Voer uw openvraag in:");
                    vraag = scanner.nextLine();
                    writer.write(vraag);
                    writer.append('\n');
                    writer.flush();
                    System.out.println("Openvraag succesvol toegevoegd.");
                    break;

                case 2: // geslotenvraag
                    filepath = "geslotenVragen.csv";
                    writer = new FileWriter(filepath, true);

                    System.out.println("Voer uw geslotenvraag in:");
                    vraag = scanner.nextLine();
                    writer.write(vraag);
                    writer.append('\n');
                    writer.flush();
                    System.out.println("Geslotenvraag succesvol toegevoegd.");
                    break;

                case 3: // vervolgvraag
                    filepath = "vervolgVragen.csv";
                    writer = new FileWriter(filepath, true);

                    System.out.println("Voer uw vervolgvraag in:");
                    vraag = scanner.nextLine();
                    writer.write(vraag);
                    writer.append('\n');
                    writer.flush();
                    System.out.println("Vervolgvraag succesvol toegevoegd.");
                    break;
                default:
                    System.out.println("Invalid number");
                    break;
            }
            System.out.println("Wil je nog een vraag toevoegen? 1. Ja 2. Nee");
            int invoer = scanner.nextInt();
            scanner.nextLine();
            if (invoer == 2) {
                meerVragen = false;
            }
        }
    }
}
