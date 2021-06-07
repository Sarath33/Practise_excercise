package dataLoadAndSearch;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.opencsv.CSVReader;

public class DataLoad {
	
	
	List<String[]> Loader() throws IOException {
	
		
		List<String[]> csvData = new ArrayList<String[]>();
        CSVReader reader = new CSVReader(new FileReader("startup_funding.csv"));
    String[] row = null;

    while((row = reader.readNext()) != null) {
        csvData.add(row);
    }

    reader.close();
    csvData.remove(0);
    
    return csvData;
    
	}

}
