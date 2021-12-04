package com.sanket8081.gymapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanket8081.gymapp.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

}
