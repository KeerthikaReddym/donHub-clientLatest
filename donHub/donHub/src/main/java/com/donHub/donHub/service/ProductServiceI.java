package com.donHub.donHub.service;

import com.donHub.donHub.model.ProductRequest;

public interface ProductServiceI {

	public ProductRequest addProduct(ProductRequest productRequest);
	
	public ProductRequest getProducts();
	
	public ProductRequest deleteProduct(Integer id);


	public ProductRequest updateProduct();
	
	public ProductRequest getProductById(Integer id);
	
}
