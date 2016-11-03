package com.playfair.inseni.service;

import javax.inject.Inject;

import com.playfair.inseni.model.Account;
import com.playfair.inseni.repository.AccountRepository;
import com.playfair.inseni.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService{
	
	@Inject
	private AccountRepository accountRepository;
	
	/**
	   * This method will call mongodb command in account repository
	   * @param username
	   * @param password
	   */
	public Account findAccountByUsernameAndPassword(String username,String password){
		return accountRepository.findByUsernameAndPassword(username,password);
	}
	
	/**
	   * This method will call in rest service. 
	   * This method will call mongodb command in user repository
	   * @param username
	   * @param password
	   */
	public boolean isExist(String username,String password){
		if(accountRepository.findByUsernameAndPassword(username,password) == null){
			return false;
		}
		return true;
	}
	
	/**
	   * This method will call in rest service. 
	   * This method will call mongodb command in user repository
	   * @param username
	   * @param password
	   */
	public boolean insert(String username, String password){
		try{
			if(accountRepository.findByUsernameAndPassword(username, password) == null){
				Account account = new Account(username, password);
				account.setId(null);
				accountRepository.save(account);
			} else {
			    return false;	
			}
		} catch(Exception e){
			return false;
		}
		return true;
	}
	
	

}
