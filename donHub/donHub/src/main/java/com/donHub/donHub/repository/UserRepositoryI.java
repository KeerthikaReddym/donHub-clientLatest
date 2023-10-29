package com.donHub.donHub.repository;

import org.springframework.data.repository.CrudRepository;

import com.donHub.donHub.model.User;

public interface UserRepositoryI extends CrudRepository<User, Long>{

}
