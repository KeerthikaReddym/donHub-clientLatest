package com.donHub.donHub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

@GetMapping("/getAllUsers")
public ResponseEntity<Object> getAllPlayers() {
	List<User> users = userService.getAllUsers();
	return users != null ? ResponseEntity.status(HttpStatus.FOUND).body(users)
			: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found!");
}


@GetMapping("/getUserById/{userId}")
public ResponseEntity<Object> getPlayerById(@PathVariable Long userId) {
	Optional<User> user = userService.getUserById(userId);
	return user != null ? ResponseEntity.status(HttpStatus.FOUND).body(user)
			: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found!");

}

@PutMapping("/updateUser/{userId}")
public ResponseEntity<Object> updatePlayer(@PathVariable Long userId, @RequestBody User updateUser) {
	Optional<User> updatedUser = userService.updateUser(userId, updateUser);
	return updatedUser != null ? ResponseEntity.status(HttpStatus.OK).body(updatedUser)
			: ResponseEntity.status(HttpStatus.NOT_FOUND).body("No player found to update!");
}

@DeleteMapping("/deleteAllUsers")
public ResponseEntity<Object> deleteAllUsers() {
	Boolean areDeleted = userService.deleteAllUsers();
	return areDeleted ? ResponseEntity.status(HttpStatus.OK).body("All users deleted successfully!")
			: ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No users found to delete!");
}

@DeleteMapping({ "/deleteUserById/{userId}" })
public ResponseEntity<Object> deleteUserById(@PathVariable Long userId) {
	Boolean isDeleted = userService.deleteUserById(userId);
	return isDeleted ? ResponseEntity.status(HttpStatus.OK).body("User deleted successfully!")
			: ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No user found to delete!");
}

}