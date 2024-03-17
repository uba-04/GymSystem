package gymsystem.dao.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import gymsystem.dao.TraineeDao;
import gymsystem.dao.UserDao;
import gymsystem.models.Trainee;
import gymsystem.models.User;
import gymsystem.storage.Storage;

public class TraineeDaoImpl implements TraineeDao{

    @Autowired
    private Storage storage;

    @Autowired
    private Logger log;

    @Autowired
    private UserDao userDao;

    @Override
    public Trainee addTrainee(User user, Trainee trainee) {
        
        if(userDao.requiredFieldsAreFull(user) && trainee != null){

            log.info("Creating Trainee...");

            userDao.addUser(user);
            storage.saveTrainee(trainee);

            return trainee;
        }
        else {
            log.warn("Please fill in all the fields to add a new trainee.");

            return null;
        }
    }

    @Override
    public Trainee addTraineeFromAnExistingUser(Trainee trainee) {
        
        if(trainee != null && storage.userExists(trainee.getUserId())){

            log.info("Adding trainee...");

            storage.saveTrainee(trainee);

            return trainee;
        }
        else {

            log.warn("User for the specified ID does not exist.");

            return null;
        }
    }

    @Override
    public Trainee getTraineeById(Integer id) {
        
        if(id != null && storage.traineeExists(id)){

            log.info("Fetching trainee profile...");

            return storage.getTraineeById(id);
        }
        else {

            log.warn("Trainee for the specified ID does not exist.");

            return null;
        }
    }

    @Override
    public Trainee updateTraineeById(Integer id, Trainee trainee) {
        
        if(id != null && trainee.getId() != null && trainee.getUserId() != null){

            log.info("Updating Trainee profile...");
            
            return storage.updateTraineeById(id, trainee);
        }
        else {
            log.warn("Please fill in all the fields to update a trainee profile.");

            return null;
        }
    }

    @Override
    public void deleteTraineeById(Integer id) {
        
        if(id != null){

            log.info("Removing Trainee profile...");

            storage.deleteTraineeById(id);
        }
        else {
            log.warn("ID is null.");
        }
    }
}