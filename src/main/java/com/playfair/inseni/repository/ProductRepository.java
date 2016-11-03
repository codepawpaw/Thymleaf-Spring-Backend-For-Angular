package com.playfair.inseni.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.playfair.inseni.model.Account;
import com.playfair.inseni.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
	
	 /**
	   * Method to select product based on productId
	   *
	   * @param productId
	   * @return
	   */
	 @Query(value = "{'userId' : ?0}")
	 public List<Product> findByUserId(String userId);
	 
	 /**
	   * Method to select product based on productId
	   *
	   * @param productId
	   * @return
	   */
	 @Query(value = "{'userName' : ?0}")
	 public List<Product> findByUserName(String userName);

}
