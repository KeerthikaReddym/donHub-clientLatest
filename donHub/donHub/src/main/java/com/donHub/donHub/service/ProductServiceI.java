package com.donHub.donHub.service;

import java.util.List;
import java.util.Optional;

import com.donHub.donHub.model.ProductRequest;

public interface ProductServiceI {

	public ProductRequest addProduct(ProductRequest productRequest);
	
	public List<ProductRequest> getProducts();
	public Boolean updateProduct(Long id, ProductRequest productRequest);
	
	public Boolean deleteAllProducts();
	public Boolean deleteById(Long id);
	public ProductRequest getProductByName(String id);
	public ProductRequest getProductByCondition(String condition);
	public ProductRequest getProductByPrice(double price);
	public ProductRequest getProductByEmail(String email);
	public ProductRequest getProductByCategory(String category);
	

	

	//public ProductRequest updateProduct(ProductRequest productRequest);
	
	public ProductRequest getProductById(Long id);
	
}
