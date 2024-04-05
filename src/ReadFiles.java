import java.io.File;

public class ReadFiles {
    private File reviewData;
    private File geslotenvraagData;
    private File openvraagData;
    private File vervolgvraagData;
    private File antwoordData;
    private File gameListData = new File("gamesList.txt");
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

    public File readGameListData() {
        return gameListData;
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