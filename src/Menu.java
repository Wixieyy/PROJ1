import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Menu {
    public Menu() {
        String linebar = "--------------------------------------";
        String menumessage = "1. Ranglijst\n2. Uitverkoop \n3. Review zien\n4. Vraag Toevoegen\n0. Exit";
        String spaceinvadersart = "░░░░░░░░░░░░░░░░░\n░░░░░▀▄░░░▄▀░░░░░\n░░░░▄█▀███▀█▄░░░░\n░░░█▀███████▀█░░░\n░░░█░█▀▀▀▀▀█░█░░░\n░░░░░░▀▀░▀▀░░░░░░\n░░░░░░░░░░░░░░░░░";
        System.out.println(linebar);
        System.out.println(spaceinvadersart);
        System.out.println(linebar + "\n");
        System.out.println("Welkom bij RetroReview\n\nKies uit één van de onderstaande opties:");
        while (true) {
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
                        break;
                    case 1: // Ranglijst
                        Ranglijst ranglijst = new Ranglijst();
                        ranglijst.showRanglijst();
                        System.out.println("\nSelecteer de game die u wilt inzien.\n");
                        List<String> games = ranglijst.getGames();

                        int selectedGameIndex;
                        for (selectedGameIndex = 0; selectedGameIndex < games.size(); ++selectedGameIndex) {
                            System.out.println(selectedGameIndex + 1 + ". " + (String) games.get(selectedGameIndex));
                        }

                        System.out.print("Input: ");
                        selectedGameIndex = scanner.nextInt();
                        scanner.nextLine();
                        if (selectedGameIndex > 0 && selectedGameIndex <= games.size()) {
                            String selectedGame = (String) games.get(selectedGameIndex - 1);
                            System.out.println("You selected: " + selectedGame + "\n");

                            System.out.println("Wilt u een review schrijven voor dit spel? (J/N)\n");
                            String keuze = scanner.nextLine();

                            if (keuze.equalsIgnoreCase("J")) {
                                Review review = new Review();
                                review.addReview(scanner, selectedGame);

                                System.out.println("Wilt u ook een enquete invullen voor dit spel? (J/N)\n");

                                keuze = scanner.nextLine();
                                if (keuze.equalsIgnoreCase("J")) {
                                    EnqueteVraag enqueteVraag = new EnqueteVraag();
                                    enqueteVraag.voerEnqueteUit();

                                }
                            }
                        } else {
                            System.out.println("Invalid game selection.\n");
                        }
                        System.out.println("\n" + linebar + "\n");
                        break;
                    case 2: // Uitverkoop bekijken
                        Korting korting = new Korting();
                        korting.showKortinglijst();
                        System.out.println("\n" + linebar + "\n");
                        break;
                    case 3: // Reviews zien
                        Review review = new Review();
                        review.printReviews();
                        System.out.println("\n" + linebar + "\n");
                        break;
                    case 4:
                        //Enquete vragen aanmaken
                        System.out.println("Voeg een vraag toe!!!");
                        RegistreerVraag registreerVraag = new RegistreerVraag("", "");
                        registreerVraag.addVraagMenu(scanner, "");
                        System.out.println("\n" + linebar + "\n");
                        break;
                    default:
                        System.out.println("Invalid number");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error menu: " + e.getMessage());
            }
        }
    }

    private void readReviews() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("reviews.csv"));
            List<Review> reviews = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String game = parts[0].trim();
                double score = Double.parseDouble(parts[1].trim());
                String text = parts[2].trim();
                Review review = new Review(text, score, game);
                reviews.add(review);
            }

            // Sort reviews based on score
            Collections.sort(reviews, Comparator.comparing(Review::getScore).reversed());

            for (Review review : reviews) {
                System.out.println(review);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public Menu(ArrayList<String> games) {
    }
}
