package com.playfair.inseni.service;

import com.playfair.inseni.model.Account;

public interface AuthenticationService {
	
	/**
	   * This method will call mongodb command in account repository
	   * @param username
	   * @param password
	   */
	public Account findAccountByUsernameAndPassword(String username,String password);
	
	
	/**
	   * This method will call in rest service. 
	   * This method will call mongodb command in user repository
	   * @param username
	   * @param password
	   */
	public boolean isExist(String username,String password);
	
	/**
	   * This method will call in rest service. 
	   * This method will call mongodb command in user repository
	   * @param username
	   * @param password
	   */
	public boolean insert(String username, String password);
}
