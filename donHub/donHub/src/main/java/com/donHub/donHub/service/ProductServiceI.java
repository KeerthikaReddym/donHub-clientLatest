package com.donHub.donHub.service;

import java.util.List;
import java.util.Optional;

import com.donHub.donHub.model.ProductRequest;
import com.donHub.donHub.model.UserRequest;

public interface ProductServiceI {

	public ProductRequest addProduct(ProductRequest productRequest);
	
	public List<ProductRequest> getProducts();
	public Boolean updateProduct(Long id, ProductRequest productRequest);
	
	public Boolean deleteAllProducts();
	public Boolean deleteById(Long id);
	public ProductRequest getProductByName(String id);
	public ProductRequest getProductByCondition(String condition);
	public List<ProductRequest> getProductByPriceLow(double price);
	public List<ProductRequest> getProductByPriceHigh(double price);
	public List<ProductRequest> getProductByEmail(String email);
	public ProductRequest getProductByCategory(String category);
	

	

	//public ProductRequest updateProduct(ProductRequest productRequest);
	
	public ProductRequest getProductById(Long id);

	void updateProductWhenUserUpdated(UserRequest updatedUser);
	
}
