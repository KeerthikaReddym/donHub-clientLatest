package com.donHub.donHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donHub.donHub.common.CommonMethods;
import com.donHub.donHub.model.ProductRequest;
import com.donHub.donHub.repository.ProductRepositoryI;

@Service
public class ProductService implements ProductServiceI {

	@Autowired
	private ProductRepositoryI productRepository;

	/**
	 * Adds a new product to the database.
	 *
	 * @return The added product.
	 */
	@Override
	public ProductRequest addProduct(ProductRequest productRequest) {
		// Implement the logic to add a new product
		CommonMethods commonMethods = new CommonMethods();
		productRequest.setCustomId(commonMethods.generateUniqueNumber());
		return productRepository.save(productRequest);
	}

	/**
	 * Retrieves all products from the database.
	 *
	 * @return The list of all products.
	 */
	@Override
	public List<ProductRequest> getProducts() {
		
		// Implement the logic to return the list of products
		return productRepository.findAll();
	}

	

	/**
	 * Updates a product in the database.
	 *
	 * @return The updated product.
	 *//*
		 * @Override public ProductRequest updateProduct(ProductRequest productRequest)
		 * { // productRepository. return null; }
		 */

	/**
	 * Retrieves a product from the database based on its ID.
	 *
	 * @param id The ID of the product to retrieve.
	 * @return The retrieved product.
	 */
	@Override
	public ProductRequest getProductById(Long id) {
		return productRepository.findByCustomId(id);

	}

	@Override
	public ProductRequest getProductByName(String name) {
		return productRepository.findByName(name);
		
	}
	@Override
	public ProductRequest getProductByCondition(String condition) {
		return productRepository.findByCondition(condition);
		
	}
	@Override
	public ProductRequest getProductByPrice(double price) {
		return productRepository.findByPrice(price);
		
	}

	@Override
	public ProductRequest getProductByEmail(String emailId) {
		return productRepository.findByEmailId(emailId);
		
	}
	@Override
	public ProductRequest getProductByCategory(String category) {
		return productRepository.findByCategory(category);
		
	}
	

	@Override
	public Boolean deleteAllProducts() {
		productRepository.deleteAll();
		if(productRepository.count()>0)
			return false;
		return true;
	}

	@Override
	public Boolean deleteById(Long id) {
		productRepository.deleteById(id);
		if(productRepository.existsById(id))
			return false;
		return true;
	}
}
