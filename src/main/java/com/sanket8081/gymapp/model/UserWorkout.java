package com.sanket8081.gymapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_workout_details")
public class UserWorkout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String day;
	@Column(name = "workout_information")
	private String workoutInformation;
	
	public UserWorkout() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getWorkoutInformation() {
		return workoutInformation;
	}

	public void setWorkoutInformation(String workoutInformation) {
		this.workoutInformation = workoutInformation;
	}

	public UserWorkout(String day, String workoutInformation) {
		super();
		this.day = day;
		this.workoutInformation = workoutInformation;
	}
	
	
	
	
	
	
	
	
	
	
	
}
