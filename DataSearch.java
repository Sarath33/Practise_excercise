package dataLoadAndSearch;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.opencsv.CSVReader;

public class DataSearch {




public static Map<String, ArrayList<String> > findBy(Map<String, String> options,List<String[]> csvData) throws IOException{
    
 
    
   
    Map<String, ArrayList<String>> mapped = new HashMap<String, ArrayList<String>> ();
    initializeMapped(mapped);

    for(int i = 0; i < csvData.size(); i++) {
    	
    	String str[] = new String[10];
        if(options.containsKey("company_name")) {
            if(csvData.get(i)[1].equals(options.get("company_name"))) {
                
                
                for(int j=0;j<10;j++)
                	str[j] = csvData.get(i)[j];
               
            } else {
                continue;
            }
        }

        if(options.containsKey("city")) {
            if(!csvData.get(i)[4].equals(options.get("city"))) {
              continue;
            } 
        }

        if(options.containsKey("state")) {
            if(!csvData.get(i)[5].equals(options.get("state"))) {
              continue;
        }}

        if(options.containsKey("round")) {
            if(!csvData.get(i)[9].equals(options.get("round"))) {
            	continue;
            }
        }
        
        appendData(mapped,str);
        
        
    }
   
   
    
    return mapped;
}

	static void  appendData(Map<String,ArrayList<String>> mapper,String[] str)
	{
		   Set set=mapper.entrySet();
		    Iterator itr=set.iterator();  
		    int i = 0;
		    while(itr.hasNext() && i<10){  
		        
		        Map.Entry entry=(Map.Entry)itr.next();   
		        ArrayList<String> temp_list =(ArrayList<String>) entry.getValue();
		        
		       
		        
		        temp_list.add(str[i++]);
		    }  
		    
	}
	
	static void initializeMapped(Map<String,ArrayList<String>> mapped)
	{
		 mapped.put("permalink", new ArrayList<>());
         mapped.put("company_name", new ArrayList<>());
         mapped.put("number_employees", new ArrayList<>());
         mapped.put("category", new ArrayList<>());
         mapped.put("city", new ArrayList<>());
         mapped.put("state", new ArrayList<>());
         mapped.put("funded_date",new ArrayList<>() );
         mapped.put("raised_amount", new ArrayList<>());
         mapped.put("raised_currency",new ArrayList<>());
         mapped.put("round", new ArrayList<>());
	}
}