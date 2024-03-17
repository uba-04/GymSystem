package gymsystem.models;

public class Trainer {
	
	private Integer id;
	private Integer specialization;
	private Integer userId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Integer specialization) {
		this.specialization = specialization;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
