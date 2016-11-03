package com.playfair.inseni.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection ="transaction")
public class Transaction {
	@Id
	private String id;
	private String donaturId;
	private String receiverId;
	private int amount;
	private String note;
	private String token;
	
	public Transaction(
		@JsonProperty("donaturId")String donaturId,
		@JsonProperty("receiverId")String receiverId,
		@JsonProperty("amount")int amount,
		@JsonProperty("note")String note,
		@JsonProperty("token")String token
	) {
		this.donaturId = donaturId;
		this.receiverId = receiverId;
		this.amount = amount;
		this.note = note;
		this.token = token;
    }
	
	public String getId(){
	   return id;	
	}
	
	public String getDonaturId(){
		return donaturId;
	}
	
	public String getReceiverId(){
		return receiverId;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public String getNote(){
		return note;
	}
	
	public String getToken(){
		return token;
	}
	
	public void setDonaturId(String donaturId){
		this.donaturId = donaturId;
	}
	
	public void setReceiverId(String receiverId){
		this.receiverId = receiverId;
	}
	
	public void setAmount(int amount){
		this.amount = amount;
	}
	
	public void setNote(String note){
		this.note = note;
	}
	
	public void setToken(String token){
		this.token = token;
	}
}
