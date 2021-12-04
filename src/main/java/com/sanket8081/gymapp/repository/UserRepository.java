package com.sanket8081.gymapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanket8081.gymapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
	
	

}
