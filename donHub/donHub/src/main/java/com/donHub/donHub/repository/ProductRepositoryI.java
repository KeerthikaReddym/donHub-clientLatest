package com.donHub.donHub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.donHub.donHub.model.ProductRequest;

public interface ProductRepositoryI extends MongoRepository<ProductRequest, Integer>{
}