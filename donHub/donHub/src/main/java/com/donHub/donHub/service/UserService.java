
package com.donHub.donHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

	
	


	private final MongoTemplate mongoTemplate;

	@Cacheable(value = "allUsersCache")
	@Override
	public List<UserRequest> getAllUsers() {

		return userRepository.findAll();
	}

	
	public UserService(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Cacheable(value = "userByIdCache", key = "#id")
	@Override
	public UserRequest getUserById(Long id) {
		// ObjectId objectId = new ObjectId(id);
		UserRequest user = userRepository.findByCustomId(id);
		return user;

	}

	@CacheEvict(value = "allUsersCache", allEntries = true)
	@Override
	public UserRequest createUser(UserRequest data) {
		// check weather a user is authorized
		// UserRequest DummyuserRequest = new UserRequest();
		CommonMethods commonMethods = new CommonMethods();
		data.setCustomId(commonMethods.generateUniqueNumber());
		data.setCurrentDate();
		ValidUser valid = new ValidUser();
		valid = validUserRepositoryI.findByEmail(data.getEmailId());

		if (valid != null && valid.getName() != null) {

			if (userRepository.findByEmailId(data.getEmailId()) != null) {
				UserRequest dummyUserRequest = new UserRequest();
				dummyUserRequest.setEmailId(data.getEmailId());
				return dummyUserRequest;
			} else {
				data.setName(valid.getName());
				return userRepository.save(data);
			}

		} else {
			return new UserRequest();
		}
	}

	@Override
	public UserRequest validateUser(String EmailId, String password) {
		UserRequest user = userRepository.findByEmailId(EmailId);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	
	@Override
	public UserRequest getUserByEmailId(String EmailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@CacheEvict(value = "allUsersCache", allEntries = true)
	@Override
	public Boolean updateUser(Long id, UserRequest data) {
		Query query = new Query(Criteria.where("customId").is(id));
		Update update = new Update();
		update.set("name", data.getName());
		if(data.getProfilePic()!=null)
			update.set("data", data.getProfilePic());
		
		UserRequest user = userRepository.findByCustomId(id);

		// update.set("price", data.);
		if (id.equals(user.getCustomId())) {
			mongoTemplate.updateFirst(query, update, UserRequest.class);
			return true;
		}

		return false;

	}

	@CacheEvict(value = {"userByIdCache", "allUsersCache"}, key = "#id")
	@Override
	public Boolean deleteUserById(Long id) {
		userRepository.deleteById(id);
		if (userRepository.existsById(id))
			return false;
		else
			return true;

	}

	@CacheEvict(value = "allUsersCache", allEntries = true)
	@Override
	public Boolean deleteAll() {
		userRepository.deleteAll();
		if (userRepository.count() == 0)
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