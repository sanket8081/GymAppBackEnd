package com.sanket8081.gymapp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	private String freeze;
	
	@Column(name="freezedate")
	private Date freezeDate;
	
	@Column(name="effectivedate")
	private Date  effectiveDate;
	
	@Column(name="expirationdate")
	private Date  expirationDate;
	
	public Payment()
	{
		
	}
	
	

	public Payment(String paymentId, String duration, String existingMember, String totalFee, String isPaid,
			String freeze, Date freezeDate, Date effectiveDate, Date expirationDate) {
		super();
		this.paymentId = paymentId;
		this.duration = duration;
		this.existingMember = existingMember;
		this.totalFee = totalFee;
		this.isPaid = isPaid;
		this.freeze = freeze;
		this.freezeDate = freezeDate;
		this.effectiveDate = effectiveDate;
		this.expirationDate = expirationDate;
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

	public String getFreeze() {
		return freeze;
	}

	public void setFreeze(String freeze) {
		this.freeze = freeze;
	}

	public Date getFreezeDate() {
		return freezeDate;
	}

	public void setFreezeDate(Date freezeDate) {
		this.freezeDate = freezeDate;
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
