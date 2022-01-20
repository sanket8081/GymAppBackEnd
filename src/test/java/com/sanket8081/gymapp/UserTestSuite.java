package com.sanket8081.gymapp;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.sanket8081.gymapp.controller.UserControllerTestJunit;
import com.sanket8081.gymapp.repository.UserRepositoryIntegrationTest;
import com.sanket8081.gymapp.services.UserServiceTestMockitoExample;


@Suite
@SelectClasses({
	UserServiceTestMockitoExample.class,
	UserControllerTestJunit.class,
	UserRepositoryIntegrationTest.class
})
public class UserTestSuite {

	//intentionally empty - Test suite setup(annotations) is sufficient
}
