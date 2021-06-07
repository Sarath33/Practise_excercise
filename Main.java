package dataLoadAndSearch;

import java.io.IOException;
import java.util.*;


import com.opencsv.CSVReader;

public class Main {
	
	public static void main(String argss[]) throws IOException
	{
		/*  Initial data loading */
		DataLoad data = new DataLoad();
		List<String[]> loaded_obj = data.Loader();
		
		
		/*  Getting filtering details */
		 Map<String, String> options = new HashMap<String, String> ();
         options.put("company_name", "Digg");
         options.put("round", "a");
         
         
         
         
         /*  Searched and return object */
         DataSearch search_obj = new DataSearch();
         Map<String, ArrayList<String>> mapped = search_obj.findBy(options,loaded_obj);
         
         
         
         /* Printing Details */
         Set set=mapped.entrySet();
         Iterator itr=set.iterator();  
         while(itr.hasNext()){  
              
             Map.Entry entry=(Map.Entry)itr.next();  
             ArrayList<String> final_list =(ArrayList<String>) entry.getValue();
           
             for(int j=0;j<final_list.size();j++)
            	 System.out.print(final_list.get(j)+" \t");
             System.out.println();
         }
         
         
       
	}

}
