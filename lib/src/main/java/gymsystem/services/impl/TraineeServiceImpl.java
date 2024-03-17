package gymsystem.services.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import gymsystem.dao.TraineeDao;
import gymsystem.models.Trainee;
import gymsystem.models.User;
import gymsystem.services.TraineeService;

//@Service
public class TraineeServiceImpl implements TraineeService{

	@Autowired
	private TraineeDao traineeDao;
	
	@Autowired
	private Logger log;
	
	@Override
	public Trainee createTrainee(User user, Trainee trainee) {
		
		if(user != null && trainee != null) {
			log.info("Accessing storage system...");
			
			return traineeDao.addTrainee(user, trainee);
		} else {
			log.warn("Please fill in all the fields to add a new Trainee.");
			
			return null;
		}
	}
	
	@Override
	public Trainee createTraineeFromAnExistingUser(Trainee trainee) {
		
		if(trainee != null) {
			log.info("Accessing storage system...");
			
			return traineeDao.addTraineeFromAnExistingUser(trainee);
		} else {
			log.warn("Please fill in all the fields to add a new Trainee.");
			
			return null;
		}
	}

	@Override
	public Trainee getTraineeById(Integer id) {

		if(id != null) {
			log.info("Accessing storage system...");
			
			return traineeDao.getTraineeById(id);
		} else {
			log.warn("The ID is null.");
			
			return null;
		}
	}

	@Override
	public Trainee updateTraineeById(Integer id, Trainee trainee) {
		
		if(id != null && trainee != null) {
			log.info("Accessing storage system.");
			
			return traineeDao.updateTraineeById(id, trainee);
		} else {
			log.warn("Please fill in all the fields to update a Trainee profile.");
			
			return null;
		}
	}

	@Override
	public void removeTraineeById(Integer id) {

		if(id != null) {
			log.info("Accessing storage system...");
			
			traineeDao.deleteTraineeById(id);
		} else {
			log.warn("The ID is null.");
		}
	}
}
