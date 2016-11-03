package com.playfair.inseni.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.playfair.inseni.model.Otp;

public interface OtpRepository extends MongoRepository<Otp, String>{

}
