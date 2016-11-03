package com.playfair.inseni.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.playfair.inseni.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String>{
	
	 @Query(value = "{'_id' : ?0}")
	 public Transaction findById(String id);
	 
	 @Query(value = "{'token' : ?0}")
	 public Transaction findByToken(String token);
	 
	 @Query(value = "{'receiverId' : ?0}")
	 public List<Transaction> findByReceiverId(String receiverId);

}
