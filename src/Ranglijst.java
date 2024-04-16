import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Ranglijst extends Menu {

    public Ranglijst() {
        super((ArrayList)null);
    }

    public ArrayList<String[]> showRanglijst() {
        String csvFile = "gamesList.csv";
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

    public List<String> getGames() {
        List<String> games = new ArrayList();
        String csvFile = "gamesList.csv";
        String csvSplitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));

            String line;
            try {
                while((line = br.readLine()) != null) {
                    ArrayList<String> fields = new ArrayList(List.of(line.split(csvSplitBy)));
                    games.add(((String)fields.get(0)).substring(1, fields.get(0).length() - 1));
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

        return games;
    }
}




