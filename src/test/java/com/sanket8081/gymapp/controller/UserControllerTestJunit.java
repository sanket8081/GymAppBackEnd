package com.sanket8081.gymapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sanket8081.gymapp.model.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTestJunit {

	@Autowired
	private UserController userController;
	
	@Test
	public void testCreateUser()
	{
		User newUSer = new User();
		newUSer.setUserId("rt425j");
		newUSer.setUserName("Raghupati Tiwari");
		
		//POST req to our controller's create user method
		String insUserId = userController.createUser(newUSer);
		
		assertEquals("rt425j",insUserId);
		
		
	}
	
}
