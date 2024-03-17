package gymsystem.services;

import gymsystem.models.User;

public interface UserService {

	public User createUser(User user);
	
	public User getUserById(Integer id);
	
	public User updateUserById(Integer id, User user);
	
	public void removeUserById(Integer id);
}
