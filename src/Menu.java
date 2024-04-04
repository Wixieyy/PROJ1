import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public Menu() {
        String spaceinvadersart =
                "░░░░░░░░░░░░░░░░░\n" +
                "░░░░░▀▄░░░▄▀░░░░░\n" +
                "░░░░▄█▀███▀█▄░░░░\n" +
                "░░░█▀███████▀█░░░\n" +
                "░░░█░█▀▀▀▀▀█░█░░░\n" +
                "░░░░░░▀▀░▀▀░░░░░░\n" +
                "░░░░░░░░░░░░░░░░░";
        System.out.println(spaceinvadersart);
        System.out.println("welcome text");
        int page = scanner.nextInt();

        switch (page) {
            case 1:

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
                System.out.println("invalid number");
                break;
        }
    }
}