package com.sanket8081.gymapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket8081.gymapp.exception.ResourceNotFoundException;
import com.sanket8081.gymapp.model.User;
import com.sanket8081.gymapp.repository.UserRepository;
import com.sanket8081.gymapp.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	//get All user list
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	//create user
	@PostMapping("/users")
	public String createUser(@RequestBody User user)
	{
		String newUserId="";
		User newUser = userService.addUser(user);
		if(user.getUserId()!=null)
		{
			newUserId = newUser.getUserId();
		}
		
		return newUserId;
	}
	
	//get User by Id
	//Here we have used ResponseEntity, which also sends the status along with the body
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable  String userId)
	{
		User user = userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User not exist with id: "+userId));
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/users/email/{userEmailId}")
	public ResponseEntity<User> getUserByEmailId(@PathVariable  String userEmailId)
	{
		User user = userRepository.findByUserEmailId(userEmailId)
				.orElseThrow(()-> new ResourceNotFoundException("User not exist with email-id: "+userEmailId));
				
		
		return ResponseEntity.ok(user);
	}

	//Update user details
	@PutMapping("/users/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User userDetails)
	{
		User user = userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User not exist with user id :"+userId));
		user.setUserName(userDetails.getUserName());
		user.setAddress(userDetails.getAddress());
		user.setContactNumber(userDetails.getContactNumber());
		user.setEmailId(userDetails.getEmailId());
		user.setPassword(userDetails.getPassword());
		//user.setIsAdmin(userDetails.getIsAdmin());
		//user.setEffectiveDate(userDetails.getEffectiveDate());
		//user.setExpirationDate(userDetails.getExpirationDate());
		
		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	//Delete User
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable String userId)
	{
		User user = userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User not exist with user id :"+userId));
		
		userRepository.delete(user);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
}
