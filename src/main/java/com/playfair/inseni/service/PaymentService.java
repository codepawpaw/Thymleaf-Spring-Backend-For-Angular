package com.playfair.inseni.service;

import java.util.List;

import com.playfair.inseni.model.Transaction;

public interface PaymentService {
	
	public Transaction findTransactionById(String id);
	
	public Transaction findTransactionByToken(String token);
	
	public boolean insert(Transaction transaction);
	
	public List<Transaction> findTransactionByReceiverId(String artistId);
	
	public String getTotalDonationByReceiverId(String receiverId);
}
