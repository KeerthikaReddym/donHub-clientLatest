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

	/**
	 * Retrieves all users from the database.
	 *
	 * @return List of all users, or null if the list is empty.
	 */

	public List<User> getAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return (users.isEmpty()) ? null : users;
	}

	/**
	 * Retrieves a user by their unique ID.
	 *
	 * @param userId The ID of the user to retrieve.
	 * @return The user if found, otherwise null.
	 */

	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	/**
	 * Creates a new user in the database.
	 *
	 * @param user The user object to be created.
	 * @return The created user object.
	 */

	public User createUser(User user) {

		return userRepository.save(user);
	}

	/**
	 * Deletes all users from the database.
	 *
	 * @return True if users were deleted, false otherwise.
	 */

	public boolean deleteAllUsers() {
		boolean areDeleted = false;
		if (!((List<User>) userRepository.findAll()).isEmpty()) {
			userRepository.deleteAll();
			areDeleted = true;
		}
		return areDeleted;
	}

	/**
	 * Deletes a user from the database based on their ID.
	 *
	 * @param userId The ID of the user to delete.
	 * @return True if the user was deleted, false otherwise.
	 */

	public boolean deleteUserById(Long userId) {
		boolean isDeleted = false;
		User user = userRepository.findById(userId).orElse(null);
		if (user != null) {
			userRepository.delete(user);
			isDeleted = true;
		}
		return isDeleted;

	}

	/**
	 * Updates a user's information in the database.
	 *
	 * @param userId The ID of the user to update.
	 * @param user   The updated user object.
	 * @return The updated user object.
	 */

	public User updateUser(Long userId, User user) {
		return userRepository.save(user);
	}
}
