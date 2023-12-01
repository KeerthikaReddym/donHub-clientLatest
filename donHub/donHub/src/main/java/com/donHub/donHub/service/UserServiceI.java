
package com.donHub.donHub.service;

import java.util.List;

import com.donHub.donHub.model.UserRequest;

/**
	 * Interface defining methods to manage user operations.
	 */  
  public interface UserServiceI {
	  
	 public List<UserRequest> getAllUsers();
	 public UserRequest getUserById(Long id);
	 public UserRequest createUser(UserRequest data);
	 public UserRequest updateUser(Long id, UserRequest data);
	 public Boolean deleteUserById(Long id);
	 public Boolean deleteAll();
	   
	  
  }