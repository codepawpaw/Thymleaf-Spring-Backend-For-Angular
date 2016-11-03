package com.playfair.inseni.service;

import com.playfair.inseni.model.User;

public interface UserService {
	
	/**
	   * This method will call mongodb command in account repository
	   * @param User
	*/
	public boolean save(User user);
	
	/**
	   * This method will call mongodb command in account repository
	   */
	public User getUSerById(String _id);
	
	/**
	   * This method will call mongodb command in account repository
	   */
	public User getUSer(String id);

}
