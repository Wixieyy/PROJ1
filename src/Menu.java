import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {

    public Menu() {
        String linebar = ("--------------------------------------");
        String menumessage = "1. Ranglijst\n" + "2. Uitverkoop \n" + "3. Opslaan";
        String spaceinvadersart =
                        "░░░░░░░░░░░░░░░░░\n" +
                        "░░░░░▀▄░░░▄▀░░░░░\n" +
                        "░░░░▄█▀███▀█▄░░░░\n" +
                        "░░░█▀███████▀█░░░\n" +
                        "░░░█░█▀▀▀▀▀█░█░░░\n" +
                        "░░░░░░▀▀░▀▀░░░░░░\n" +
                        "░░░░░░░░░░░░░░░░░";

        System.out.println(linebar);
        System.out.println(spaceinvadersart);
        System.out.println(linebar + "\n");
        System.out.println("Welkom bij RetroReview\n\n" +
                "Kies uit één van de onderstaande opties:");
        System.out.println(menumessage);


        Scanner scanner = new Scanner(System.in);
        System.out.print("\nInput: ");
        int page = scanner.nextInt();   /*Stores input*/
        scanner.nextLine(); /*Clears next line so next scanner input isn't skipped*/
        System.out.println("\n" + linebar + "\n");

        try {
            switch (page) { /*Checks input*/
                case 1:
                    Ranglijst ranglijst = new Ranglijst();
                    ranglijst.showRanglijst();


                    System.out.println("Selecteer de game die u wilt inzien.");
                    List<String> games = ranglijst.getGames();
                    for (int i = 0; i < games.size(); i++) {
                        System.out.println((i + 1) + ". " + games.get(i));
                    }

                    System.out.print("Input: ");
                    int selectedGameIndex = scanner.nextInt();
                    if (selectedGameIndex > 0 && selectedGameIndex <= games.size()) {
                        String selectedGame = games.get(selectedGameIndex - 1);
                        // Do something with the selected game
                        System.out.println("You selected: " + selectedGame);
                    } else {
                        System.out.println("Invalid game selection.");
                    }
                    Review review = new Review();

                    break;
                case 2:
                    Ranglijst ranglijst1 = new Ranglijst();

                    break;
                case 3:
                    Korting korting = new Korting(Kortingorting);

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:    /*If none of the cases are true it prints out default*/
                    System.out.println("Invalid number");
                    break;

            }
        }
        finally {   /*Finally is always executed after the switch case is done*/
            System.out.println("\n" + linebar);
        }
    }
}
