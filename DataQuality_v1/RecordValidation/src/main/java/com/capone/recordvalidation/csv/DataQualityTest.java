package com.capone.recordvalidation.csv;

import java.util.ArrayList;
import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;

import com.capone.processes.ManageDT;
import com.capone.recordvalidation.Record;


public class DataQualityTest {

	public static void main(String[] args) {
		ManageDT manager = new ManageDT();
		
		manager.loadDT();
		KnowledgeBase kb = manager.getKnowledgeBase();
		StatefulKnowledgeSession session = kb.newStatefulKnowledgeSession();

		// TODO Auto-generated method stub
		String fileName = "dataInput1.csv";
		System.out.println("\nRead CSV file:");
		CsvFileReader myreader = new CsvFileReader();
		
		List<Record> recordList  = new  ArrayList<Record>();
		recordList = myreader.readCsvFile(fileName);
		
		System.out.println("\nRead CSV file: DATA Below:"+recordList);
		
		for (Record record : recordList) {
			//System.out.println(record.isValid());
			System.out.println(record.toString());
		}

		for (Record r : recordList) {
			session.insert(r);
		}
		
		session.fireAllRules();
		
		System.out.println("\nFireAllRules: DATA Below:");
		for (Record record : recordList) {
			//System.out.println(record.isValid());
			System.out.println(record.getMessages());
		}

		fileName = "dataLoadResult.csv";
		System.out.println("Write CSV file:");
		CsvFileWriter.writeCsvFile(fileName, recordList);
	}

}