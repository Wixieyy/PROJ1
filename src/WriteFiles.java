import java.io.File;

public class WriteFiles {
    private File reviewData;
    private File geslotenvraagData;
    private File openvraagData;
    private File vervolgvraagData;
    private File antwoordData;
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