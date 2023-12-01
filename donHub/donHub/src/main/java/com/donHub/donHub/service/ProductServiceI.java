package com.donHub.donHub.service;

import java.util.List;
import java.util.Optional;

import com.donHub.donHub.model.ProductRequest;

public interface ProductServiceI {

	public ProductRequest addProduct(ProductRequest productRequest);

	public List<ProductRequest> getProducts();

	public ProductRequest deleteProduct(Long id);

	public ProductRequest getProductByName(String id);

	public ProductRequest getProductById(Long id);

}
