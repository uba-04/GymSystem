package gymsystem.services;

import gymsystem.models.Trainer;
import gymsystem.models.User;

public interface TrainerService {

	public Trainer createTrainer(User user, Trainer trainer);
	
	public Trainer createTrainerFromAnExistingUser(Trainer trainer);
	
	public Trainer getTrainerById(Integer id);
	
	public Trainer updateTrainerById(Integer id, Trainer trainer);
	
	public void removeTrainerById(Integer id);
}
