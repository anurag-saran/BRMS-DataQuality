package com.capone.recordvalidation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capone.processes.CompactDecisionTableKieBaseProvider;
import com.capone.processes.SparseDecisionTableKieBaseProvider;
import com.capone.recordvalidation.csv.CsvFileReader;
import com.capone.recordvalidation.csv.CsvFileWriter;

/**
 * @author asaran
 *
 */
public class RulesTest {
	private static final Logger LOG = LoggerFactory.getLogger(RulesTest.class);

	private static SparseDecisionTableKieBaseProvider dtableSparseManager = new SparseDecisionTableKieBaseProvider();
	private static CompactDecisionTableKieBaseProvider dtableCompactManager = new CompactDecisionTableKieBaseProvider();
	


/*	@Test
	public void testSparseDecisionTableRules() {
		LOG.info("Testing with decision table");
		testRules(dtableSparseManager.getKieBase(), "SparseDT_ResultFile");
	}*/
	
	@Test
	public void testCompactDecisionTableRules() {
		LOG.info("Testing with decision table");
		testRules(dtableCompactManager.getKieBase(), "CompactDT_ResultFile");
	}
	
	
	private void testRules(KieBase kieBase, String outPutFileName) {
		KieSession session = kieBase.newKieSession();
		String fileName = "dataInput1.csv";
		CsvFileReader myreader = new CsvFileReader();
		
		List<Record> recordList  = new  ArrayList<Record>();
		recordList = myreader.readCsvFile(fileName);
		
		LOG.info("Read Data from CSV file:");
		for (Record record : recordList) {
			LOG.info(record.toString());
		}

		for (Record r : recordList) {
			session.insert(r);
		}
		
		session.fireAllRules();

		
		LOG.info("After firing all rules:");
		/*for (Record record : recordList) {
			Assert.assertTrue("Every record should have an error, this one doesn't : " + record, record.getMessages().size() > 0);
			LOG.info(record.getMessages().toString());
		}*/

		//fileName = outPutFileName;
		//CsvFileWriter.writeCsvFile(outPutFileName, recordList);
		CsvFileWriter.writeCsvFileCompact(outPutFileName, recordList);
	}
}
