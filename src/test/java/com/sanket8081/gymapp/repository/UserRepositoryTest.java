package com.sanket8081.gymapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sanket8081.gymapp.exception.ResourceNotFoundException;
import com.sanket8081.gymapp.model.User;

@SpringBootTest
public class UserRepositoryTest {

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Test()
	@Order(1)
	@Disabled
	void checkIfUsersExist()
	{
		List<User> userList = userRepository.findAll();
		assertThat(userList).hasSize(1);
	}
	
	@Test
	@Order(2)
	void checkPersonExistById()
	{
		User user = new User();
		user.setUserId("rt425j");
		userRepository.save(user);
		
	    User resUser =  userRepository.findById(user.getUserId()).orElseThrow(()->new ResourceNotFoundException("NA"));
		
	    assertThat(resUser.getUserId().equals(user.getUserId()));
		
		
	}
	
	@AfterEach
	void cleanTable()
	{
		userRepository.deleteById("rt425j");
	}
}
