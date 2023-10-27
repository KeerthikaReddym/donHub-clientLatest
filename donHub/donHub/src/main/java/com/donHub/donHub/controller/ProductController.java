package com.donHub.donHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	 * @return list of restaurant table
	 */
	@GetMapping
	public ResponseEntity<ProductResponse> addProduct(ProductRequest productRequest) {

		return  new ResponseEntity<>(productServiceI.addProduct(), HttpStatus.OK);
	}

}
