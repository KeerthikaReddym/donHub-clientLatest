
  package com.donHub.donHub.service;

import java.util.List;

import com.donHub.donHub.model.User;

/**
	 * Interface defining methods to manage user operations.
	 */  
  public interface UserServiceI {
	  
	 public List<User> getAllUsers();
	 public User getUserById(Long id);
	 public User createUser(User data);
	 public User updateUser(Long id, User data);
	 public Boolean deleteUserById(Long id);
	   
	  
  }