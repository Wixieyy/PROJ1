import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


class Menu {
    public Menu() {
        String linebar = "--------------------------------------";
        String menumessage = "1. Ranglijst\n2. Uitverkoop \n3. Review schrijven\n4. Reviews Zien\n0. Exit";
        String spaceinvadersart = "░░░░░░░░░░░░░░░░░\n░░░░░▀▄░░░▄▀░░░░░\n░░░░▄█▀███▀█▄░░░░\n░░░█▀███████▀█░░░\n░░░█░█▀▀▀▀▀█░█░░░\n░░░░░░▀▀░▀▀░░░░░░\n░░░░░░░░░░░░░░░░░";
        System.out.println(linebar);
        System.out.println(spaceinvadersart);
        System.out.println(linebar + "\n");
        System.out.println("Welkom bij RetroReview\n\nKies uit één van de onderstaande opties:");

        while(true) {
            System.out.println(menumessage);
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nInput: ");
            int page = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n" + linebar + "\n");

            try {
                switch (page) {
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Invalid number");
                        break;
                    case 1:
                        Ranglijst ranglijst = new Ranglijst();
                        ranglijst.showRanglijst();
                        System.out.println("\nSelecteer de game die u wilt inzien.\n");
                        List<String> games = ranglijst.getGames();

                        int selectedGameIndex;
                        for(selectedGameIndex = 0; selectedGameIndex < games.size(); ++selectedGameIndex) {
                            System.out.println(selectedGameIndex + 1 + ". " + (String)games.get(selectedGameIndex));
                        }

                        System.out.print("Input: ");
                        selectedGameIndex = scanner.nextInt();
                        if (selectedGameIndex > 0 && selectedGameIndex <= games.size()) {
                            String selectedGame = (String)games.get(selectedGameIndex - 1);
                            System.out.println("You selected: " + selectedGame + "\n");
                        } else {
                            System.out.println("Invalid game selection.\n");
                        }

                        new Review();
                        break;
                    case 2:
                        Korting korting = new Korting();
                        korting.showKortinglijst();
                        break;
                    case 3:
                        Random random = new Random();
                        List<String> questions = new ArrayList<>();
                        EnqueteVraag enqueteVraag = new EnqueteVraag();
                        enqueteVraag.conductSurvey(random, scanner, questions);
                        break;
                }
            } finally {
                System.out.println("\n" + linebar);
            }
        }
    }

    public Menu(ArrayList<String> games) {
    }
}
//class Menu {
//    public Menu() {
//        String linebar = "--------------------------------------";
//        String menumessage = "1. Ranglijst\n2. Uitverkoop \n3. Review schrijven\n4. Reviews Zien\n0. Exit";
//        String spaceinvadersart = "░░░░░░░░░░░░░░░░░\n░░░░░▀▄░░░▄▀░░░░░\n░░░░▄█▀███▀█▄░░░░\n░░░█▀███████▀█░░░\n░░░█░█▀▀▀▀▀█░█░░░\n░░░░░░▀▀░▀▀░░░░░░\n░░░░░░░░░░░░░░░░░";
//        System.out.println(linebar);
//        System.out.println(spaceinvadersart);
//        System.out.println(linebar + "\n");
//        System.out.println("Welkom bij RetroReview\n\nKies uit één van de onderstaande opties:");
//
//        while (true) {
//            System.out.println(menumessage);
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("\nInput: ");
//            int page = scanner.nextInt();
//            scanner.nextLine();
//            System.out.println("\n" + linebar + "\n");
//
//
//            try {
//                switch (page) {
//                    case 0:
//                        System.exit(0);
//                    default:
//                        System.out.println("Invalid number");
//                        break;
//                    case 1:
//                        Ranglijst ranglijst = new Ranglijst();
//                        ranglijst.showRanglijst();
//                        System.out.println("\nSelecteer de game die u wilt inzien.\n");
//                        List<String> games = ranglijst.getGames();
//
//                        int selectedGameIndex;
//                        for (selectedGameIndex = 0; selectedGameIndex < games.size(); ++selectedGameIndex) {
//                            System.out.println(selectedGameIndex + 1 + ". " + (String) games.get(selectedGameIndex));
//                        }
//
//                        System.out.print("Input: ");
//                        selectedGameIndex = scanner.nextInt();
//                        if (selectedGameIndex > 0 && selectedGameIndex <= games.size()) {
//                            String selectedGame = (String) games.get(selectedGameIndex - 1);
//                            System.out.println("U heeft geselecteerd: " + selectedGame + "\n");
//                        } else {
//                            System.out.println("Game bestaat niet.\n");
//                        }
//                        new Review();
//                        System.out.println();
//                        //System.out.println("Wilt u een review achterlaten? (J/N)");
//                        //String keuze = scanner.nextLine();
////
//                        //if (keuze.equals("J")) {
////
//                        //    review.addReview(scanner);
////
//                        //}
//                        break;
//
//                    case 2:
//                        Korting korting = new Korting();
//                        korting.showKortinglijst();
//                        break;
//                    case 3:
//                        Random random = new Random();
//                        List<String> questions = new ArrayList<>();
//                        EnqueteVraag enqueteVraag = new EnqueteVraag();
//                        enqueteVraag.conductSurvey(random, scanner, questions);
//                        break;
//                }
//            } finally {
//                System.out.println("\n" + linebar);
//            }
//        }
//
//
//    }
//    public Menu(ArrayList<String> games){
//    }
//
//}
//