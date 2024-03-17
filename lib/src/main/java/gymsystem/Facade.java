package gymsystem;

import gymsystem.models.Trainee;
import gymsystem.models.Trainer;
import gymsystem.models.Training;
import gymsystem.models.User;
import gymsystem.services.TraineeService;
import gymsystem.services.TrainerService;
import gymsystem.services.TrainingService;
import gymsystem.services.UserService;

public class Facade {

	private final UserService userService;
	private final TraineeService traineeService;
	private final TrainerService trainerService;
	private final TrainingService trainingService;
	
	public Facade(UserService userService,
					TraineeService traineeService,
					TrainerService trainerService,
					TrainingService trainingService) {
		
		this.userService = userService;
		this.traineeService = traineeService;
		this.trainerService = trainerService;
		this.trainingService = trainingService;
	}
	
	public User createUser(User user) {
		return userService.createUser(user);
	}
	
	public User getUserById(Integer id) {
		return userService.getUserById(id);
	}
	
	public User updateUserById(Integer id, User user) {
		return userService.updateUserById(id, user);
	}
	
	public void removeUserById(Integer id) {
		userService.removeUserById(id);
	}
	
	public Trainee createTrainee(User user, Trainee trainee) {
		return traineeService.createTrainee(user, trainee);
	}
	
	public Trainee createTraineeFromAnExistingUser(Trainee trainee) {
		return traineeService.createTraineeFromAnExistingUser(trainee);
	}
	
	public Trainee getTraineeById(Integer id) {
		return traineeService.getTraineeById(id);
	}
	
	public Trainee updateTraineeById(Integer id, Trainee trainee) {
		return traineeService.updateTraineeById(id, trainee);
	}
	
	public void removeTraineeById(Integer id) {
		traineeService.removeTraineeById(id);
	}
	
	public Trainer createTrainer(User user, Trainer trainer) {
		return trainerService.createTrainer(user, trainer);
	}
	
	public Trainer createTrainerFromAnExistingUser(Trainer trainer) {
		return trainerService.createTrainerFromAnExistingUser(trainer);
	}
	
	public Trainer getTrainerById(Integer id) {
		return trainerService.getTrainerById(id);
	}
	
	public Trainer updateTrainerById(Integer id, Trainer trainer) {
		return trainerService.updateTrainerById(id, trainer);
	}
	
	public void removeTrainerById(Integer id) {
		trainerService.removeTrainerById(id);
	}
	
	public Training createTraining(Training training) {
		return trainingService.createTraining(training);
	}
	
	public Training getTrainingById(Integer id) {
		return trainingService.getTrainingById(id);
	}
	
	public Training updateTrainingById(Integer id, Training training) {
		return trainingService.updateTrainingById(id, training);
	}
	
	public void removeTrainingById(Integer id) {
		trainingService.removeTrainingById(id);
	}
}
