package com.donHub.donHub.service;

import java.util.List;
import java.util.Optional;

import com.donHub.donHub.User;


public interface UserServiceI {
	List<User> getallUsers();
	Optional<User> getuserbyId(Integer id);
	User save(User user);
	User update(Integer id, User userupdate);
	void deleteallUsers();
	void deleteuserbyId(Integer id);
}
