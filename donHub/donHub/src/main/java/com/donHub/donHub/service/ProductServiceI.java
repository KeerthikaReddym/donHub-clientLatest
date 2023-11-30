package com.donHub.donHub.service;

import java.util.Optional;

import com.donHub.donHub.model.ProductRequest;

public interface ProductServiceI {

	public ProductRequest addProduct(ProductRequest productRequest);
	
	public ProductRequest getProducts();
	
	public ProductRequest deleteProduct(Integer id);
	public ProductRequest getProductByName(String id);

	

	//public ProductRequest updateProduct(ProductRequest productRequest);
	
	public Optional<ProductRequest> getProductById(Integer id);
	
}
