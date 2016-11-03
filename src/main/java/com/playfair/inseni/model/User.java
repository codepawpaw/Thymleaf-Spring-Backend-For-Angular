package com.playfair.inseni.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="user")
public class User {
	private @Id String id;
	private String name;
	private String email;
	private String user_group;
	private String phone_number;
	private String address;
	private String city;
	private int follower_count;
	private ArrayList<String> followed;
	
	public User(){
		followed = new ArrayList<String>();
	}
	
	public String getId(){
		return id;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getName(){
		return name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getUserGroup(){
		return user_group;
	}
	
	public String getPhoneNumber(){
		return phone_number;
	}
	
	public String getAddress(){
		return address;
	}
	
	public int getFollowerCount(){
		return follower_count;
	}
	
	public ArrayList<String> getFollowed(){
		return followed;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setUserGroup(String userGroup){
		this.user_group = userGroup;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phone_number = phoneNumber;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setFollowerCount(int followerCount){
		this.follower_count = followerCount;
	}
	
	public void addFollowed(String followed){
		this.followed.add(followed);
	}
}
