package gymsystem.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gymsystem.Facade;
import gymsystem.dao.TraineeDao;
import gymsystem.dao.TrainerDao;
import gymsystem.dao.TrainingDao;
import gymsystem.dao.UserDao;
import gymsystem.dao.impl.TraineeDaoImpl;
import gymsystem.dao.impl.TrainerDaoImpl;
import gymsystem.dao.impl.TrainingDaoImpl;
import gymsystem.dao.impl.UserDaoImpl;
import gymsystem.services.TraineeService;
import gymsystem.services.TrainerService;
import gymsystem.services.TrainingService;
import gymsystem.services.UserService;
import gymsystem.services.impl.TraineeServiceImpl;
import gymsystem.services.impl.TrainerServiceImpl;
import gymsystem.services.impl.TrainingServiceImpl;
import gymsystem.services.impl.UserServiceImpl;
import gymsystem.storage.Storage;

@Configuration
public class GymsystemConfig {

	@Bean
	public Storage storage() {
		return new Storage();
	}
	
	@Bean
    public Logger logger() {
        return LoggerFactory.getLogger("Gymsystem");
    }
	
	@Bean
	public Facade facade(UserService userService,
			TraineeService traineeService,
			TrainerService trainerService,
			TrainingService trainingService) {
		
		return new Facade(userService, traineeService,
				trainerService, trainingService);
	}
	
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}

	@Bean
	public TraineeDao traineeDao(){
		return new TraineeDaoImpl();
	}
	
	@Bean
	public TrainerDao trainerDao() {
		return new TrainerDaoImpl();
	}
	
	@Bean
	public TrainingDao trainingDao() {
		return new TrainingDaoImpl();
	}

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
	@Bean
	public TraineeService traineeService() {
		return new TraineeServiceImpl();
	}
	
	@Bean
	public TrainerService trainerService() {
		return new TrainerServiceImpl();
	}
	
	@Bean
	public TrainingService trainingService() {
		return new TrainingServiceImpl();
	}
}
