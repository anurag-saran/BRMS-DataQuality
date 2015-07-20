package com.capone.recordvalidation;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;

public class JunitRules extends TestCase {

	/**
	 * simple runner test method that exercises each of our rules
	 */
	@Test
	public void testRules() {
		
		// instantiate a null session for final disposal check
		StatefulKnowledgeSession session = null;
		
		try {
			
			// seed a builder with our rules file from classpath
			KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
			//builder.add(ResourceFactory.newClassPathResource("validRecord.xls"), ResourceType.DTABLE);
			builder.add(ResourceFactory.newClassPathResource("validRecord_MergedRules.xls"), ResourceType.DTABLE);
			if (builder.hasErrors()) {
			    throw new RuntimeException(builder.getErrors().toString());
			}
	
			// create a knowledgeBase from our builder packages
			KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
			knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());
			
			// initialize a session for usage
			session = knowledgeBase.newStatefulKnowledgeSession();
//	
//			// lenght
//			FieldRestrictions fr = new FieldRestrictions("",null,null,"",2,"","OriginID","Anurag","");
//			FactHandle fieldRestFact = session.insert(fr);
//	        session.fireAllRules();
//	        System.out.println("----------------"+fr.fieldname);
//	        System.out.println("----------------"+fr.length);
//	        System.out.println("----------------"+fr.value);
//	        System.out.println("----------------"+fr.result);
//	        
//			// List
//			fr = new FieldRestrictions("",null,null,"aa bb cc dd",null,"","OriginID","bb","");
//			FactHandle fieldRestFact1 = session.insert(fr);
//	        session.fireAllRules();
//	        System.out.println("----------------"+fr.fieldname);
//	        System.out.println("----------------"+fr.list);
//	        System.out.println("----------------"+fr.value);
//	        System.out.println("----------------"+fr.result);
//	        
//	        //Pattern
//			fr = new FieldRestrictions("",null,null,"",null,"[A-Z][A-Z]","OriginID","AX","");
//			FactHandle fieldRestFact3 = session.insert(fr);
//	        session.fireAllRules();
//	        System.out.println("----------------"+fr.fieldname);
//	        System.out.println("----------------"+fr.pattern);
//	        System.out.println("----------------"+fr.value);
//	        System.out.println("----------------"+fr.result);
//	        
//	        	//Range
//				fr = new FieldRestrictions("",10,20,"",null,"","OriginID","15","");
//				FactHandle fieldRestFact4 = session.insert(fr);
//		        session.fireAllRules();
//		        System.out.println("----------------"+fr.fieldname);
//		        System.out.println("----------------"+fr.minrange);
//		        System.out.println("----------------"+fr.maxrange);
//		        System.out.println("----------------"+fr.value);
//		        System.out.println("----------------"+fr.result);
			
			List<Record> records = new ArrayList<Record>();
			records.add(new Record("R_01", 4000, "9AB", 99.0,"12/12/2014", 3.0, "CASH", false, "desc", "addr"));
			//RecordID
			records.add(new Record("R", 4000, "9AB", 99.0,"12/12/2014", 3.0, "CASH", false, "desc", "addr"));
			//RecordId length
			records.add(new Record("R",     4000, "9AB", 99.0,"12/12/2014", 3.0, "CASH", false, "desc", "addr"));
			//Code
			records.add(new Record("R", 4000, "XAB", 99.0,"12/12/2014", 3.0, "CASH", false, "desc", "addr"));
			//List-CASH
			records.add(new Record("Rabc", 4000, "9AB", 99.0,"12/12/2014", 3.0, "Paypal", false, "desc", "addr"));
			//Rate
			records.add(new Record("recid_00001", 4000, "9AB", 999.0,"12/12/2014", 3.0, "CASH", false, "desc", "addr"));
			//Multiple Issues
			records.add(new Record("Xecid_1", 4000, "SAB", 999.0,"12/12/2014", 3.0, "IPay", false, "desc", "addr"));
			for (Record record : records) {
				session.insert(record);
			}
			session.fireAllRules();
			
			for (Record record : records) {
				//System.out.println(record.isValid());
				System.out.println(record.getMessages());
			}

	        
		} catch(Throwable t) {
            t.printStackTrace();
        } finally {
    		// if we still have a session at this point, we need to clean it up
        	if (session != null) { 
        		session.dispose();
        	}
        }
	}
}
