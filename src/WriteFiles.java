import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFiles {
    private File reviewData;
    private File geslotenvraagData;
    private File openvraagData;
    private File vervolgvraagData;
    private File antwoordData;
    private File gameListData;
    private WriteFiles writer;


    public WriteFiles() {

    }
    public WriteFiles(File reviewData, File geslotenvraagData, File openvraagData, File vervolgvraagData, File antwoordData, WriteFiles writer) {
        this.reviewData = reviewData;
        this.geslotenvraagData = geslotenvraagData;
        this.openvraagData = openvraagData;
        this.vervolgvraagData = vervolgvraagData;
        this.antwoordData = antwoordData;
        this.writer = writer;
    }

    public static void writeReviewsData(String s, String reviews) {
    }

    public void writeGameData (String game) {
        try {
            gameListData = new File("gamesList.txt");   /*new File for gamesList.txt*/
            FileWriter gameWriter = new FileWriter(gameListData, true); /*Creates a writer that writes to gamesList.txt and allows appending (otherwise all data will be overwritten each time it is used.)*/

            gameWriter.write("\n" + game);  /*Goes to next line before storing input*/
            gameWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeReviewData(File reviewData) {
        this.reviewData = reviewData;
    }

    public void writeGeslotenvraagData(File geslotenvraagData) {
        this.geslotenvraagData = geslotenvraagData;
    }

    public void writeOpenvraagData(File openvraagData) {
        this.openvraagData = openvraagData;
    }

    public void writeVervolgvraagData(File vervolgvraagData) {
        this.vervolgvraagData = vervolgvraagData;
    }

    public void writeAntwoordData(File antwoordData) {
        this.antwoordData = antwoordData;
    }

    public void writeWriter(WriteFiles writer) {
        this.writer = writer;
    }
}
