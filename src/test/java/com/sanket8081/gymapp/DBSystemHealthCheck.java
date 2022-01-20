package com.sanket8081.gymapp;

import javax.activation.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mysql.cj.jdbc.DatabaseMetaData;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DBSystemHealthCheck {

	@Autowired
	DataSource dataSource;
	
	@Test
	public void dbPrimaryIsOk()
	{
		
	}
}
