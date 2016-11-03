package com.playfair.inseni.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playfair.inseni.model.Account;
import com.playfair.inseni.model.User;
import com.playfair.inseni.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Inject
	private UserRepository userRepository;
	
	/**
	   * This method will call mongodb command in account repository
	   * @param User
	   */
	public boolean save(User user){
		try{
			userRepository.save(user);
		} catch(Exception e){
			return false;
		}
		return true;
	}
	
	/**
	   * This method will call mongodb command in account repository
	   */
	public User getUSerById(String email){
		return userRepository.findByEmail(email);

	}
	
	/**
	   * This method will call mongodb command in account repository
	   */
	public User getUSer(String id){
		return userRepository.findOne(id);

	}

}
