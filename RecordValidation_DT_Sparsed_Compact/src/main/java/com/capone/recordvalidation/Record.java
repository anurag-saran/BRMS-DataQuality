package com.capone.recordvalidation;

import java.util.ArrayList;
import java.util.List;


public class Record {

	String record_id;
	int offer_id;
	String offer_type_cd;
	Double rate;
	String contract_date;
	Double pymt;
	String payment_method_type_cd;
	Boolean current_offer_flag;
	String offer_desc;
	String address;
	
	private List<String> validationMessages = new ArrayList<String>();
	private boolean isValid = true;
	
	public void addMessage(String msg) {
		validationMessages.add(msg);
	}
	
	public List<String >getMessages(){
		return validationMessages;
	}

	public Record(String record_id, int offer_id, String offer_type_cd,
			Double rate, String contract_date, Double pymt,
			String payment_method_type_cd, Boolean current_offer_flag,
			String offer_desc, String address) {
		super();
		this.record_id = record_id;
		this.offer_id = offer_id;
		this.offer_type_cd = offer_type_cd;
		this.rate = rate;
		this.contract_date = contract_date;
		this.pymt = pymt;
		this.payment_method_type_cd = payment_method_type_cd;
		this.current_offer_flag = current_offer_flag;
		this.offer_desc = offer_desc;
		this.address = address;
	}

	/**
	 * @return the record_id
	 */
	public String getRecord_id() {
		return record_id;
	}
	/**
	 * @param record_id the record_id to set
	 */
	public void setRecord_id(String record_id) {
		this.record_id = record_id;
	}
	/**
	 * @return the offer_id
	 */
	public int getOffer_id() {
		return offer_id;
	}
	/**
	 * @param offer_id the offer_id to set
	 */
	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}
	/**
	 * @return the offer_type_cd
	 */
	public String getOffer_type_cd() {
		return offer_type_cd;
	}
	/**
	 * @param offer_type_cd the offer_type_cd to set
	 */
	public void setOffer_type_cd(String offer_type_cd) {
		this.offer_type_cd = offer_type_cd;
	}
	/**
	 * @return the rate
	 */
	public Double getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(Double rate) {
		this.rate = rate;
	}
	/**
	 * @return the contract_date
	 */
	public String getContract_date() {
		return contract_date;
	}
	/**
	 * @param contract_date the contract_date to set
	 */
	public void setContract_date(String contract_date) {
		this.contract_date = contract_date;
	}
	/**
	 * @return the pymt
	 */
	public Double getPymt() {
		return pymt;
	}
	/**
	 * @param pymt the pymt to set
	 */
	public void setPymt(Double pymt) {
		this.pymt = pymt;
	}
	/**
	 * @return the payment_method_type_cd
	 */
	public String getPayment_method_type_cd() {
		return payment_method_type_cd;
	}
	/**
	 * @param payment_method_type_cd the payment_method_type_cd to set
	 */
	public void setPayment_method_type_cd(String payment_method_type_cd) {
		this.payment_method_type_cd = payment_method_type_cd;
	}
	/**
	 * @return the current_offer_flag
	 */
	public Boolean getCurrent_offer_flag() {
		return current_offer_flag;
	}
	/**
	 * @param current_offer_flag the current_offer_flag to set
	 */
	public void setCurrent_offer_flag(Boolean current_offer_flag) {
		this.current_offer_flag = current_offer_flag;
	}
	/**
	 * @return the offer_desc
	 */
	public String getOffer_desc() {
		return offer_desc;
	}
	/**
	 * @param offer_desc the offer_desc to set
	 */
	public void setOffer_desc(String offer_desc) {
		this.offer_desc = offer_desc;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	

	@Override
	public String toString() {
		return ("Record ["+ "record_id :" +  record_id +
	"offer_id :" +  offer_id +" , " +
	"offer_type_cd :" +  offer_type_cd + " , " +
	"rate :" +  rate +" , " +
	"contract_date :" +  contract_date + " , " +
	"pymt :" +  pymt + " , " +
	"payment_method_type_cd :" +  payment_method_type_cd + " , " +
	"current_offer_flag :" +  current_offer_flag  + " , " +
	"offer_desc :" +  offer_desc  + " , " +
	"address :" +  address + "]");
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
}
