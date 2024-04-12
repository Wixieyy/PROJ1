import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {
    private File reviewData;
    private File geslotenvraagData;
    private File openvraagData;
    private File vervolgvraagData;
    private File antwoordData;
    private File gameListData;
    private File vragenList;

    public ReadFiles() {
    }

    public ReadFiles(File reviewData, File geslotenvraagData, File openvraagData, File vervolgvraagData, File antwoordData, FileReader reader, File vragenList) {
        this.reviewData = reviewData;
        this.geslotenvraagData = geslotenvraagData;
        this.openvraagData = openvraagData;
        this.vervolgvraagData = vervolgvraagData;
        this.antwoordData = antwoordData;
        this.vragenList = vragenList;
    }

    public String[] readGameListData() {
        String filePath = "gamesList.csv";

        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] linesArray = lines.toArray(new String[0]);
        return linesArray;
    }


    public String[] readVragenlijst() {
        String filePath = "vragenList.csv";

        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] linesArray = lines.toArray(new String[0]);
        return linesArray;
    }

//    public FileReader(FileWriter writeFiles) {
//    }
//
//    public FileReader(String filePath) {
//
//    }

    public List<GeslotenVraag> readGeslotenVragen() {
        List<GeslotenVraag> geslotenVragen = new ArrayList<>();
        String filePath = "GeslotenVragen.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String vraag = data[0];
                String[] opties = new String[data.length - 1];
                System.arraycopy(data, 1, opties, 0, data.length - 1);
                String antwoord = data[data.length - 1];
                geslotenVragen.add(new GeslotenVraag(vraag, opties, antwoord));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return geslotenVragen;
    }

    public List<OpenVraag> readOpenVragen() {
        List<OpenVraag> openVragen = new ArrayList<>();
        String filePath = "OpenVragen.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String vraag = data[0];
                String antwoord = data[1];
                openVragen.add(new OpenVraag(vraag, antwoord));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return openVragen;
    }

    public List<VervolgVraag> readVervolgVragen() {
        List<VervolgVraag> vervolgVragen = new ArrayList<>();
        String filePath = "VervolgVragen.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String vraag = data[0];
                String antwoord = data[1];
                vervolgVragen.add(new VervolgVraag(vraag, antwoord));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vervolgVragen;
    }


    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }


    public void close() throws IOException {

    }


}
