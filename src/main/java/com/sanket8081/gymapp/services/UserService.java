package com.sanket8081.gymapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket8081.gymapp.model.User;
import com.sanket8081.gymapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public User addUser(User user)
	{
	
		User newUSer= null;
		if(user.getUserId()!=null)
		{
			newUSer = userRepository.save(user);
		}
		
		return newUSer;
	}
}
