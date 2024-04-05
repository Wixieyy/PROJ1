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
        System.out.print("Input: ");
        int page = scanner.nextInt();   /*Reads and stores input*/
        System.out.println("\n" + line + "\n");

        try {
            switch (page) { /*Checks input*/
                case 1:
                    try {
                        FileReader reader = new FileReader(new ReadFiles().readGameListData()); /*Creates new FileReader and create an anonymous Object that calls the readGameListData() method*/
                        int character;
                        int counter = 1;
                        boolean isNewLine = true;

                        while ((character = reader.read()) != -1) { /*Reads character in loop to check if the character is not -1 (-1 is end of file)*/
                            if (isNewLine) {    /*If new line it prints the number before the text, increments the counter and sets isNewLine to false*/
                                System.out.print(counter + ". ");
                                counter++;
                                isNewLine = false;
                            }
                            System.out.print((char) character); /*Prints out integer converted to character*/
                            if (character == '\n') {    /*If end of line go to next line and set isNewLine to true*/
                                isNewLine = true;
                            }
                        }

                        reader.close(); /*Close the reader (cant be reopened)*/
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:

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
            System.out.println("\n\n" + line);
        }
    }
}
