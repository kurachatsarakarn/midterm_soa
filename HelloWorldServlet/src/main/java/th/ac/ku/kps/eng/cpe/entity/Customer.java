package th.ac.ku.kps.eng.cpe.entity;


import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Customer {
	private String name;
	
	private ArrayList<phonenumber> phonenumbers;
	
	
	public Customer(String name) {
		this.name = name;
		
	}
	
	public Customer() {
		phonenumbers = new ArrayList<phonenumber>();
		
	}
	@JsonProperty("hi")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("olo")
	public ArrayList<phonenumber> getPhonenumbers() {
		return phonenumbers;
	}
	
	public void setPhonenumbers(ArrayList<phonenumber> phonenumbers) {
		this.phonenumbers = phonenumbers;
	}
	
}

