package com.donHub.donHub.repository;

import org.springframework.data.repository.CrudRepository;

import com.donHub.donHub.model.Product;

public interface ProductRepositoryI extends CrudRepository<Product, Long>{
