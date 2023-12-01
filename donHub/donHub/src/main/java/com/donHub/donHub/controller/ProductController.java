package com.donHub.donHub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@PostMapping()
	public ResponseEntity<ProductRequest> addProduct(@RequestBody ProductRequest productRequest) {
		return new ResponseEntity<>(productServiceI.addProduct(productRequest), HttpStatus.OK);
	}
		
	 @GetMapping({"/{id}"})
	 public  ResponseEntity<ProductRequest> getProductByID(@PathVariable Long id) {
			return new ResponseEntity<>(productServiceI.getProductById(id), HttpStatus.OK);
	 }
	 
		/*
		 * @GetMapping({"/{name}"}) public ResponseEntity<Optional<ProductRequest>>
		 * getProductByName(String name) {
		 * 
		 * return new ResponseEntity<>(productServiceI.getProductByName(name),
		 * HttpStatus.OK); }
		 */
	 
		/*
		 * @GetMapping("/delete/{id}") public ResponseEntity<ProductRequest>
		 * deleteProductByID(Integer id) {
		 * 
		 * return new ResponseEntity<>(productServiceI.deleteProduct(id),
		 * HttpStatus.OK); }
		 */
	 
	 @GetMapping()
	 public ResponseEntity<List<ProductRequest>> getProducts() {
		  
		  return new ResponseEntity<>(productServiceI.getProducts(), HttpStatus.OK); }

}