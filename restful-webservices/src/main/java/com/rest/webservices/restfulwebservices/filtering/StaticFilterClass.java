package com.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//to hide the fields in class level
//@JsonIgnoreProperties({"field1","field2"})
public class StaticFilterClass {
	public StaticFilterClass(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	//To hide a field form the response
	@JsonIgnore
	private String field1;
	
	//To give a ciustomized name to the field in the response
	@JsonProperty("Field2")
	private String field2;
	
	@JsonProperty("Field3")
	private String field3;

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

}
