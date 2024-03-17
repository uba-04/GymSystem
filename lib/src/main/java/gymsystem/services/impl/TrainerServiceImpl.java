package gymsystem.services.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import gymsystem.dao.TrainerDao;
import gymsystem.models.Trainer;
import gymsystem.models.User;
import gymsystem.services.TrainerService;

public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerDao trainerDao;
	
	@Autowired
	private Logger log;
	
	@Override
	public Trainer createTrainer(User user, Trainer trainer) {
		
		if(user != null && trainer != null) {
			log.info("Accessing storage system...");
			
			return trainerDao.addTrainer(user, trainer);
		} else {
			log.warn("Please fill in all the fields to add a new Trainer.");
			
			return null;
		}
	}
	
	@Override
	public Trainer createTrainerFromAnExistingUser(Trainer trainer) {
		
		if(trainer != null) {
			log.info("Accessing storage system...");
			
			return trainerDao.addTrainerFromAnExistingUser(trainer);
		} else {
			log.warn("Please fill in all the fields to add a new Trainer.");
			
			return null;
		}
	}

	@Override
	public Trainer getTrainerById(Integer id) {

		if(id != null) {
			log.info("Accessing storage system...");
			
			return trainerDao.getTrainerById(id);
		} else {
			log.warn("The ID is null.");
			
			return null;
		}
	}

	@Override
	public Trainer updateTrainerById(Integer id, Trainer trainer) {
		
		if(id != null && trainer != null) {
			log.info("Accessing storage system.");
			
			return trainerDao.updateTrainerById(id, trainer);
		} else {
			log.warn("Please fill in all the fields to update a Trainer profile.");
			
			return null;
		}
	}

	@Override
	public void removeTrainerById(Integer id) {

		if(id != null) {
			log.info("Accessing storage system...");
			
			trainerDao.deleteTrainerById(id);
		} else {
			log.warn("The ID is null.");
		}
	}
}
