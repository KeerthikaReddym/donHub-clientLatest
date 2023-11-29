package com.donHub.donHub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.donHub.donHub.model.ProductRequest;

public interface UserRepositoryI extends MongoRepository<UserRequest, Integer>{

}
