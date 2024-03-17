package gymsystem.storage;

import java.util.Map;
import java.util.HashMap;

import gymsystem.models.Trainee;
import gymsystem.models.Trainer;
import gymsystem.models.Training;
import gymsystem.models.TrainingType;
import gymsystem.models.User;

import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

public class Storage {
	
	@Autowired
	private Logger log;

	Map<Integer, User> users = new HashMap<>();
	Map<Integer, Trainee> trainees = new HashMap<>();
	Map<Integer, Trainer> trainers = new HashMap<>();
	Map<Integer, TrainingType> trainingTypes = new HashMap<>();
	Map<Integer, Training> trainings = new HashMap<>();
	
	public User saveUser(User user) {
		
		if(user.getFirstName().isEmpty() || user.getLastName().isEmpty() ||
				user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
			
			log.warn("Please fill in all the fields to add a new user.");
			
			return null;
		}
		
		users.put(user.getId(), user);
		
		log.info("User saved:\n" +
				"User ID: " + user.getId() +
				"\nFirst Name: " + user.getFirstName() +
				"\nLast Name: " + user.getLastName() +
				"\nUsername: " + user.getUsername() +
				"\nPassword: **********" +
				"\nIs Active? " + user.isActive());
		
		return user;
	}
	
	public User getUserById(int id) {

		if(userExists(id)) {
			log.info("User found successfully!");
			
			return users.get(id);
		} else {
			log.warn("User not found.");
			
			return null;
		}
	}
	
	public User updateUserById(int id, User user) {
		
		if(userExists(id)) {
			users.put(id, user);
			log.info("User updated:\n" +
					"User ID: " + user.getId() +
					"\nFirst Name: " + user.getFirstName() +
					"\nLast Name: " + user.getLastName() +
					"\nUsername: " + user.getUsername() +
					"\nPassword: **********" +
					"\nIs Active? " + user.isActive());
			
			return user;
		}
		else {
			return null;
		}
	}
	
	public void deleteUserById(int id) {
		
		if(userExists(id)) {
			users.remove(id);
			log.info("User removed successfully.");
		} else {
			log.warn("User not found.");
		}
	}
	
	public Trainee saveTrainee(Trainee trainee){
		
		if(trainee.getUserId() != null){
			trainees.put(trainee.getId(), trainee);

			log.info("Trainee saved:\n" +
				"Trainee ID: " + trainee.getId() +
				"\nDate of birth: " + trainee.getDateOfBirth() +
				"\nAddress: " + trainee.getAddress() +
				"\nUser ID: " + trainee.getUserId());

			return trainee;
		} else {
			log.warn("Please enter a User ID to sync this Trainee to a User.");

			return null;
		}
	}

	public Trainee getTraineeById(Integer id){

		if(traineeExists(id)){
			log.info("Trainee found successfully.");

			return trainees.get(id);
		} else {
			log.warn("Trainee not found");

			return null;
		}
	}

	public Trainee updateTraineeById(Integer id, Trainee trainee){

		if(id != trainee.getId()) {
			
			trainees.remove(id);
			trainees.put(trainee.getId(), trainee);
			log.info("Trainee updated:\n" +
					"Trainee ID: " + trainee.getId() +
					"\nDate of birth: " + trainee.getDateOfBirth() +
					"\nAddress: " + trainee.getAddress() +
					"\nUser ID: " + trainee.getUserId());
			
			return trainee;
		}
		else if(traineeExists(id)){

			trainees.put(id, trainee);
			log.info("Trainee updated:\n" +
					"Trainee ID: " + trainee.getId() +
					"\nDate of birth: " + trainee.getDateOfBirth() +
					"\nAddress: " + trainee.getAddress() +
					"\nUser ID: " + trainee.getUserId());
			
			return trainee;
		} else {

			log.warn("Trainee not found.");

			return null;
		}
	}

	public void deleteTraineeById(int id) {
		
		if(traineeExists(id)) {

			trainees.remove(id);
			log.info("Trainee removed successfully.");
		} else {

			log.warn("Trainee not found.");
		}
	}
	
	public Trainer saveTrainer(Trainer trainer) {
	
		if(trainer.getUserId() != null) {
			trainers.put(trainer.getId(), trainer);
			
			log.info("Trainer saved:\n" +
					"Trainer ID: " + trainer.getId() +
					"\nSpecialization ID: " + trainer.getSpecialization() +
					"\nUser ID: " + trainer.getUserId());
			
			return trainer;
			
		} else {
			log.warn("Please enter a User ID to sync this Trainer to a User.");
			
			return null;
		}
	}
	
	public Trainer getTrainerById(Integer id) {
		
		if(trainerExists(id)) {
			log.info("Trainer found successfully.");
			
			return trainers.get(id);
		} else {
			log.warn("Trainer not found.");
			
			return null;
		}
	}
	
	public Trainer updateTrainerById(Integer id, Trainer trainer) {
		
		if(id != trainer.getId()) {
			trainers.remove(id);
			trainers.put(trainer.getId(), trainer);
			log.info("Trainer updated:\n" +
					"Trainer ID: " + trainer.getId() +
					"\nSpecialization ID: " + trainer.getSpecialization() +
					"\nUser ID: " + trainer.getUserId());
			
			return trainer;
		}
		else if(trainerExists(id)) {
			trainers.put(trainer.getId(), trainer);
			log.info("Trainer updated:\n" +
					"Trainer ID: " + trainer.getId() +
					"\nSpecialization ID: " + trainer.getSpecialization() +
					"\nUser ID: " + trainer.getUserId());
			
			return trainer;
		} else {
			log.warn("Trainer not found.");
			
			return null;
		}
	}
	
	public void deleteTrainerById(Integer id) {
		
		if(trainerExists(id)) {
			trainers.remove(id);
			log.info("Trainer removed successfully.");
		} else {
			log.warn("Trainer not found.");
		}
	}
	
	public Training saveTraining(Training training) {
		
		if(training.getId() != null) {
			trainings.put(training.getId(), training);
			
			log.info("Training saved:\n" +
					"Training ID: " + training.getId() +
					"\nTrainee ID: " + training.getTraineeId() +
					"\nTrainer ID: " + training.getTrainerId() +
					"\nTraining Name: " + training.getTrainingName() +
					"\nTraining Type ID: " + training.getTrainingTypeId() +
					"\nTraining Date: " + training.getTrainingDate() +
					"\nTraining Duration: " + training.getTrainingDuration());
			
			return training;
			
		} else {
			log.warn("Please enter a valid Training ID.");
			
			return null;
		}
	}
	
	public Training getTrainingById(Integer id) {
		
		if(trainingExists(id)) {
			log.info("Training found successfully.");
			
			return trainings.get(id);
		} else {
			log.warn("Training not found.");
			
			return null;
		}
	}
	
	public Training updateTrainingById(Integer id, Training training) {
		
		if(id != training.getId()) {
			trainings.remove(id);
			trainings.put(training.getId(), training);
			log.info("Training updated:\n" +
					"Training ID: " + training.getId() +
					"\nTrainee ID: " + training.getTraineeId() +
					"\nTrainer ID: " + training.getTrainerId() +
					"\nTraining Name: " + training.getTrainingName() +
					"\nTraining Type ID: " + training.getTrainingTypeId() +
					"\nTraining Date: " + training.getTrainingDate() +
					"\nTraining Duration: " + training.getTrainingDuration());
			
			return training;
		}
		else if(trainingExists(id)) {
			trainings.put(training.getId(), training);
			
			log.info("Training updated:\n" +
					"Training ID: " + training.getId() +
					"\nTrainee ID: " + training.getTraineeId() +
					"\nTrainer ID: " + training.getTrainerId() +
					"\nTraining Name: " + training.getTrainingName() +
					"\nTraining Type ID: " + training.getTrainingTypeId() +
					"\nTraining Date: " + training.getTrainingDate() +
					"\nTraining Duration: " + training.getTrainingDuration());
			
			return training;
		} else {
			log.warn("Training not found.");
			
			return null;
		}
	}
	
	public void deleteTrainingById(Integer id) {
		
		if(trainingExists(id)) {
			trainings.remove(id);
			log.info("Training removed successfully.");
		} else {
			log.warn("Training not found.");
		}
	}
	
	public boolean userExists(Integer id) {
		if(id == null) {
			log.warn("Please enter a valid User ID.");
			
			return false;
		} else {
			return users.containsKey(id);
		}
	}

	public boolean traineeExists(Integer id){
		if(id == null) {
			log.warn("Please enter a valid Trainee ID.");
			
			return false;
		} else {
			return trainees.containsKey(id);
		}
	}
	
	public boolean trainerExists(Integer id) {
		
		if(id == null) {
			log.warn("Please enter a valid Trainer ID.");
			
			return false;
		} else {
			return trainers.containsKey(id);
		}
		
	}
	
	public boolean trainingExists(Integer id) {
		
		if(id == null) {
			log.warn("Please enter a valid Training ID.");
			
			return false;
		} else {
			return trainings.containsKey(id);
		}
		
	}
}