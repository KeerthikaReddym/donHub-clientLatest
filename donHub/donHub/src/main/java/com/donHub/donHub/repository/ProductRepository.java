package com.donHub.donHub.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.donHub.donHub.model.ProductRequest;
import com.donHub.donHub.model.UserRequest;

@Repository
public class ProductRepository implements ProductRepositoryI {

    private final MongoTemplate mongoTemplate;

    
    public ProductRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

	@Override
	public <S extends ProductRequest> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductRequest> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductRequest> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductRequest> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductRequest> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductRequest> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public <S extends ProductRequest> S save(S entity) {
		//get the seller name, email id from seller table and save that in product
		
        return mongoTemplate.insert(entity);
	}

	

	
	@Override
	public void deleteAll(Iterable<? extends ProductRequest> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductRequest> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ProductRequest> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductRequest> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		
		return Optional.empty();
	}

	@Override
	public <S extends ProductRequest> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductRequest> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends ProductRequest> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends ProductRequest, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public ProductRequest findByCustomId(Long customId) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public List<ProductRequest> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ProductRequest> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ProductRequest entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductRequest findByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
