package com.donHub.donHub.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.donHub.donHub.model.Condition;
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
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ProductRequest> addProduct(@RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("price") Double price,
			@RequestParam("category") String category, @RequestParam("condition") String condition,
			@RequestParam("emailId") String emailId, @RequestParam("date") String dateString,
			@RequestParam("images") MultipartFile[] images) {

		ProductRequest productRequest = new ProductRequest();
		productRequest.setName(name);
		productRequest.setDescription(description);
		productRequest.setPrice(price);
		productRequest.setCategory(category);
		productRequest.setCondition(convertStringToCondition(condition)); // Assuming Condition is an enum
		productRequest.setEmailId(emailId);
		
		List<byte[]> productImages = new ArrayList<>();
        for (MultipartFile file : images) {
            try {
                productImages.add(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                // Handle IOException, maybe return a bad request response
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        productRequest.setImage(productImages);
		
		try {
			Date date = dateFormat.parse(dateString);
			productRequest.setDate(date);
		}catch (ParseException e) {
            // Handle parse exception, maybe return a bad request response
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(productServiceI.addProduct(productRequest), HttpStatus.OK);
	}
	
	private Condition convertStringToCondition(String conditionStr) {
	    String formattedCondition = conditionStr.replace(" ", "_").toUpperCase();
	    try {
	        return Condition.valueOf(formattedCondition);
	    } catch (IllegalArgumentException e) {
	        // Handle the case where the formatted string does not match any enum constant
	        throw new IllegalArgumentException("Invalid condition value: " + conditionStr);
	    }
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