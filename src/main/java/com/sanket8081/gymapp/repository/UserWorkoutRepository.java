package com.sanket8081.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanket8081.gymapp.model.UserWorkout;

public interface UserWorkoutRepository extends JpaRepository<UserWorkout, String> {

	@Query("from UserWorkout where user_workout_id like ?1 ")
	List<UserWorkout> findWorkoutByUserId(String userId);
	
	@Query("from UserWorkout where user_workout_id like :userId and day=:day ")
	UserWorkout findWorkoutByUserAndDay(@Param("userId") String userId,@Param("day") String day);
}
