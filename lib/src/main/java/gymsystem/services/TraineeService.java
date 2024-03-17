package gymsystem.services;

import gymsystem.models.Trainee;
import gymsystem.models.User;

public interface TraineeService {
	
	public Trainee createTrainee(User user, Trainee trainee);
	
	public Trainee createTraineeFromAnExistingUser(Trainee trainee);
	
	public Trainee getTraineeById(Integer id);
	
	public Trainee updateTraineeById(Integer id, Trainee trainee);
	
	public void removeTraineeById(Integer id);
}
