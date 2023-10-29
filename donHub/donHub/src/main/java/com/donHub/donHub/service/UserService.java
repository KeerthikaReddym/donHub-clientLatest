package com.donHub.donHub.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donHub.donHub.User;
import com.donHub.donHub.repository.UserRepositoryI;

@Service
public class UserService implements UserServiceI{
	@Autowired
	UserRepositoryI userrepository;
	
	@Override
	public List<User> getallUsers(){
		return (List<User>) userrepository.findAll();
	}
	
	@Override
	public Optional<User> getuserbyId(Integer id){
		return userrepository.findById(id);
	}
	
	@Override
	public User save(User user) {
		boolean check = checkDuplicates(user);
		if (!check)
			return (User) userrepository.save(user);
		else
			return null;
	}
	
	@Override
	public void deleteallUsers() {
		userrepository.deleteAll();
	}
	
	@Override
	public void deleteuserbyId(Integer id) {
		userrepository.deleteById(id);
	}
	
	@Override
	public User update(Integer id, User userupdate) {
		return userrepository.save(userupdate);
	}
	
	private boolean checkDuplicates(User user) {
		List<User> users = (List<User>) userrepository.findAll();
		for (User userdetail : users) {
			if (user.getName().equals(users.getName())) {
				return true;
			}
		}
		return false;
	}
}
