package com.sanket8081.gymapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.mockito.ArgumentMatchers;
import com.sanket8081.gymapp.model.User;
import com.sanket8081.gymapp.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UserServiceTestMockitoExample {
	
	@Mock
	private UserRepository userRepository;
	
	private AutoCloseable closeable;
	
	@InjectMocks
	private UserService userService;
	
	@BeforeEach
	public void setUpMocks()
	{
		closeable =  MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void closeMock() throws Exception
	{
		closeable.close();
	}
	
	@Test
	void addUserUsingMock() {
		User userMock = new User();
		userMock.setUserId("sj424b");
		userMock.setUserName("Shubhansu Jee");
		userMock.setDob(java.sql.Date.valueOf("2022-01-11"));
		
		when(userRepository.save(Mockito.any(User.class))).thenReturn(userMock);
		
		//save the user
		User dummyUser = new User();
		User newUser = userService.addUser(dummyUser);
		
		//verify the save
		assertEquals("sj424b", newUser.getUserId());
		
	}

}
