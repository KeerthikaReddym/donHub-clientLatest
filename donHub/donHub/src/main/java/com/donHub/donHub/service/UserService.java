
  package com.donHub.donHub.service;
  
  import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donHub.donHub.model.ProductRequest;
import com.donHub.donHub.model.User;
import com.donHub.donHub.repository.UserRepositoryI;
  
  @Service public class UserService implements UserServiceI {
  
  @Autowired
  private UserRepositoryI userRepository;

@Override
public List<User> getAllUsers() {
	
	return userRepository.findAll();
}

@Override
public User getUserById(Long id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public User createUser(User data) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public User updateUser(Long id, User data) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Boolean deleteUserById(Long id) {
	// TODO Auto-generated method stub
	return null;
}
   }