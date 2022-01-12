package com.sanket8081.gymapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sanket8081.gymapp.model.User;
import com.sanket8081.gymapp.repository.PaymentRepository;
import com.sanket8081.gymapp.repository.UserRepository;

@SpringBootTest
class GymAppBackendApplicationTests {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Disabled
	@Test
	void contextLoads() {
	}

	
	@Test
	void checkTotalRevenue()
	{
		int totalRevenue = paymentRepository.totalRevenue();
		assertThat(totalRevenue).isGreaterThanOrEqualTo(500);
	}
	
	
}
