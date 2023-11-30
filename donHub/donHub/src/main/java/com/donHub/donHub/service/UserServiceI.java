
package com.donHub.donHub.service;

import java.util.List;
import java.util.Optional;

import com.donHub.donHub.model.User;
import com.donHub.donHub.model.UserRequest;

/**
	 * Interface defining methods to manage user operations.
	 */  
  public interface UserServiceI {
	  
	 public List<UserRequest> getAllUsers();
	 public Optional<UserRequest> getUserById(Long id);
	 public UserRequest createUser(UserRequest data);
	 public UserRequest updateUser(Long id, User data);
	 public Boolean deleteUserById(Long id);
	   
	  
  }