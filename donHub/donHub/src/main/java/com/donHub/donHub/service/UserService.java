
package com.donHub.donHub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donHub.donHub.model.UserRequest;
import com.donHub.donHub.repository.UserRepositoryI;

@Service
public class UserService implements UserServiceI {

	@Autowired
	private UserRepositoryI userRepository;

	@Override
	public List<UserRequest> getAllUsers() {

		return userRepository.findAll();
	}
//
//	@Override
//	public UserRequest getUserById(Long id) {
//		return userRepository.findById(id);
//	}

	@Override
	public UserRequest createUser(UserRequest data) {
		return userRepository.save(data);

	}

	@Override
	public UserRequest updateUser(Long id, UserRequest data) {
		// TODO Auto-generated method stub
		return null;
	}

@Override
public Boolean deleteUserById(Long id) {
	 userRepository.deleteById((long) id.intValue());
	 if(getUserById(id)==null)
	return true;
	 else
		 return false;
}

@Override
public UserRequest getUserByEmailId(String EmailId) {
	// TODO Auto-generated method stub
	return userRepository.findByEmailId(EmailId);
}
@Override
public UserRequest getUserById(Long id) {
	return userRepository.findByCustomId(id);
}
}