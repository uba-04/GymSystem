package gymsystem.models;

import java.util.Date;

public class Training {
	
	private Integer id;
	private Integer traineeId;
	private Integer trainerId;
	private String trainingName;
	private Integer trainingTypeId;
	private Date trainingDate;
	private Integer trainingDuration;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}
	public Integer getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public Integer getTrainingTypeId() {
		return trainingTypeId;
	}
	public void setTrainingTypeId(Integer trainingTypeId) {
		this.trainingTypeId = trainingTypeId;
	}
	public Date getTrainingDate() {
		return trainingDate;
	}
	public void setTrainingDate(Date trainingDate) {
		this.trainingDate = trainingDate;
	}
	public Integer getTrainingDuration() {
		return trainingDuration;
	}
	public void setTrainingDuration(Integer trainingDuration) {
		this.trainingDuration = trainingDuration;
	}
}
