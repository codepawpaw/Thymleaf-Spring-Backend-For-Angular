package com.playfair.inseni.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.playfair.inseni.model.UserGroup;

public interface UserGroupRepository extends MongoRepository<UserGroup, String>{

}
