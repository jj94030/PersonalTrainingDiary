package pl.coderslab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String surname;
	@Email
	@Column(unique = true)
	private String email;
	@NotNull
	private Integer phoneNumber;
	@NotEmpty
	private String goal;
	@NotEmpty
	private String gym;
	@NotEmpty
	private String[] daysOfTraining; 
	private int startTraining;
	private int endTraining;
	@ManyToOne
	@JoinColumn(name="personalTrainer_id")
	private	PersonalTrainer	personalTrainer;
	
	public Client() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getGym() {
		return gym;
	}
	public void setGym(String gym) {
		this.gym = gym;
	}
	public String[] getDaysOfTraining() {
		return daysOfTraining;
	}

	public void setDaysOfTraining(String[] daysOfTraining) {
		this.daysOfTraining = daysOfTraining;
	}
	
	

	public PersonalTrainer getPersonalTrainer() {
		return personalTrainer;
	}

	public void setPersonalTrainer(PersonalTrainer personalTrainer) {
		this.personalTrainer = personalTrainer;
	}

	public int getStartTraining() {
		return startTraining;
	}

	public void setStartTraining(int startTraining) {
		this.startTraining = startTraining;
	}

	public int getEndTraining() {
		return endTraining;
	}

	public void setEndTraining(int endTraining) {
		this.endTraining = endTraining;
	}

	
	
	
	
}
