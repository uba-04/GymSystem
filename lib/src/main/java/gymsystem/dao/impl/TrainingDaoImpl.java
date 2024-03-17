package gymsystem.dao.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import gymsystem.dao.TrainingDao;
import gymsystem.models.Training;
import gymsystem.storage.Storage;

public class TrainingDaoImpl implements TrainingDao{

	@Autowired
	private Logger log;
	
	@Autowired
	private Storage storage;
	
	@Override
	public Training addTraining(Training training) {
		if(requiredFieldsAreFull(training)) {
			log.info("Creating Training...");
			
			storage.saveTraining(training);
			
			return training;
		} else {
			log.warn("Please fill in all the fields to add a new training.");
			
			return null;
		}
	}

	@Override
	public Training getTrainingById(Integer id) {
		if(id != null && storage.trainingExists(id)) {
			log.info("Fetching training profile...");
			
			return storage.getTrainingById(id);
		} else {
			log.warn("Training for the specified ID does not exist.");
			
			return null;
		}
	}

	@Override
	public Training updateTrainingById(Integer id, Training training) {
		if(id != null && requiredFieldsAreFull(training)) {
			
			log.info("Updating Training profile...");
			
			return storage.updateTrainingById(id, training);
		} else {
			log.warn("Please fill in all the fields to update a training profile.");
			
			return null;
		}
	}

	@Override
	public void deleteTrainingById(Integer id) {
		if(id != null) {
			log.info("Removing Training profile...");
			
			storage.deleteTrainingById(id);
		} else {
			log.warn("ID is null.");
		}
	}

	private boolean requiredFieldsAreFull(Training training) {
		
		return training.getId() != null &&
				!training.getTrainingName().isEmpty() &&
				training.getTrainingName() != null  &&
				training.getTrainingDate() != null &&
				training.getTrainingDuration() != null;
	}
}
