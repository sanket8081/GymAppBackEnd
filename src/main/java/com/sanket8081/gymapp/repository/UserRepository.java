package com.sanket8081.gymapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sanket8081.gymapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
	
	@Query("from User where email_id like ?1 ")
	Optional<User> findByUserEmailId(String emailId);
}
