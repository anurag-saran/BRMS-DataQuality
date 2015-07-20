/**
 * 
 */
package com.capone.recordvalidation;

/**
 * @author asaran
 * 
 */
public class FieldRestrictions { 
	String datatype;
	Integer minrange;
	Integer maxrange;
	String list;
	Integer length;
	String pattern;
	String fieldname;;
	String value;
	String result;

	public FieldRestrictions(String datatype, Integer minrange,
			Integer maxrange, String list, Integer length, String pattern,
			String fieldname, String value, String result) {
		super();
		this.datatype = datatype;
		this.minrange = minrange;
		this.maxrange = maxrange;
		this.list = list;
		this.length = length;
		this.pattern = pattern;
		this.fieldname = fieldname;
		this.value = value;
		this.result = result;
	}

	/**
	 * @return the datatype
	 */
	public String getDatatype() {
		return datatype;
	}

	/**
	 * @param datatype
	 *            the datatype to set
	 */
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	/**
	 * @return the minrange
	 */
	public Integer getMinrange() {
		return minrange;
	}

	/**
	 * @param minrange
	 *            the minrange to set
	 */
	public void setMinrange(Integer minrange) {
		this.minrange = minrange;
	}

	/**
	 * @return the maxrange
	 */
	public Integer getMaxrange() {
		return maxrange;
	}

	/**
	 * @param maxrange
	 *            the maxrange to set
	 */
	public void setMaxrange(Integer maxrange) {
		this.maxrange = maxrange;
	}

	/**
	 * @return the list
	 */
	public String getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(String list) {
		this.list = list;
	}

	/**
	 * @return the length
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(Integer length) {
		this.length = length;
	}

	/**
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * @param pattern
	 *            the pattern to set
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	/**
	 * @return the fieldname
	 */
	public String getFieldname() {
		return fieldname;
	}

	/**
	 * @param fieldname
	 *            the fieldname to set
	 */
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "FieldRestrictions [datatype=" + datatype + ", minrange=" + minrange
				+ ", maxrange=" + maxrange + ", list=" + list + ", length="
				+ length + ", pattern=" + pattern + ", fieldname=" + fieldname +  
				", value=" + value  + ", result=" + result+ "]";
	}
}
