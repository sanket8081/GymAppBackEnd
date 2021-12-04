package com.sanket8081.gymapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sanket8081.gymapp.model.Payment;
import com.sanket8081.gymapp.model.User;
import com.sanket8081.gymapp.model.UserWorkout;
import com.sanket8081.gymapp.repository.UserRepository;

@SpringBootApplication
public class GymAppBackendApplication implements CommandLineRunner {
	
	private static final Logger log = LogManager.getLogger(GymAppBackendApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(GymAppBackendApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*User user = new User(null, "sd769y", null, null, 0, null, null, null, null, null);
		log.info("User: "+user.getUserId()+" created.");
		Payment payment1 = new Payment("DEC042021", null, null, null, null, null, null, null, null);
		Payment payment2 = new Payment("JAN022022", null, null, null, null, null, null, null, null);
		
		UserWorkout userWorkout1 = new UserWorkout("Monday", "Chest");
		UserWorkout userWorkout2 = new UserWorkout("Tuesday", "Triceps");
		UserWorkout userWorkout3 = new UserWorkout("Wednesday", "Back");
		UserWorkout userWorkout4 = new UserWorkout("Thursday", "Biceps");
		UserWorkout userWorkout5 = new UserWorkout("Friday", "Shoulder");
		UserWorkout userWorkout6 = new UserWorkout("Saturday", "Legs");
		
		user.getPayments().add(payment1);
		user.getPayments().add(payment2);
		
		user.getUserWorkout().add(userWorkout1);
		user.getUserWorkout().add(userWorkout2);
		user.getUserWorkout().add(userWorkout3);
		user.getUserWorkout().add(userWorkout4);
		user.getUserWorkout().add(userWorkout5);
		user.getUserWorkout().add(userWorkout6);
		
		this.userRepository.save(user);*/
		
	}

}
