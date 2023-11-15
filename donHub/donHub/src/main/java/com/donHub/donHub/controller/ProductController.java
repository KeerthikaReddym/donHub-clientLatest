package com.donHub.donHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donHub.donHub.model.ProductRequest;
import com.donHub.donHub.service.ProductServiceI;

@RestController
@RequestMapping("/donHub/product")
public class ProductController {
	
	@Autowired
	ProductServiceI productServiceI;

	/**
	 * 
	 * @return Add data in Product table
	 */
	@PostMapping
	public ResponseEntity<ProductRequest> addProduct(@RequestBody ProductRequest productRequest) {

		return new ResponseEntity<>(productServiceI.addProduct(productRequest), HttpStatus.OK);
	}
	
	/*
	 * @GetMapping public ResponseEntity<ProductRequest> updateProduct() {
	 * 
	 * return new ResponseEntity<>(productServiceI.updateProduct(), HttpStatus.OK);
	 * }
	 * 
	 * @GetMapping public ResponseEntity<ProductRequest> getProductByID(Integer id)
	 * {
	 * 
	 * return new ResponseEntity<>(productServiceI.getProductById(id),
	 * HttpStatus.OK); }
	 * 
	 * @GetMapping public ResponseEntity<ProductRequest> deleteProductByID(Integer
	 * id) {
	 * 
	 * return new ResponseEntity<>(productServiceI.deleteProduct(id),
	 * HttpStatus.OK); }
	 * 
	 * @GetMapping public ResponseEntity<ProductRequest> getProducts(Integer id) {
	 * 
	 * return new ResponseEntity<>(productServiceI.getProducts(), HttpStatus.OK); }
	 */

}