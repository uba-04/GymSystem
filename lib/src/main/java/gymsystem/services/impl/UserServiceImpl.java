package gymsystem.services.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import gymsystem.dao.UserDao;
import gymsystem.models.User;
import gymsystem.services.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private Logger log;
	
	@Override
	public User createUser(User user) {
		if(user != null) {
			log.info("Accessing storage system...");
			
			return userDao.addUser(user);
		} else {
			log.warn("Please fill in all the fields to add a new User.");
			
			return null;
		}
	}

	@Override
	public User getUserById(Integer id) {
		if(id != null) {
			log.info("Accessing storage system...");
			
			return userDao.getUserById(id);
		} else {
			log.warn("The ID is null.");
			
			return null;
		}
	}

	@Override
	public User updateUserById(Integer id, User user) {
		if(id != null && user != null) {
			log.info("Accessing storage system.");
			
			return userDao.updateUserById(id, user);
		} else {
			log.warn("Please fill in all the fields to update a User profile.");
			
			return null;
		}
	}

	@Override
	public void removeUserById(Integer id) {
		if(id != null) {
			log.info("Accessing storage system...");
			
			userDao.deleteUserById(id);
		} else {
			log.warn("The ID is null.");
		}
	}
}
