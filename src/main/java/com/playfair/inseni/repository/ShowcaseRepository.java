package com.playfair.inseni.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.playfair.inseni.model.Showcase;

public interface ShowcaseRepository extends MongoRepository<Showcase, String>{

}
