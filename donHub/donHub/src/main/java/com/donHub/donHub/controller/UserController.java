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


import com.donHub.donHub.User;
import com.donHub.donHub.service.UserServiceI;


@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
UserServiceI userservice;

@GetMapping()
public ResponseEntity<List<User>> getallusers(){
	return new ResponseEntity<>(userservice.getallUsers(), HttpStatus.OK);
}

@GetMapping("/getbyid/{id}")
public ResponseEntity<Optional<User>> getuserbyId(@PathVariable Integer id){
	return new ResponseEntity<>(userservice.getuserbyId(id), HttpStatus.OK);
}

@PostMapping()
public ResponseEntity<String> save(@RequestBody User user){
	User userdetail = userservice.save(user);
	if(userdetail!=null)
		return new ResponseEntity<String>("Successfully added the data", HttpStatus.OK);
	else
		return new ResponseEntity<String>("The record you are trying to add is already present", HttpStatus.BAD_REQUEST);
}

@PutMapping("/{id}")
public ResponseEntity<String> update(@PathVariable int id, @RequestBody User user){
	if(userservice.getuserbyId(id).isPresent())
		userservice.update(id, user);
	else
		return new ResponseEntity<String>("There is no data to update", HttpStatus.NO_CONTENT);
	return new ResponseEntity<String>("Successfully updated the data", HttpStatus.OK);
}

@DeleteMapping()
public ResponseEntity<String> deleteallusers(){
	if(!userservice.getallUsers().isEmpty())
		userservice.deleteallUsers();
	else
		return new ResponseEntity<String>("There is no data to delete", HttpStatus.NO_CONTENT);
	if(!userservice.getallUsers().isEmpty())
		return new ResponseEntity<String>("Unable to delete", HttpStatus.NO_CONTENT);
	return new ResponseEntity<String>("successfully deleted all records", HttpStatus.OK);
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteuserbyId(@PathVariable Integer id){
	if(userservice.getuserbyId(id).isPresent())
		userservice.deleteuserbyId(id);
	else
		return new ResponseEntity<String>("there is no data to delete", HttpStatus.NO_CONTENT);
	if(userservice.getuserbyId(id).isPresent())
		return new ResponseEntity<String>("Unable to delete", HttpStatus.NO_CONTENT);
	return new ResponseEntity<String>("successfully deleted the data", HttpStatus.OK);
	
}
}