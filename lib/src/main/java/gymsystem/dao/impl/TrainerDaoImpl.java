package gymsystem.dao.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import gymsystem.dao.TrainerDao;
import gymsystem.dao.UserDao;
import gymsystem.models.Trainer;
import gymsystem.models.User;
import gymsystem.storage.Storage;

public class TrainerDaoImpl implements TrainerDao{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private Logger log;
	
	@Autowired
	private Storage storage;
	
	@Override
	public Trainer addTrainer(User user, Trainer trainer) {

		if(userDao.requiredFieldsAreFull(user) && trainer != null) {
			log.info("Creating Trainer...");
			
			userDao.addUser(user);
			storage.saveTrainer(trainer);
			
			return trainer;
		} else {
			log.warn("Please fill in all the fields to add a new trainee.");
			
			return null;
		}
	}

	@Override
	public Trainer addTrainerFromAnExistingUser(Trainer trainer) {

		if(trainer != null && storage.trainerExists(trainer.getId())){
			log.info("Adding Trainer...");
			
			storage.saveTrainer(trainer);
			
			return trainer;
		} else {
			log.warn("Please fill in all the fields to add a new trainer.");
			
			return null;
		}
	}

	@Override
	public Trainer getTrainerById(Integer id) {
		
		if(id != null && storage.trainerExists(id)) {
			log.info("Fetching trainer profile...");
			
			return storage.getTrainerById(id);
		} else {
			log.warn("Trainer for the specified ID does not exist.");
			
			return null;
		}
	}

	@Override
	public Trainer updateTrainerById(Integer id, Trainer trainer) {

		if(id != null &&
				trainer.getId() != null &&
				trainer.getSpecialization() != null &&
				trainer.getUserId() != null) {
			
			log.info("Updating Trainer profile...");
			
			return storage.updateTrainerById(id, trainer);
		} else {
			log.warn("Please fill in all the fields to update a trainer profile.");
			
			return null;
		}
	}

	@Override
	public void deleteTrainerById(Integer id) {
		
		if(id != null) {
			log.info("Removing Trainer profile...");
			
			storage.deleteTrainerById(id);
		} else {
			log.warn("ID is null.");
		}
	}
}