package gymsystem.dao;

import gymsystem.models.Training;

public interface TrainingDao {

	public abstract Training addTraining(Training training);
	
	public abstract Training getTrainingById(Integer id);
	
	public abstract Training updateTrainingById(Integer id, Training training);
	
	public abstract void deleteTrainingById(Integer id);
}