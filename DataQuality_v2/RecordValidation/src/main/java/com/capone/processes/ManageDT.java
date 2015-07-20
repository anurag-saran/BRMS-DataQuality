package com.capone.processes;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import com.capone.recordvalidation.Record;

public class ManageDT {
	private KnowledgeBase knowledgeBase = null;

	/**
	 * @return the knowledgeBase
	 */
	public KnowledgeBase getKnowledgeBase() {
		return knowledgeBase;
	}
	
	/**
	 * @param knowledgeBase the knowledgeBase to set
	 */
	public void setKnowledgeBase(KnowledgeBase knowledgeBase) {
		this.knowledgeBase = knowledgeBase;
	}
	
	public void loadDT() {
		// instantiate a null session for final disposal check
		// StatefulKnowledgeSession session = null;

		try {

			// seed a builder with our rules file from classpath
			KnowledgeBuilder builder = KnowledgeBuilderFactory
					.newKnowledgeBuilder();
			//builder.add(ResourceFactory.newClassPathResource("validRecord_MergedRules.xls"),ResourceType.DTABLE);
			builder.add(ResourceFactory.newClassPathResource("validRecord.xls"),ResourceType.DTABLE);
			if (builder.hasErrors()) {
				throw new RuntimeException(builder.getErrors().toString());
			}

			// create a knowledgeBase from our builder packages
			knowledgeBase = KnowledgeBaseFactory
					.newKnowledgeBase();
			knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());

			// initialize a session for usage
			//session = knowledgeBase.newStatefulKnowledgeSession();
			// return session;
		} catch (Throwable t) {
			t.printStackTrace();
		} /*finally {
			// if we still have a session at this point, we need to clean it up
			if (session != null) {
				session.dispose();
			}
		}*/
	}
	public  void ValidateRecords() {
		

	}
	
}
