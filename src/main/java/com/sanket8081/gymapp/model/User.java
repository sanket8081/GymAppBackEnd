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
	
	@Column(name="password")
	private String password;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="contact_number")
	private long contactNumber;
	
	private String address;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dob;
	
	@Column(name="is_admin")
	private String isAdmin;
	
	private String freeze;
	
	@Column(name="freezedate")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date freezeDate;
	
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
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
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

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<UserWorkout> getUserWorkout() {
		return userWorkout;
	}

	public void setUserWorkout(List<UserWorkout> userWorkout) {
		this.userWorkout = userWorkout;
	}

	public User(String userId, String photoId, String userName,String password, String emailId, long contactNumber, String address,
			Date dob, String isAdmin, String freeze, Date freezeDate, Date effectiveDate, Date expirationDate,
			List<Payment> payments, List<UserWorkout> userWorkout) {
		super();
		this.userId = userId;
		this.photoId = photoId;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.address = address;
		this.dob = dob;
		this.isAdmin = isAdmin;
		this.freeze = freeze;
		this.freezeDate = freezeDate;
		this.effectiveDate = effectiveDate;
		this.expirationDate = expirationDate;
		this.payments = payments;
		this.userWorkout = userWorkout;
	}

	
}
