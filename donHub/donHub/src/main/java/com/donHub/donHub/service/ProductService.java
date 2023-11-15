package com.donHub.donHub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donHub.donHub.model.ProductRequest;
import com.donHub.donHub.repository.ProductRepository;

@Service
public class ProductService implements ProductServiceI {
	
	@Autowired
    private ProductRepository productRepository;


    /**
     * Adds a new product to the database.
     *
     * @return The added product.
     */
    @Override
    public ProductRequest addProduct(ProductRequest productRequest) {
        // Implement the logic to add a new product
           return productRepository.save(productRequest);
    }

    /**
     * Retrieves all products from the database.
     *
     * @return The list of all products.
     */
    @Override
    public ProductRequest getProducts() {
        productRepository.findAll();
        // Implement the logic to return the list of products
        return null;
    }

    /**
     * Deletes a product from the database based on its ID.
     *
     * @param id The ID of the product to delete.
     * @return The deleted product.
     */
    @Override
    public ProductRequest deleteProduct(Integer id) {
        productRepository.delete(null);
        // Implement the logic to delete the product
        return null;
    }

    /**
     * Updates a product in the database.
     *
     * @return The updated product.
     */
    @Override
    public ProductRequest updateProduct() {
        // Implement the logic to update a product
        return null;
    }

    /**
     * Retrieves a product from the database based on its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The retrieved product.
     */
    @Override
    public ProductRequest getProductById(Integer id) {
        productRepository.findById(id);
        // Implement the logic to retrieve a product by ID
        return null;
    }
}
