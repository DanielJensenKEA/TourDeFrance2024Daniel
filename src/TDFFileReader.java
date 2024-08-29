import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.*;

public class TDFFileReader {
    private String fileName;
    private Scanner sc;
    private File file;
    private List<Cyclist> loadedList;
    Cyclist cyc;


    public TDFFileReader(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        file = new File(fileName+".csv");
        sc = new Scanner(file);
        //readFile();
    }

    public List<Cyclist> readFile() {
        loadedList = new ArrayList<>();

        while(sc.hasNext()) {
            String line = sc.nextLine();

            String[] attributes = line.split(";");
            //placering;rytter;hold;tid;tidsforskel

            cyc = new Cyclist(
                    attributes[1], //rytter
                    attributes[2]); //hold
            loadedList.add(cyc);
        }
        return loadedList;
    }
}
