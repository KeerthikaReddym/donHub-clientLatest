package com.donHub.donHub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donHub.donHub.model.User;
import com.donHub.donHub.service.UserServiceI;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServiceI userService;

	/**
	 * Retrieves all users from the database.
	 *
	 * @return ResponseEntity<Object> containing a list of users if found, otherwise
	 *         a message indicating no users found
	 */
	@GetMapping("/getAllUsers")
	public ResponseEntity<Object> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return users != null ? ResponseEntity.status(HttpStatus.FOUND).body(users)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found!");
	}

	/**
	 * Retrieves a user by their ID.
	 *
	 * @param userId ID of the user to retrieve
	 * @return ResponseEntity<Object> containing the user if found, otherwise a
	 *         message indicating no user found
	 */
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<Object> getUserById(@PathVariable Long userId) {
		Optional<User> user = userService.getUserById(userId);
		return user != null ? ResponseEntity.status(HttpStatus.FOUND).body(user)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found!");

	}

	/**
	 * Adds user data to the database.
	 *
	 * @param data User object containing data to be added
	 * @return ResponseEntity<Object> containing the created user if successful,
	 *         otherwise a message indicating no user found
	 */
	@PostMapping()
	public ResponseEntity<Object> addUser(@RequestBody User data) {
		Optional<User> user = userService.createUser(data);
		return user != null ? ResponseEntity.status(HttpStatus.FOUND).body(user)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found!");

	}

	/**
	 * Updates user information by their ID.
	 *
	 * @param userId     ID of the user to update
	 * @param updateUser User object containing updated information
	 * @return ResponseEntity<Object> containing the updated user if successful,
	 *         otherwise a message indicating no user found to update
	 */
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<Object> updateUser(@PathVariable Long userId, @RequestBody User updateUser) {
		Optional<User> updatedUser = userService.updateUser(userId, updateUser);
		return updatedUser != null ? ResponseEntity.status(HttpStatus.OK).body(updatedUser)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No player found to update!");
	}

	/**
	 * Deletes all users from the database.
	 *
	 * @return ResponseEntity<Object> with a success message if users are deleted
	 *         successfully, otherwise a message indicating no users found for
	 *         deletion
	 */
	@DeleteMapping("/deleteAllUsers")
	public ResponseEntity<Object> deleteAllUsers() {
		Boolean areDeleted = userService.deleteAllUsers();
		return areDeleted ? ResponseEntity.status(HttpStatus.OK).body("All users deleted successfully!")
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No users found to delete!");
	}

	/**
	 * Deletes a user by their ID.
	 *
	 * @param userId ID of the user to delete
	 * @return ResponseEntity<Object> with a success message if the user is deleted
	 *         successfully, otherwise a message indicating no user found for
	 *         deletion
	 */
	@DeleteMapping({ "/deleteUserById/{userId}" })
	public ResponseEntity<Object> deleteUserById(@PathVariable Long userId) {
		Boolean isDeleted = userService.deleteUserById(userId);
		return isDeleted ? ResponseEntity.status(HttpStatus.OK).body("User deleted successfully!")
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No user found to delete!");
	}

}