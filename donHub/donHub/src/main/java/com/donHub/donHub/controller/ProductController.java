package com.donHub.donHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	@PostMapping
	public ResponseEntity<ProductRequest> addProduct(@RequestBody ProductRequest productRequest) {

		return new ResponseEntity<>(productServiceI.addProduct(productRequest), HttpStatus.OK);
	}
	/*
	 * @GetMapping public ResponseEntity<ProductRequest> updateProduct(@RequestBody
	 * ProductRequest productRequest) {
	 * 
	 * return new ResponseEntity<>(productServiceI.updateProduct(productRequest),
	 * HttpStatus.OK); }
	 */

	@GetMapping("/pro/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id) {
		ProductRequest product = productServiceI.getProductById(id);
		return product != null ? ResponseEntity.status(HttpStatus.OK).body(product)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Product found!");

	}

	@GetMapping()
	public ResponseEntity<List<ProductRequest>> getProducts() {

		return new ResponseEntity<>(productServiceI.getProducts(), HttpStatus.OK);
	}

	@GetMapping({ "getByName/{name}" })
	public ResponseEntity<?> getProductByName(@PathVariable String name) {
		ProductRequest product = productServiceI.getProductByName(name);

		return product != null ? ResponseEntity.status(HttpStatus.OK).body(product)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Product found!");
	}
	@GetMapping({ "getByCondition/{condition}" })
	public ResponseEntity<?> getProductByCondition(@PathVariable String condition) {
		ProductRequest product = productServiceI.getProductByCondition(condition);

		return product != null ? ResponseEntity.status(HttpStatus.OK).body(product)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Product found!");
	}
	@GetMapping({ "getByPrice/{price}" })
	public ResponseEntity<?> getProductByPrice(@PathVariable double price) {
		ProductRequest product = productServiceI.getProductByPrice(price);

		return product != null ? ResponseEntity.status(HttpStatus.OK).body(product)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Product found!");
	}
	@GetMapping({ "getByEmail/{emailId}" })
	public ResponseEntity<?> getProductByEmail(@PathVariable String emailId) {
		ProductRequest product = productServiceI.getProductByEmail(emailId);

		return product != null ? ResponseEntity.status(HttpStatus.OK).body(product)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Product found!");
	}
	@GetMapping({ "getByCategory/{category}" })
	public ResponseEntity<?> getProductByCategory(@PathVariable String category) {
		ProductRequest product = productServiceI.getProductByCategory(category);

		return product != null ? ResponseEntity.status(HttpStatus.OK).body(product)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Product found!");
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll() {
		return productServiceI.deleteAllProducts() == true
				? ResponseEntity.status(HttpStatus.OK).body("successfully deleted everything")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Product found!");
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		return productServiceI.deleteById(id) == true
				? ResponseEntity.status(HttpStatus.OK).body("successfully deleted record")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Product found!");
	}

}