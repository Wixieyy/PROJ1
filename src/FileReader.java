import java.io.File;

public class FileReader {
    private File reviewData;
    private File geslotenvraagData;
    private File openvraagData;
    private File vervolgvraagData;
    private File antwoordData;
    private FileReader reader;

    public FileReader(File reviewData, File geslotenvraagData, File openvraagData, File vervolgvraagData, File antwoordData, FileReader reader) {
        this.reviewData = reviewData;
        this.geslotenvraagData = geslotenvraagData;
        this.openvraagData = openvraagData;
        this.vervolgvraagData = vervolgvraagData;
        this.antwoordData = antwoordData;
        this.reader = reader;
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

    public FileReader readReader() {
        return reader;
    }
}
