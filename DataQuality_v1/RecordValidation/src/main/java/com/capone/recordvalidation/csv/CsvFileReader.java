package com.capone.recordvalidation.csv;
	import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.capone.recordvalidation.Record;

	/**
	 * @author
	 *
	 */
	public class CsvFileReader {
		
		//Delimiter used in CSV file
		private static final String COMMA_DELIMITER = ",";
		
			
		//Record attributes index
		private static final int  Record_record_ide=0;
		private static final int  Record_offer_id=1;
		private static final int  Record_offer_type_cd=2;
		private static final int  Record_rate=3;
		private static final int  Record_contract_date=4;
		private static final int  Record_pymt=5;
		private static final int  Record_payment_method_type_cd=6;
		private static final int  Record_current_offer_flage=7;
		private static final int  Record_offer_desc=8;
		private static final int  Record_offer_address=9;

		
														
		public  List<Record> readCsvFile(String fileName) {
        	//Create a new list of fr to be filled by CSV file data 
			List<Record> fieldress = new ArrayList<Record>();
			BufferedReader fileReader = null;
			
	        try {
	            String line = "";
	            
	            //Create the file reader
	            fileReader = new BufferedReader(new FileReader(fileName));
	            
	            //Read the CSV file header to skip it
	            fileReader.readLine();
	           
	            //Read the file line by line starting from the second line
	            while ((line = fileReader.readLine()) != null  ) {
	                //Get all tokens available in line
	            	//System.out.println("\nLine:"+line);
	                String[] tokens = line.split(COMMA_DELIMITER);
	                if (tokens.length > 0) {
	                	//Create a new fr object and fill his  data
	                	
	                	Record fr = new 
								Record(
										tokens[Record_record_ide], 
										Integer.parseInt(tokens[Record_offer_id]), 
										tokens[Record_offer_type_cd], 
										Double.parseDouble(tokens[Record_rate]), 
										(tokens[Record_contract_date]), 
										Double.parseDouble(tokens[Record_pymt]), 
										tokens[Record_payment_method_type_cd], 
										Boolean.parseBoolean(tokens[Record_current_offer_flage]), 
										tokens[Record_offer_desc], 
										tokens[Record_offer_address]
								);
						fieldress.add(fr);
					}
	            }
	            
	            //Print the new fr list
	            //for (Record f : fieldress) {
				//	System.out.println(f.toString());
				//}
	        } 
	        catch (Exception e) {
	        	System.out.println("Error in CsvFileReader !!!");
	            e.printStackTrace();
	        } finally {
	            try {
	                fileReader.close();
	            } catch (IOException e) {
	            	System.out.println("Error while closing fileReader !!!");
	                e.printStackTrace();
	            }
	        }

	        return fieldress;

		}

	}

			