package gymsystem.dao;

import gymsystem.models.Trainer;
import gymsystem.models.User;

public interface TrainerDao {

	public abstract Trainer addTrainer(User user, Trainer trainer);
	
	public abstract Trainer addTrainerFromAnExistingUser(Trainer trainer);
	
	public abstract Trainer getTrainerById(Integer id);
	
	public abstract Trainer updateTrainerById(Integer id, Trainer trainer);
	
	public abstract void deleteTrainerById(Integer id);
}
