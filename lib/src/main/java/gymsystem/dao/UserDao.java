package gymsystem.dao;

import gymsystem.models.User;

public interface UserDao {

	public abstract User addUser(User user);
	
	public abstract User getUserById(Integer id);
	
	public abstract User updateUserById(Integer id, User user);
	
	public abstract void deleteUserById(Integer id);

	public abstract boolean requiredFieldsAreFull(User user);
}
