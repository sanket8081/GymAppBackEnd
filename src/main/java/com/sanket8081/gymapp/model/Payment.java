package com.sanket8081.gymapp.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "payment_details")
public class Payment {

	@Id
	@Column(name="payment_id")
	private String paymentId;
	
	private String duration;
	
	@Column(name="existing_member")
	private String existingMember;
	
	@Column(name="total_fee")
	private String totalFee;
	
	@Column(name="is_paid")
	private String isPaid;
	
	@Column(name="effectivedate")
	private Date  effectiveDate;
	
	@Column(name="expirationdate")
	private Date  expirationDate;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userPayId" ,referencedColumnName = "user_id")
	private User user;
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Payment()
	{
		
	}
	
	

	public Payment(String paymentId, String duration, String existingMember, String totalFee, String isPaid,
			 Date effectiveDate, Date expirationDate,User user) {
		super();
		this.paymentId = paymentId;
		this.duration = duration;
		this.existingMember = existingMember;
		this.totalFee = totalFee;
		this.isPaid = isPaid;
		this.effectiveDate = effectiveDate;
		this.expirationDate = expirationDate;
		this.user=user;
	}



	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getExistingMember() {
		return existingMember;
	}

	public void setExistingMember(String existingMember) {
		this.existingMember = existingMember;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}


	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	
	
}
