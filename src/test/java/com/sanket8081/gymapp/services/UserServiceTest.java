package com.sanket8081.gymapp.services;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.sanket8081.gymapp.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	//Autowired will call actual service and we will get actual data
	private UserService userService;
	
	@Mock  //this will not give us the actual data
	private UserRepository userRepository;
	
	@BeforeEach()
	void setUp()
	{
		this.userService = new UserService(this.userRepository);
	}
	
	@Test()
	void getAllUser()
	{
		userService.getAllUsers();
		verify(userRepository).findAll();
	}
	
}
