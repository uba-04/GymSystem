package gymsystem.services;

import gymsystem.models.Training;

public interface TrainingService {

	public Training createTraining(Training training);
	
	public Training getTrainingById(Integer id);
	
	public Training updateTrainingById(Integer id, Training training);
	
	public void removeTrainingById(Integer id);
}
