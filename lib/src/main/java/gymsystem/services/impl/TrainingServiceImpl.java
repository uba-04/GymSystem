package gymsystem.services.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import gymsystem.dao.TrainingDao;
import gymsystem.models.Training;
import gymsystem.services.TrainingService;

public class TrainingServiceImpl implements TrainingService {
	
	@Autowired
	private Logger log;
	
	@Autowired
	private TrainingDao trainingDao;

	@Override
	public Training createTraining(Training training) {
		if(training != null) {
			log.info("Accessing storage system...");
			
			return trainingDao.addTraining(training);
		} else {
			log.warn("Please fill in all the fields to add a new Training.");
			
			return null;
		}
	}

	@Override
	public Training getTrainingById(Integer id) {
		if(id != null) {
			log.info("Accessing storage system...");
			
			return trainingDao.getTrainingById(id);
		} else {
			log.warn("The ID is null.");
			
			return null;
		}
	}

	@Override
	public Training updateTrainingById(Integer id, Training training) {
		if(id != null && training != null) {
			log.info("Accessing storage system.");
			
			return trainingDao.updateTrainingById(id, training);
		} else {
			log.warn("Please fill in all the fields to update a Training profile.");
			
			return null;
		}
	}

	@Override
	public void removeTrainingById(Integer id) {
		if(id != null) {
			log.info("Accessing storage system...");
			
			trainingDao.deleteTrainingById(id);
		} else {
			log.warn("The ID is null.");
		}
	}
}
