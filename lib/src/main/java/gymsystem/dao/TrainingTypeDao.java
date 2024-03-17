package gymsystem.dao;

import gymsystem.models.TrainingType;

public interface TrainingTypeDao {

	public abstract TrainingType addTrainingType(TrainingType trainingType);
	
	public abstract TrainingType getTrainingTypeById(Integer id);
	
	public abstract TrainingType updateTrainingTypeById(Integer id, TrainingType trainingType);
	
	public abstract void deleteTrainingTypeById(Integer id);
}