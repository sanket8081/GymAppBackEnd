package com.sanket8081.gymapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanket8081.gymapp.exception.ResourceNotFoundException;
import com.sanket8081.gymapp.model.User;
import com.sanket8081.gymapp.model.UserWorkout;
import com.sanket8081.gymapp.repository.UserRepository;
import com.sanket8081.gymapp.repository.UserWorkoutRepository;

@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class UserWorkoutController {

	@Autowired
	private UserWorkoutRepository userWorkoutRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/userworkout/{userId}")
	public List<UserWorkout> getWorkoutDetailsByUserId(@PathVariable String userId)
	{
		return userWorkoutRepository.findWorkoutByUserId(userId);
	}
	
	@GetMapping("/userworkout/{userId}/{day}")
	public UserWorkout getWorkoutDetailsByUserIdAndDay(@PathVariable String userId, @PathVariable String day)
	{
		return userWorkoutRepository.findWorkoutByUserAndDay(userId,day);
	}
	
	@PostMapping("/userworkout/{userId}")
	public UserWorkout addWorkout(@RequestBody UserWorkout userWorkoutDetails ,@PathVariable  String userId)
	{	
		User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Id "+userId+" not found!"));
		userWorkoutDetails.setUser(user);
		return userWorkoutRepository.save(userWorkoutDetails);
	}
	
	@PutMapping("/userworkout/{userId}/{day}")
	public ResponseEntity<UserWorkout> updateWorkout(@RequestBody UserWorkout userWorkoutDetails,@PathVariable String userId, @PathVariable String day)
	{
		//User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Id "+userId+" not found!"));
		UserWorkout userWorkout = userWorkoutRepository.findWorkoutByUserAndDay(userId, day);
		userWorkout.setDay(userWorkoutDetails.getDay());
		userWorkout.setWorkoutInformation(userWorkoutDetails.getWorkoutInformation());
		
		UserWorkout updatedUserWorkout = userWorkoutRepository.save(userWorkout);
		
		return ResponseEntity.ok(updatedUserWorkout);
				
	}
	
	
	//Workout delete func remaining
	
	
}
