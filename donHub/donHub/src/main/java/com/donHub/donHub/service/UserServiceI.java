/*
 * package com.donHub.donHub.service;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import com.donHub.donHub.model.User;
 * 
 *//**
	 * Interface defining methods to manage user operations.
	 */
/*
 * 
 * public interface UserServiceI {
 *//**
	 * Retrieve all users.
	 *
	 * @return List of all users.
	 */
/*
 * List<User> getAllUsers();
 * 
 *//**
	 * Retrieve a user by their unique ID.
	 *
	 * @param userId The ID of the user to retrieve.
	 * @return Optional containing the user if found, otherwise empty.
	 */
/*
 * Optional<User> getUserById(Long userId);
 * 
 *//**
	 * Create a new user.
	 *
	 * @param user The user object to be created.
	 * @return Optional containing the created user object, or empty if
	 *         unsuccessful.
	 */
/*
 * Optional<User> createUser(User user);
 * 
 *//**
	 * Update a user's information.
	 *
	 * @param userId The ID of the user to update.
	 * @param user   The updated user object.
	 * @return Optional containing the updated user object, or empty if
	 *         unsuccessful.
	 */
/*
 * Optional<User> updateUser(Long userId, User user);
 * 
 *//**
	 * Delete all users.
	 *
	 * @return True if users were deleted, false otherwise.
	 */
/*
 * boolean deleteAllUsers();
 * 
 *//**
	 * Delete a user based on their ID.
	 *
	 * @param userId The ID of the user to delete.
	 * @return True if the user was deleted, false otherwise.
	 *//*
		 * boolean deleteUserById(Long userId); }
		 */