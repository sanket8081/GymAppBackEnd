package com.sanket8081.gymapp.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="user_details")
public class User {

	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="photo_id")
	private String photoId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="contact_number")
	private long contactNumber;
	
	private String address;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dob;
	
	@Column(name="is_admin")
	private String isAdmin;
	
	
	@Column(name="effectivedate")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date effectiveDate;
	
	@Column(name="expirationdate")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date expirationDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userPayId", referencedColumnName = "user_id")
	List<Payment> payments = new ArrayList<>(); 
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userWorkoutId" ,referencedColumnName = "user_id")
	List<UserWorkout> userWorkout = new ArrayList<>();
	
	public User()
	{
		
	}
	
	public User(String photoId, String userId, String username, String emailId, long mobileNumber, String address,
			Date dob, String isAdmin, Date effectiveDate, Date expirationDate) {
		super();
		this.photoId = photoId;
		this.userId = userId;
		this.userName = username;
		this.emailId = emailId;
		this.contactNumber = mobileNumber;
		this.address = address;
		this.dob = dob;
		this.isAdmin = isAdmin;
		this.effectiveDate = effectiveDate;
		this.expirationDate = expirationDate;
	}
	
	public List<UserWorkout> getUserWorkout() {
		return userWorkout;
	}

	public void setUserWorkout(List<UserWorkout> userWorkout) {
		this.userWorkout = userWorkout;
	}
	
	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public String getPhotoId() {
		return photoId;
	}
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long mobileNumber) {
		this.contactNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
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
