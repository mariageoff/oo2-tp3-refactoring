package ejercicio2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV implements   FuenteDeDatos{

    private final String csvPath;

    public LectorCSV(String csvPath) {
        this.csvPath = csvPath;
    }

    @Override
    public List<String[]> toList() {
        try {
            List<String[]> csvData = new ArrayList<String[]>();
            CSVReader reader = new CSVReader(new FileReader(this.csvPath));
            String[] row;

            while ((row = reader.readNext()) != null) {
                csvData.add(row);
            }

            reader.close();
            csvData.removeFirst();
            return csvData;

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
