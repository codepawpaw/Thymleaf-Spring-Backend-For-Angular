package com.playfair.inseni.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.playfair.inseni.model.Product;
import com.playfair.inseni.model.Transaction;
import com.playfair.inseni.service.PaymentService;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

@RestController
@RequestMapping("/inseni")
public class PaymentResource {
	@Inject
    private PaymentService paymentService;
    
    /**
	   * Record transaction data
	   * This method will return json data type.
	   * @param username
	   * @param password
	   * @return
	   * @throws APIException 
	   * @throws APIConnectionException 
	   * @throws InvalidRequestException 
	   * @throws AuthenticationException 
	*/
    @CrossOrigin
    @RequestMapping(value = "/rest/payment/record",
            method = RequestMethod.POST)
    public @ResponseBody String record(@RequestBody Transaction transaction) {
    	Stripe.apiKey = "sk_test_UPaPflaPnRajRoqTbcxrpLlJ";

    	// Get the credit card details submitted by the form
    	String response;

    	// Create the charge on Stripe's servers - this will charge the user's card
    	try {
    	  Map<String, Object> chargeParams = new HashMap<String, Object>();
    	  chargeParams.put("amount", transaction.getAmount()); // amount in cents, again
    	  chargeParams.put("currency", "usd");
    	  chargeParams.put("source", transaction.getToken());
    	  chargeParams.put("description", transaction.getDonaturId() + " donate to " + transaction.getReceiverId());

    	  Charge charge = Charge.create(chargeParams);
    	  if (paymentService.insert(transaction)) {
    		  //System.out.println("error");
    		  //response = "[\"error\":\"false\", \"success\":\"Transaction is succeed and recorded\"]";
    		  response = "[]";
    	  }
    	  else {
    		  //response = "{\"error\":\"false\", \"success\":\"Transaction is succeed but not recorded\"}";
    		  response = "[]";
    	  }
    	} catch (CardException e) {
    		//response = "{\"error\":\"true\", \"message\":\"" + e.getMessage() + "\"}";
    		response = "[]";
    	} catch (AuthenticationException e) {
    		//response = "{\"error\":\"true\", \"message\":\"" + e.getMessage() + "\"}";
    		response = "[]";
		} catch (InvalidRequestException e) {
			//response = "{\"error\":\"true\", \"message\":\"" + e.getMessage() + "\"}";
			response = "[]";
		} catch (APIConnectionException e) {
			//response = "{\"error\":\"true\", \"message\":\"" + e.getMessage() + "\"}";
			response = "[]";
		} catch (APIException e) {
			//response = "{\"error\":\"true\", \"message\":\"" + e.getMessage() + "\"}";
			response = "[]";
		}
    	return response;
    }
    
    /**
	   * Get transaction data
	   * This method will return json data type.
	   * @return
	   */
	@CrossOrigin
	@RequestMapping(value = "/rest/payment/record/by/receiverId/{receiverId}",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> findByReceiverId(@PathVariable String receiverId) {
		return paymentService.findTransactionByReceiverId(receiverId);
	}
	
	/**
	   * Get transaction data
	   * This method will return json data type.
	   * @return
	   */
	@CrossOrigin
	@RequestMapping(value = "/rest/payment/totaldonation/by/receiverId/{receiverId}",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public String getTotalDonationByReceiverId(@PathVariable String receiverId) {
		return "["+paymentService.getTotalDonationByReceiverId(receiverId)+"]";
	}
    
    
}
