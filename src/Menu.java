import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


//try {
//File file = new File("test.txt");
//FileWriter writer = new FileWriter(file);
//                    writer.write("test string");
//                    writer.close();
//FileReader reader = new FileReader(file);
//int character;
//                    while ((character = reader.read()) != -1) {
//        System.out.print((char) character);
//        }
//        System.out.println("\n");
//                    reader.close();
//                }
//                        catch (IOException e) {
//        throw new RuntimeException(e);
//                }
/*Read and write example - delete later*/

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
        int page = scanner.nextInt();
        System.out.println("\n" + line + "\n");

        try {
            switch (page) {
                case 1:
                    try {
                        FileReader reader = new FileReader(new ReadFiles().readGameListData());
                        int character;
                        int counter = 1;
                        boolean isNewLine = true;

                        while ((character = reader.read()) != -1) {
                            if (isNewLine) {
                                System.out.print(counter + ". ");
                                counter++;
                                isNewLine = false;
                            }
                            System.out.print((char) character);
                            if (character == '\n') {
                                isNewLine = true;
                            }
                        }

                        reader.close();
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
                default:
                    System.out.println("Invalid number");
                    break;

            }
        }
        finally {
            System.out.println("\n\n" + line);
        }
    }
}
