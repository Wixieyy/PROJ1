import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFiles {
    private File reviewData;
    private File geslotenvraagData;
    private File openvraagData;
    private File vervolgvraagData;
    private File antwoordData;
    private File gameListData;
    private ReadFiles reader;

    public ReadFiles() {
    }
//    public FileReader(File reviewData, File geslotenvraagData, File openvraagData, File vervolgvraagData, File antwoordData, FileReader reader) {
//        this.reviewData = reviewData;
//        this.geslotenvraagData = geslotenvraagData;
//        this.openvraagData = openvraagData;
//        this.vervolgvraagData = vervolgvraagData;
//        this.antwoordData = antwoordData;
//        this.reader = reader;
//    }

    public String readGameListData() { /*For now returns the File of the gameList but later can be modified to perform most of the code thats currently inside the switch case and just return the answer(s)*/
        StringBuilder builder = new StringBuilder(); /*Empty String that you can append text to*/
        try {
            gameListData = new File("gamesList.txt"); /*Creates new file for the gamesList.txt*/
            FileReader reader = new FileReader(gameListData);
            int character;
            int counter = 1;
            boolean isNewLine = true;

            while ((character = reader.read()) != -1) { /*Reads character in loop to check if the character is not -1 (-1 is end of file)*/
                if (isNewLine) {    /*If new line it prints the number before the text, increments the counter and sets isNewLine to false*/
                    builder.append(counter + ". ");
                    counter++;
                    isNewLine = false;
                }
                builder.append((char) character); /*Prints out integer converted to character*/
                if (character == '\n') {    /*If end of line go to next line and set isNewLine to true*/
                    isNewLine = true;
                }
            }

            reader.close(); /*Close the reader (cant be reopened)*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
    public File readReviewData() {
        return reviewData;
    }

    public File readGeslotenvraagData() {
        return geslotenvraagData;
    }

    public File readOpenvraagData() {
        return openvraagData;
    }

    public File readVervolgvraagData() {
        return vervolgvraagData;
    }

    public File readAntwoordData() {
        return antwoordData;
    }

    public ReadFiles readReader() {
        return reader;
    }
}
