package com.playfair.inseni.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.playfair.inseni.model.Account;
import com.playfair.inseni.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	/**
	   * Method to select user based on email 
	   *
	   * @param username
	   * @param password
	   * @return
	   */
	 @Query(value = "{'email' : ?0}")
	 public User findByEmail(String email);
}
