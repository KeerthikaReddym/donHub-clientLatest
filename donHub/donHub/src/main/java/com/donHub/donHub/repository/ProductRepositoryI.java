package com.donHub.donHub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.donHub.donHub.model.ProductRequest;
import com.donHub.donHub.model.UserRequest;

public interface ProductRepositoryI extends MongoRepository<ProductRequest, Long>{
	ProductRequest findByEmailId(String emailId);
	ProductRequest findByCustomId(Long customId);
}