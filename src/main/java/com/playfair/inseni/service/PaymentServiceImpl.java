package com.playfair.inseni.service;

import java.util.List;

import javax.inject.Inject;

import com.playfair.inseni.model.Transaction;
import com.playfair.inseni.repository.TransactionRepository;
import com.playfair.inseni.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
	
	@Inject
	private TransactionRepository transactionRepository;
	
	public Transaction findTransactionById(String id){
		return transactionRepository.findById(id);
	}
	
	public List<Transaction> findTransactionByReceiverId(String receiverId){
		return transactionRepository.findByReceiverId(receiverId);
	}
	
	public Transaction findTransactionByToken(String token){
		return transactionRepository.findByToken(token);
	}
	
	public String getTotalDonationByReceiverId(String receiverId){
		String total = "";
		int temp=0;
		List<Transaction> transactions = transactionRepository.findByReceiverId(receiverId);
		for(int i=0;i<transactions.size();i++){
			temp += transactions.get(i).getAmount();
		}
		total = String.valueOf(temp);
		return total;
	}
	
	/**
	   * Called in REST service 
	   */
	public boolean insert(Transaction transaction){
		try{
			transactionRepository.save(transaction);
		} catch(Exception e){
			return false;
		}
		return true;
	}

}
