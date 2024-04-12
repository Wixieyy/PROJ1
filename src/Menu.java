import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Menu {

    public Menu() {
        String linebar = ("--------------------------------------");
        String menumessage = "1. Ranglijst\n" + "2. Uitverkoop \n" + "3. Reviews \n0. Exit";
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

        while (true) {
            System.out.println(menumessage);

            Scanner scanner = new Scanner(System.in);
            System.out.print("\nInput: ");
            int page = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n" + linebar + "\n");

            try {
                switch (page) {
                    case 1:
                        Ranglijst ranglijst = new Ranglijst();
                        ranglijst.showRanglijst();

                        System.out.println("\nSelecteer de game die u wilt inzien.\n");
                        List<String> games = ranglijst.getGames();
                        for (int i = 0; i < games.size(); i++) {
                            System.out.println((i + 1) + ". " + games.get(i));
                        }

                        System.out.print("Input: ");
                        int selectedGameIndex = scanner.nextInt();
                        if (selectedGameIndex > 0 && selectedGameIndex <= games.size()) {
                            String selectedGame = games.get(selectedGameIndex - 1);
                            System.out.println("You selected: " + selectedGame + "\n");
                        } else {
                            System.out.println("Invalid game selection.\n");
                        }

                        Review review = new Review();

                        break;
                    case 2:
                        Korting korting = new Korting();
                        korting.showKortinglijst();
                        break;
                    case 3:

                        var random = new Random();
                        List<String> questions = new ArrayList<>();

                        EnqueteVraag enqueteVraag = new EnqueteVraag();
                        enqueteVraag.conductSurvey(random,scanner, questions);
                        break;
                    case 4:
                        
                        break;
                    case 69:
                        Ranglijst ranglijst1 = new Ranglijst();
                        ranglijst1.sortRanglijst();
                        System.out.println();
                        ranglijst1.avgScoreRanglijst();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Invalid number");
                        break;

                }
            } finally {
                System.out.println("\n" + linebar);
            }
        }
    }

    public Menu(String naam, ArrayList<String> games) {
    }
}