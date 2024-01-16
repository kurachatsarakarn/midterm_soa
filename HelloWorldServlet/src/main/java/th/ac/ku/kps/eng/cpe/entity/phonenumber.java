package th.ac.ku.kps.eng.cpe.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class phonenumber {
	 @JsonProperty("num")
	private String number;
	public phonenumber() {
		
		// TODO Auto-generated constructor stub
	}
	public phonenumber(String num) {
		number = num;
		// TODO Auto-generated constructor stub
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}	
}
