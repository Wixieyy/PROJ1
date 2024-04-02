import java.io.File;

public class FileWriter {
    private File reviewData;
    private File geslotenvraagData;
    private File openvraagData;
    private File vervolgvraagData;
    private File antwoordData;
    private FileWriter writer;

    public FileWriter(File reviewData, File geslotenvraagData, File openvraagData, File vervolgvraagData, File antwoordData, FileWriter writer) {
        this.reviewData = reviewData;
        this.geslotenvraagData = geslotenvraagData;
        this.openvraagData = openvraagData;
        this.vervolgvraagData = vervolgvraagData;
        this.antwoordData = antwoordData;
        this.writer = writer;
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

    public void writeWriter(FileWriter writer) {
        this.writer = writer;
    }
}
