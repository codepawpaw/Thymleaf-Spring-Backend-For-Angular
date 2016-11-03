package com.playfair.inseni.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="account")
public class UserGroup {
	private String _id;
	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
