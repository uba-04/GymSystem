package gymsystem.dao;

import gymsystem.models.Trainee;
import gymsystem.models.User;

public interface TraineeDao {

	public abstract Trainee addTrainee(User user, Trainee trainee);

	public abstract Trainee addTraineeFromAnExistingUser(Trainee trainee);
	
	public abstract Trainee getTraineeById(Integer id);
	
	public abstract Trainee updateTraineeById(Integer id, Trainee trainee);
	
	public abstract void deleteTraineeById(Integer id);
}