package com.donHub.donHub.service;

import com.donHub.donHub.model.Product;

public interface ProductServiceI {

	public Product addProduct();
	
	public Product getProduct();
	
	public Product deleteProduct(Long id);

}