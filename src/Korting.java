import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Korting extends Menu {

    public Korting() {
        super((ArrayList)null);
    }

    public ArrayList<String[]> showKortinglijst() {
        String csvFile = "kortingen.csv";
        String csvSplitBy = ",";
        ArrayList<String[]> data = new ArrayList();

        String[] row;
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));

            String line;
            try {
                while((line = br.readLine()) != null) {
                    row = line.split(csvSplitBy);
                    String[] rowData = new String[]{row[0].trim().replaceAll("^\"|\"$", ""), row[1].trim().replaceAll("^\"|\"$", "")};
                    data.add(rowData);
                }
            } catch (Throwable var9) {
                try {
                    br.close();
                } catch (Throwable var8) {
                    var9.addSuppressed(var8);
                }

                throw var9;
            }

            br.close();
        } catch (IOException var10) {
            IOException e = var10;
            e.printStackTrace();
        }

        Iterator var12 = data.iterator();

        while(var12.hasNext()) {
            row = (String[])var12.next();
            System.out.println(row[0] + ", " + row[1] + " euro");
        }

        return data;
    }

    public List<String> getKorting() {
        List<String> korting = new ArrayList();
        String csvFile = "gamesList.csv";
        String csvSplitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));

            String line;
            try {
                while((line = br.readLine()) != null) {
                    ArrayList<String> fields = new ArrayList(List.of(line.split(csvSplitBy)));
                    korting.add(((String)fields.get(0)).substring(1));
                }
            } catch (Throwable var9) {
                try {
                    br.close();
                } catch (Throwable var8) {
                    var9.addSuppressed(var8);
                }

                throw var9;
            }

            br.close();
        } catch (IOException var10) {
            IOException e = var10;
            e.printStackTrace();
        }

        return korting;
    }
}