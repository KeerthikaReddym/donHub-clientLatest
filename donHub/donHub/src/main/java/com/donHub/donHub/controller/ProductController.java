package com.donHub.donHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donHub.donHub.model.Product;
import com.donHub.donHub.model.ProductRequest;
import com.donHub.donHub.model.ProductResponse;
import com.donHub.donHub.service.ProductServiceI;

@RestController
@RequestMapping("/donHub/Product")
public class ProductController {
	@Autowired
	ProductServiceI productServiceI;

	/**
	 * 
	 * @return Add data in  Product table
	 */
	@PostMapping
	public ResponseEntity<Product> addProduct(ProductRequest productRequest) {

		return  new ResponseEntity<>(productServiceI.addProduct(), HttpStatus.OK);
	}
	/**
	 * 

	 * @return get list of products
	 */
	@GetMapping
	public ResponseEntity<Product> GetProducts() {

		return  new ResponseEntity<>(productServiceI.addProduct(), HttpStatus.OK);
	}
	

	/**
	 * 
	 * @return list of restaurant table
	 */
	@GetMapping
	public ResponseEntity<Product> getProductByID(Integer id) {

		return  new ResponseEntity<>(productServiceI.addProduct(), HttpStatus.OK);
	}
	/**
	 * 
	 * @return list of restaurant table
	 */
	@DeleteMapping
	public ResponseEntity<Product> deleteProduct(Integer id) {

		return  new ResponseEntity<>(productServiceI.addProduct(), HttpStatus.OK);
	}
	/**
	 * 
	 * @return list of restaurant table
	 */
	@PutMapping
	public ResponseEntity<Product> updateProduct(ProductRequest productRequest) {

		return  new ResponseEntity<>(productServiceI.addProduct(), HttpStatus.OK);
	}
	

}