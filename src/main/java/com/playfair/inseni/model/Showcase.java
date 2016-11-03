package com.playfair.inseni.model;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="showcase")
public class Showcase {
	private String title;
	private String description;
	private ArrayList<String> content;
	
	public Showcase(){
		this.content = new ArrayList<String>();
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void addContent(String content){
		this.content.add(content);
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getDescription(){
		return description;
	}
	
	public ArrayList<String> getContent(){
		return this.content;
	}

}
