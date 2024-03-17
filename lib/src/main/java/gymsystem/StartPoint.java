package gymsystem;

import gymsystem.configs.GymsystemConfig;
import gymsystem.models.Trainee;
import gymsystem.models.Trainer;
import gymsystem.models.Training;
import gymsystem.models.User;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class StartPoint {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(GymsystemConfig.class);
		
		Facade facade = context.getBean(Facade.class);
		
		executeUserOperations(facade);
		executeTraineeOperations(facade);
		executeTrainerOperations(facade);
		executeTrainingOperations(facade);
		
	}
	
	private static void executeUserOperations(Facade facade) {
		// Adding a new user
		
				User user = new User();
				user.setId(1);
				user.setFirstName("Ubaldo");
				user.setLastName("Flor");
				user.setActive(true);
				
				facade.createUser(user);
				
				// Getting the user
				
				facade.getUserById(1);
				facade.getUserById(3);
				
				// Updating the user
				
				User user1 = new User();
				user1.setId(1);
				user1.setFirstName("Irma");
				user1.setLastName("Ortega");
				user1.setActive(true);
				facade.updateUserById(1, user1);
				facade.getUserById(1);
				
				// Deleting the user
				facade.removeUserById(1);
				facade.getUserById(1);
	}
	
	private static void executeTraineeOperations(Facade facade) {
				// Adding a new Trainee
				User traineeUser = new User();
				traineeUser.setId(1);
				traineeUser.setFirstName("Ubaldo");
				traineeUser.setLastName("Flor");
				traineeUser.setActive(true);
				Trainee trainee = new Trainee();
				trainee.setId(1);
				trainee.setDateOfBirth(new Date());
				trainee.setAddress("This is a test address.");
				trainee.setUserId(traineeUser.getId());

				facade.createTrainee(traineeUser, trainee);

				// Getting the newly created Trainee
				facade.getTraineeById(1);

				// Updating existing Trainee
				Trainee updatedTrainee = new Trainee();
				updatedTrainee.setId(3);
				updatedTrainee.setAddress("This is an updated address.");
				updatedTrainee.setDateOfBirth(new Date());
				updatedTrainee.setUserId(traineeUser.getId());

				facade.updateTraineeById(1, updatedTrainee);

				// Deleting non existing Trainee
				facade.removeTraineeById(1);

				// Deleting existing Trainee
				facade.removeTraineeById(3);
	}
	
	private static void executeTrainerOperations(Facade facade) {
		// Adding a new Trainer
		User user = new User();
		user.setId(5);
		user.setFirstName("Jhon");
		user.setLastName("Doe");
		Trainer trainer = new Trainer();
		trainer.setId(1);
		trainer.setSpecialization(3);
		trainer.setUserId(5);
		facade.createTrainer(user, trainer);
		
		// Getting a Trainer
		facade.getTrainerById(1);
		facade.getTrainerById(3);
		
		// Updating a Trainer
		Trainer updatedTrainer = new Trainer();
		updatedTrainer.setId(4);
		updatedTrainer.setSpecialization(2);
		updatedTrainer.setUserId(5);
		facade.updateTrainerById(1, updatedTrainer);
		
		// Delete a Trainer
		facade.removeTrainerById(7);
		facade.removeTrainerById(4);
	}
	
	private static void executeTrainingOperations(Facade facade) {
		// Adding a new Training
		Training training = new Training();
		training.setId(1);
		training.setTrainingName("Training One");
		training.setTrainingDate(new Date());
		training.setTrainingDuration(2);
		facade.createTraining(training);
		
		// Getting a Training
		facade.getTrainingById(2);
		facade.getTrainingById(1);
		
		// Updating a Training
		Training updatedTraining = new Training();
		updatedTraining.setId(5);
		updatedTraining.setTrainingName("Training Five");
		updatedTraining.setTrainingDate(new Date());
		updatedTraining.setTrainingDuration(1);
		facade.updateTrainingById(1, updatedTraining);
		
		// Deleting a Training
		facade.removeTrainingById(1);
		facade.removeTrainingById(5);
	}
}