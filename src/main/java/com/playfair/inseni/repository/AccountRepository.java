package com.playfair.inseni.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.playfair.inseni.model.Account;

public interface AccountRepository extends MongoRepository<Account, String>{
	
	/**
	   * Method to select account based on username and password
	   *
	   * @param username
	   * @param password
	   * @return
	   */
	 @Query(value = "{'username' : ?0, 'password' : ?1}")
	 public Account findByUsernameAndPassword(String username,String password);

}
