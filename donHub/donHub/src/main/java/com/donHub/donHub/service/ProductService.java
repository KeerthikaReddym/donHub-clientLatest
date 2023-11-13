package com.donHub.donHub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donHub.donHub.model.Product;
import com.donHub.donHub.model.ProductResponse;
import com.donHub.donHub.repository.ProductRepositoryI;

@Service
public class ProductService implements ProductServiceI{
	@Autowired
	private ProductRepositoryI productRepository;

	@Override
	public Product addProduct() {
		
		return productRepository.save(null);
	}

	@Override
	public Product getProduct() {
		productRepository.findAll();
		return null;
	}

	@Override
	public Product deleteProduct(Long id) {
		productRepository.delete(null);;
		return null;
	}

}