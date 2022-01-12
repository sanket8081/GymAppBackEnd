package com.sanket8081.gymapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.DateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sanket8081.gymapp.model.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UserServiceTestUsingJunit {

	@Autowired
	private UserService userService;
	
	@Test
	public void testAddUser()
	{
		//Create a User
		User user = new User();
		user.setUserId("qs5043");
		user.setUserName("Qurrat Shaikh");
		user.setDob(java.sql.Date.valueOf("2022-01-11"));
		
		//Test adding a User
		User newUser = userService.addUser(user);
		
		assertNotNull(newUser);
		assertNotNull(newUser.getUserId());
		assertEquals(user.getUserId(), newUser.getUserId());
	}
}
