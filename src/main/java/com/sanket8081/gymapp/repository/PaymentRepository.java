package com.sanket8081.gymapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sanket8081.gymapp.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

	@Query("from Payment where user_pay_id like ?1 ")
	List<Payment> findPaymentsByUserId(String userId);
	
	@Query(value ="select sum(total_fee) from payment_details", nativeQuery = true)
	 int totalRevenue();
	
}
