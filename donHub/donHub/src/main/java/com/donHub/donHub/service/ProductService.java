package com.donHub.donHub.service;

import java.util.Date;
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
		// Get the current time in UTC
		Date currentDate = new Date();
		CommonMethods commonMethods = new CommonMethods();
		productRequest.setCustomId(commonMethods.generateUniqueNumber());
		// Set the date in the ProductRequest object
		productRequest.setDate(currentDate);
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
	 * Deletes a product from the database based on its ID.
	 *
	 * @param id The ID of the product to delete.
	 * @return The deleted product.
	 */
	/*
	 * @Override public ProductRequest deleteProduct(Long id) {
	 * 
	 * // Implement the logic to delete the product productRepository.delete(id); }
	 */

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
		return null;
		
	}

	@Override
	public ProductRequest deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
