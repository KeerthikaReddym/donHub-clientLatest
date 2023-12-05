package com.donHub.donHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.donHub.donHub.common.CommonMethods;
import com.donHub.donHub.model.ProductRequest;
import com.donHub.donHub.model.UserRequest;
import com.donHub.donHub.repository.ProductRepositoryI;
import com.donHub.donHub.repository.UserRepositoryI;

@Configuration
@EnableCaching
@Service
public class ProductService implements ProductServiceI {

	@Autowired
	private ProductRepositoryI productRepository;
	

	@Autowired
	private UserRepositoryI userRepository;


	private final MongoTemplate mongoTemplate;
	 public ProductService(MongoTemplate mongoTemplate) {
	        this.mongoTemplate = mongoTemplate;
	    }
	

	/**
	 * Adds a new product to the database.
	 *
	 * @return The added product.
	 */
	@CacheEvict(value = "productsCache", allEntries = true)
	@Override
	public ProductRequest addProduct(ProductRequest productRequest) {
		// Implement the logic to add a new product
		UserRequest user = userRepository.findByEmailId(productRequest.getEmailId());
		productRequest.setUserRequest(user);
		
		CommonMethods commonMethods = new CommonMethods();
		productRequest.setCurrentDate();

		productRequest.setCustomId(commonMethods.generateUniqueNumber());
		return productRepository.save(productRequest);
	}

	/**
	 * Retrieves all products from the database.
	 *
	 * @return The list of all products.
	 */
	//@Cacheable(value = "productsCache")
	@Override
	public List<ProductRequest> getProducts() {
		
		// Implement the logic to return the list of products
		return productRepository.findAll();
	}

	

	/**
	 * Updates a product in the database.
	 *
	 * @return The updated product.
	 *//*
		 * @Override public ProductRequest updateProduct(ProductRequest productRequest)
		 * { // productRepository. return null; }
		 */

	/**
	 * Retrieves a product from the database based on its ID.
	 *
	 * @param id The ID of the product to retrieve.
	 * @return The retrieved product.
	 */
    @Cacheable(value = "productByIdCache", key = "#id")	
	@Override
	public ProductRequest getProductById(Long id) {
		return productRepository.findByCustomId(id);

	}

    @Cacheable(value = "productByNameCache", key = "#name")	
	@Override
	public ProductRequest getProductByName(String name) {
		return productRepository.findByName(name);
		
	}
    
    @Cacheable(value = "productByConditionCache", key = "#condition")
	@Override
	public ProductRequest getProductByCondition(String condition) {
		return productRepository.findByCondition(condition);
		
	}
    
   

    @Cacheable(value = "productByEmailCache", key = "#emailId")
	@Override
	public List<ProductRequest> getProductByEmail(String emailId) {
    	Query query = new Query(Criteria.where("emailId").is(emailId));
        List<ProductRequest> list = mongoTemplate.find(query, ProductRequest.class);
        return list;
		
	}
    
    @Cacheable(value = "productByCategoryCache", key = "#category")
	@Override
	public ProductRequest getProductByCategory(String category) {
		return productRepository.findByCategory(category);
		
	}
	
    @CacheEvict(value = "productsCache", allEntries = true)
	@Override
	public Boolean deleteAllProducts() {
		productRepository.deleteAll();
		if(productRepository.count()>0)
			return false;
		return true;
	}

    @CacheEvict(value = "productsCache", key = "#id")
	@Override
	public Boolean deleteById(Long id) {
		productRepository.deleteById(id);
		if(productRepository.existsById(id))
			return false;
		return true;
	}

	/*
	 * @Override public ProductRequest updateProduct(Long id, ProductRequest
	 * productRequest) { ProductRequest product
	 * =productRepository.findByCustomId(id);
	 * if(product.getCustomId().equals(id)&&product.getEmailId().equals(
	 * productRequest.getEmailId())) { productRepository.updateProduct(id,
	 * productRequest); } return null; }
	 */

	@CacheEvict(value = "productsCache", allEntries = true)
    @Override
	public Boolean updateProduct(Long id, ProductRequest productRequest) {
        Query query = new Query(Criteria.where("customId").is(id));
        Update update = new Update();
        update.set("name", productRequest.getName());
        ProductRequest product = productRepository.findByCustomId(id);

        update.set("price", productRequest.getPrice());
        if(product.getCustomId().equals(id)&&product.getEmailId().equals(productRequest.getEmailId())) {
            mongoTemplate.updateFirst(query, update, ProductRequest.class);
            return true;
		}
        return false;

	}

	@Cacheable(value = "productByPriceLowCache", key = "#price")
	@Override
	public List<ProductRequest> getProductByPriceLow(double price) {
        Query query = new Query(Criteria.where("price").lte(price));
        List<ProductRequest> list = mongoTemplate.find(query, ProductRequest.class);

		return list;
	}

	@Cacheable(value = "productByPriceHighCache", key = "#price")
	@Override
	public List<ProductRequest> getProductByPriceHigh(double price) {
		Query query = new Query(Criteria.where("price").gte(price));
        List<ProductRequest> list = mongoTemplate.find(query, ProductRequest.class);

		return list;
	}

	@Override
	public void updateProductWhenUserUpdated(UserRequest updatedUser) {
		List<ProductRequest> products = productRepository.findByEmailId(updatedUser.getEmailId());
	    for (ProductRequest product : products) {
	    	 Query query = new Query(Criteria.where("customId").is(product.getCustomId()));
	         Update update = new Update();
	         update.set("user", updatedUser);
	         mongoTemplate.updateFirst(query, update, ProductRequest.class);
	     }
	    }
		
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override public ProductRequest updateProduct(Long id, ProductRequest
	 * productRequest) { ProductRequest product
	 * =productRepository.findByCustomId(id);
	 * if(product.getCustomId().equals(id)&&product.getEmailId().equals(
	 * productRequest.getEmailId())) {
	 * 
	 * //return productRepository.update(id, productRequest); } return null; }
	 */

