package com.playfair.inseni.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="otp")
public class Otp {
	
	private String phone_number;
	private String otp_code;
	private String expired;
	
	public void setPhoneNumber(String phone_number){
		this.phone_number = phone_number;
	}
	
	public void setOtpCode(String otp_code){
		this.otp_code = otp_code;
	}
	
	public void setExpired(String expired){
		this.expired = expired;
	}
	
	public String getPhoneNumber(){
		return this.phone_number;
	}
	
	public String getOtpCode(){
		return this.otp_code;
	}
	
	public String getExpired(){
		return this.expired;
	}

}
