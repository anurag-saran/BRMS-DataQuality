package com.capone.recordvalidation.csv;
import com.capone.recordvalidation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 
 * 
 */
public class CsvFileWriter {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//CSV file header
	private static final String FILE_HEADER = "record_id,offer_id,offer_type_cd,rate,contract_date,pymt,payment_method_type_cd,current_offer_flag,offer_desc,address";

	public static void writeCsvFile(String fileName, List<Record> records) {
		
		/*//Create new Records objects
		Record Record1 = new Record("Rec001", 101, "ChristmasDist", 12.0, null, 111.50, "Cash", true, "ValidChrist", "Chicago");
		Record Record2 = new Record("Rec001", 101, "ChristmasDist", 12.0, null, 111.50, "Cash", true, "ValidChrist", "Chicago");
		Record Record3 = new Record("Rec001", 101, "ChristmasDist", 12.0, null, 111.50, "Cash", true, "ValidChrist", "Chicago");
		Record Record4 = new Record("Rec001", 101, "ChristmasDist", 12.0, null, 111.50, "Cash", true, "ValidChrist", "Chicago");
		Record Record5 = new Record("Rec001", 101, "ChristmasDist", 12.0, null, 111.50, "Cash", true, "ValidChrist", "Chicago");
		Record Record6 = new Record("Rec001", 101, "ChristmasDist", 12.0, null, 111.50, "Cash", true, "ValidChrist", "Chicago");
		
		//Create a new list of Record objects
		List<Record> Records = new ArrayList<Record>();
		Records.add(Record1);
		Records.add(Record2);
		Records.add(Record3);
		Records.add(Record4);
		Records.add(Record5);
		Records.add(Record6);*/
		
		FileWriter corrFileWriter = null;
		FileWriter errorFileWriter  = null;
		try {
			corrFileWriter = new FileWriter(fileName);
			errorFileWriter = new FileWriter("ErrorFile.csv");
			
			//Write the CSV file header
			corrFileWriter.append(FILE_HEADER.toString());
			errorFileWriter.append(FILE_HEADER.toString());
			//Add a new line separator after the header
			corrFileWriter.append(NEW_LINE_SEPARATOR);
			errorFileWriter.append(NEW_LINE_SEPARATOR);
	
			
			//Write a new Record object list to the CSV file
			for (Record Record : records) {
				if(Record.getMessages().isEmpty()) {
					corrFileWriter.append((Record.getRecord_id()));
					corrFileWriter.append(COMMA_DELIMITER);
					corrFileWriter.append(String.valueOf(Record.getOffer_id()));
					corrFileWriter.append(COMMA_DELIMITER);
					corrFileWriter.append((Record.getOffer_type_cd()));
					corrFileWriter.append(COMMA_DELIMITER);
					corrFileWriter.append(String.valueOf(Record.getRate()));
					corrFileWriter.append(COMMA_DELIMITER);
					corrFileWriter.append(String.valueOf(Record.getContract_date()));
					corrFileWriter.append(COMMA_DELIMITER);
					corrFileWriter.append(String.valueOf(Record.getPymt()));
					corrFileWriter.append(COMMA_DELIMITER);
					corrFileWriter.append(Record.getPayment_method_type_cd());
					corrFileWriter.append(COMMA_DELIMITER);
					corrFileWriter.append(String.valueOf(Record.getCurrent_offer_flag()));
					corrFileWriter.append(COMMA_DELIMITER);
					corrFileWriter.append(Record.getOffer_desc());
					corrFileWriter.append(COMMA_DELIMITER);
					corrFileWriter.append(Record.getAddress());
					//errorFileWriter.append(COMMA_DELIMITER);
					//corrFileWriter.append(Record.getMessages().toString());
					corrFileWriter.append(NEW_LINE_SEPARATOR);
				} else {
					errorFileWriter.append((Record.getRecord_id()));
					errorFileWriter.append(COMMA_DELIMITER);
					errorFileWriter.append(String.valueOf(Record.getOffer_id()));
					errorFileWriter.append(COMMA_DELIMITER);
					errorFileWriter.append((Record.getOffer_type_cd()));
					errorFileWriter.append(COMMA_DELIMITER);
					errorFileWriter.append(String.valueOf(Record.getRate()));
					errorFileWriter.append(COMMA_DELIMITER);
					errorFileWriter.append(String.valueOf(Record.getContract_date()));
					errorFileWriter.append(COMMA_DELIMITER);
					errorFileWriter.append(String.valueOf(Record.getPymt()));
					errorFileWriter.append(COMMA_DELIMITER);
					errorFileWriter.append(Record.getPayment_method_type_cd());
					errorFileWriter.append(COMMA_DELIMITER);
					errorFileWriter.append(String.valueOf(Record.getCurrent_offer_flag()));
					errorFileWriter.append(COMMA_DELIMITER);
					errorFileWriter.append(Record.getOffer_desc());
					errorFileWriter.append(COMMA_DELIMITER);
					errorFileWriter.append(Record.getAddress());
				
					errorFileWriter.append(COMMA_DELIMITER);
					errorFileWriter.append(Record.getMessages().toString());
					errorFileWriter.append(NEW_LINE_SEPARATOR);
			}
			}

			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				corrFileWriter.flush();
				corrFileWriter.close();
				errorFileWriter.flush();
				errorFileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}
}