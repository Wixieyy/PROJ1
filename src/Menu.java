import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public Menu() {
        String line = ("--------------------------------------");
        String menumessage = "1. Ranglijst\n" + "2. Uitverkoop \n" + "3. Opslaan";
        String spaceinvadersart =
                        "░░░░░░░░░░░░░░░░░\n" +
                        "░░░░░▀▄░░░▄▀░░░░░\n" +
                        "░░░░▄█▀███▀█▄░░░░\n" +
                        "░░░█▀███████▀█░░░\n" +
                        "░░░█░█▀▀▀▀▀█░█░░░\n" +
                        "░░░░░░▀▀░▀▀░░░░░░\n" +
                        "░░░░░░░░░░░░░░░░░";

        System.out.println(line);
        System.out.println(spaceinvadersart);
        System.out.println(line + "\n");
        System.out.println("Welkom bij RetroReview\n\n" +
                "Kies uit één van de onderstaande opties:");
        System.out.println(menumessage);


        Scanner scanner = new Scanner(System.in);
        System.out.print("\nInput: ");
        int page = scanner.nextInt();   /*Stores input*/
        scanner.nextLine(); /*Clears next line so next scanner input isn't skipped*/
        System.out.println("\n" + line + "\n");

        try {
            switch (page) { /*Checks input*/
                case 1: /*Ranglijst*/
                    ReadFiles readFiles = new ReadFiles();
                    System.out.println(readFiles.readGameListData());
                    break;
                case 2: /*Temporarily using to test WriteFiles class*/
                    WriteFiles writeFiles = new WriteFiles();
                    System.out.println("What game would you like to add?");
                    String game = scanner.nextLine();
                    writeFiles.writeGameData(game);
                    System.out.printf("%s has been added to the list of games.",game);
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:    /*If none of the cases are true it prints out default*/
                    System.out.println("Invalid number");
                    break;

            }
        }
        finally {   /*Finally is always executed after the switch case is done*/
            System.out.println("\n" + line);
        }
    }
}
