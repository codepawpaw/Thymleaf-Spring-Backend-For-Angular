package com.playfair.inseni.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="account")
public class Account {
	@Id
	private String id;
	private String username;
	private String password;
	private String salt;
	
	public Account(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public String getId(){
	   return id;	
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getSalt(){
		return salt;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setSalt(String salt){
		this.salt = salt;
	}
	
	
}
