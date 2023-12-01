
package com.donHub.donHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donHub.donHub.common.CommonMethods;
import com.donHub.donHub.model.UserRequest;
import com.donHub.donHub.model.ValidUser;
import com.donHub.donHub.repository.UserRepositoryI;
import com.donHub.donHub.repository.ValidUserRepositoryI;

@Service
public class UserService implements UserServiceI {

	@Autowired
	private UserRepositoryI userRepository;
	
	@Autowired
	private ValidUserRepositoryI validUserRepositoryI;

	@Override
	public List<UserRequest> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public UserRequest getUserById(Long id) {
		


		//ObjectId objectId = new ObjectId(id);
		UserRequest user = userRepository.findByCustomId(id);
		return  user;
		
	}

	@Override
	public UserRequest createUser(UserRequest data) {
		//check weather a user is authorized
		UserRequest DummyuserRequest = new UserRequest();
		CommonMethods commonMethods = new CommonMethods();
		data.setCustomId(commonMethods.generateUniqueNumber());
		ValidUser valid = new ValidUser();
		valid = validUserRepositoryI.findByEmail(data.getEmailId());

		if(valid!=null&&valid.getName()!=null)
		{
			
			  if(userRepository.findByEmailId(data.getEmailId())!=null) {
				  DummyuserRequest.setEmailId(data.getEmailId());
				  return DummyuserRequest; }
			 
		return userRepository.save(data);
		}
		
		return  DummyuserRequest;

	}

	@Override
	public UserRequest getUserByEmailId(String EmailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRequest updateUser(Long id, UserRequest data) {
		UserRequest user = userRepository.findByCustomId(id);
		if(id.equals(data.getCustomId()))
		return userRepository.save(data);
		else
		return	null;	
		
	}
	@Override
	public Boolean deleteUserById(Long id) {
	userRepository.deleteById(id);
	if(userRepository.existsById(id))
		return false;
	else 
		return true;
		
	}

	@Override
	public Boolean deleteAll() {
		userRepository.deleteAll();
		if(userRepository.count()==0)
		return false;
		else
			return true;
	}


	
	/*
	 * @Override public Boolean deleteUserById(Long id) {
	 * userRepository.deleteById((long) id.intValue()); if(getUserById(id)==null)
	 * return true; else return false; }
	 */
}