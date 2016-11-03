package com.playfair.inseni.model;


import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="product")
public class Product {
	//private @Id String id;
	private String userId;
	private String userName;
	private String title;
	private String description;
	private String content;
	private ArrayList<String> like;
	
	public Product(String title, String description, String content, String userName){
		this.title = title;
		this.description = description;
		this.content = content;
		this.userName = userName;
		like = new ArrayList<String>();
	}
	
	public void setUserId(String userId){
		this.userId = userId;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public void addLike(String userId){
		this.like.add(userId);
	}
	
	public String getUserId(){
		return userId;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getContent(){
		return content;
	}
	
	public ArrayList<String> getLike(){
		return like;
	}
}
