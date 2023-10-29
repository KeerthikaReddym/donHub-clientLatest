package com.donHub.donHub.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donHub.donHub.model.User;
import com.donHub.donHub.repository.UserRepositoryI;

@Service
public class UserService {
	@Autowired
	private UserRepositoryI userRepository;
	
	public List<User> getAllUsers(){
		List<User> users = (List<User>) userRepository.findAll();
		return (users.isEmpty()) ? null : users;
	}
	
	public User getUserById(Long userId){
		return userRepository.findById(userId).orElse(null);
	}
	
	public User createUser(User user) {
	
		return userRepository.save(user);
	}
	
	
	
	public boolean deleteAllPlayers() {
		boolean areDeleted = false;
		if (!((List<User>) userRepository.findAll()).isEmpty()) {
			userRepository.deleteAll();
			areDeleted = true;
		}
		return areDeleted;
	}
	
	public boolean deletePlayerById(Long userId) {
		boolean isDeleted = false;
		User user = userRepository.findById(userId).orElse(null);
		if (user != null) {
			userRepository.delete(user);
			isDeleted = true;
		}
		return isDeleted;

	}
	
	public User updateUser(Long userId, User user) {
		return userRepository.save(user);
	}
}
