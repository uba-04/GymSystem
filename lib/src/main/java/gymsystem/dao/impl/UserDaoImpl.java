package gymsystem.dao.impl;

import java.util.Random;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import gymsystem.dao.UserDao;
import gymsystem.models.User;
import gymsystem.storage.Storage;

public class UserDaoImpl implements UserDao {
	
	@Autowired
	private Storage storage;

	@Autowired
	private Logger log;

	@Override
	public User addUser(User user) {

		if(requiredFieldsAreFull(user)){

			log.info("Generating username and password...");

			String username = generateUsername(user);
			String password = generateRandomPassword();
			
			user.setUsername(username);
			user.setPassword(password);
			
			return storage.saveUser(user);
		}
		else {
			log.warn("Please fill in all the fields to add a new user.");

			return null;
		}
	}

	@Override
	public User getUserById(Integer id) {
		
		if(id != null){

			return storage.getUserById(id);
		}
		else {
			log.warn("ID is null.");

			return null;
		}
	}

	@Override
	public User updateUserById(Integer id, User user) {

		if(id != null && requiredFieldsAreFull(user)){

			String username = generateUsername(user);
			String password = generateRandomPassword();
			
			user.setUsername(username);
			user.setPassword(password);
			
			return storage.updateUserById(id, user);
		}
		else {
			log.warn("Please fill in all the fields to update the user.");

			return null;
		}
	}

	@Override
	public void deleteUserById(Integer id) {
		
		if(id != null) {

			storage.deleteUserById(id);
		}
		else {
			log.warn("ID is null.");
		}
	}

	@Override
	public boolean requiredFieldsAreFull(User user){

		if(user.getId() == null || user.getFirstName().isEmpty() ||
			user.getLastName().isEmpty()){

			return false;
		} else {

			return true;
		}
	}
	
	private String generateRandomPassword() {
		
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int passwordLength = 10;
        StringBuilder password = new StringBuilder(passwordLength);
        Random random = new Random();

        for (int i = 0; i < passwordLength; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            password.append(randomChar);
        }

        return password.toString();
    }
	
	private String generateUsername(User user) {
		
		String firstName = user.getFirstName().toLowerCase();
		String lastName = user.getLastName().toLowerCase();
		String username = firstName.concat(".").concat(lastName);
		
		return username; 
	}
}