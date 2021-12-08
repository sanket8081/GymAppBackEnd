package com.sanket8081.gymapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket8081.gymapp.exception.ResourceNotFoundException;
import com.sanket8081.gymapp.model.Payment;
import com.sanket8081.gymapp.model.User;
import com.sanket8081.gymapp.repository.PaymentRepository;
import com.sanket8081.gymapp.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/")
public class PaymentController {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/payments")
	public List<Payment> getAllPaymentDetails()
	{
		return paymentRepository.findAll();
	}
	
	@PostMapping("/payments/{userId}")
	public Payment addPayment(@RequestBody Payment payment,@PathVariable String userId)
	{
		User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("NA"));
		payment.setUser(user);
		return paymentRepository.save(payment);
	}
	
	@GetMapping("/payments/{userId}")
	public List<Payment> getPaymentsByUserId(@PathVariable String userId)
	{
		return paymentRepository.findPaymentsByUserId(userId);
	}
	
	@PutMapping("/payments/{userId}/{paymentId}")
	public ResponseEntity<Payment> updatePaymentDetailsByPayId(@RequestBody Payment paymentDetails,@PathVariable String userId,@PathVariable String paymentId)
	{
		User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("NA"));
		Payment payment = paymentRepository.findById(paymentId)
				.orElseThrow(()->new ResourceNotFoundException("Payment details not found with payment id: "+paymentId));
		payment.setDuration(paymentDetails.getDuration());
		payment.setExistingMember(paymentDetails.getExistingMember());
		payment.setEffectiveDate(paymentDetails.getEffectiveDate());
		payment.setExpirationDate(paymentDetails.getExpirationDate());
		payment.setUser(user);

		Payment updatedPayment = paymentRepository.save(payment);
		return ResponseEntity.ok(updatedPayment);
	}
	
	@DeleteMapping("/payments/{paymentId}")
	public ResponseEntity<Map<String, Boolean>> deletePaymentByPayId(@PathVariable String paymentId)
	{
		Payment payment = paymentRepository.findById(paymentId)
				.orElseThrow(()-> new ResourceNotFoundException("Payment details not found with payment id: "+paymentId));
		
		paymentRepository.delete(payment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
