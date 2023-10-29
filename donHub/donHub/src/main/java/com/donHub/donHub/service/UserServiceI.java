package com.donHub.donHub.service;

import java.util.List;
import java.util.Optional;

import com.donHub.donHub.model.User;


public interface UserServiceI {
	List<User> getAllUsers();
	Optional<User> getUserById(Long userId);
	
	Optional<User> createUser(User user);
	
	Optional<User> updateUser(Long userId, User user);
	
	boolean deleteAllUsers();
	boolean deleteUserById(Long userId);
}
