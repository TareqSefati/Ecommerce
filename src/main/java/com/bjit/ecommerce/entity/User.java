package com.bjit.ecommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_first_name")
	@Size(min=3, max=30, message="First Name should be between 3 and 30 characters long.")
	private String userFirstName;
	
	@Column(name="user_last_name")
	@Size(min=3, max=30, message="Last Name should be between 3 and 30 characters long.")
	private String userLastName;
	
	@Column(name="user_email")
	@Email(message="Please provide a valid Email.")
	@Size(min=5, max=255, message="Email should be between 5 and 255 characters long.")
	private String userEmail;
	
	@Column(name="user_password")
	@Size(min=6, message="Password should be minimum 6 characters long.")
	private String userPassword;
	
	@Column(name="user_contact_number")
	@Size(min=5, max=20, message="Contact number should be between 8 and 20 characters long.")
	private String userContactNumber;
	
	@Column(name="user_status")
	@NotNull
	private String userStatus;
	
	@Column(name="user_billing_address")
	@NotNull(message="User billing address is required.")
	private String userBillingAddress;
	
	@Column(name="user_billing_city")
	@NotNull(message="User billing city is required.")
	private String userBillingCity;
	
	@Column(name="user_billing_country")
	@NotNull
	private int userBillingCountry;
	
	@Column(name="user_billing_zipcode")
	@NotNull(message="User billing zipcode is required.")
	private String userBillingZipcode;
	
	@Column(name="user_shipping_address")
	@NotNull(message="User Shipping address is required.")
	private String userShippingAddress;
	
	@Column(name="user_shipping_city")
	@NotNull(message="User Shipping city is required.")
	private String userShippingCity;
	
	@Column(name="user_shipping_country")
	@NotNull
	private int userShippingCountry;
	
	@Column(name="user_shipping_zipcode")
	@NotNull(message="User Shipping zipcode is required.")
	private String userShippingZipcode;
	
	@Column(name="user_created_on")
	private Date userCreatedOn;
	
	@Column(name="user_updated_on")
	private Date userUpdatedOn;
	
	
	@PrePersist
	public void prePersist() {
		this.userCreatedOn = new Date();
		this.userUpdatedOn = new Date();
	}
	
	@PreUpdate
	public void preUpdate() {
		this.userUpdatedOn = new Date();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserContactNumber() {
		return userContactNumber;
	}

	public void setUserContactNumber(String userContactNumber) {
		this.userContactNumber = userContactNumber;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserBillingAddress() {
		return userBillingAddress;
	}

	public void setUserBillingAddress(String userBillingAddress) {
		this.userBillingAddress = userBillingAddress;
	}

	public String getUserBillingCity() {
		return userBillingCity;
	}

	public void setUserBillingCity(String userBillingCity) {
		this.userBillingCity = userBillingCity;
	}

	public int getUserBillingCountry() {
		return userBillingCountry;
	}

	public void setUserBillingCountry(int userBillingCountry) {
		this.userBillingCountry = userBillingCountry;
	}

	public String getUserBillingZipcode() {
		return userBillingZipcode;
	}

	public void setUserBillingZipcode(String userBillingZipcode) {
		this.userBillingZipcode = userBillingZipcode;
	}

	public String getUserShippingAddress() {
		return userShippingAddress;
	}

	public void setUserShippingAddress(String userShippingAddress) {
		this.userShippingAddress = userShippingAddress;
	}

	public String getUserShippingCity() {
		return userShippingCity;
	}

	public void setUserShippingCity(String userShippingCity) {
		this.userShippingCity = userShippingCity;
	}

	public int getUserShippingCountry() {
		return userShippingCountry;
	}

	public void setUserShippingCountry(int userShippingCountry) {
		this.userShippingCountry = userShippingCountry;
	}

	public String getUserShippingZipcode() {
		return userShippingZipcode;
	}

	public void setUserShippingZipcode(String userShippingZipcode) {
		this.userShippingZipcode = userShippingZipcode;
	}

	public Date getUserCreatedOn() {
		return userCreatedOn;
	}

	public void setUserCreatedOn(Date userCreatedOn) {
		this.userCreatedOn = userCreatedOn;
	}

	public Date getUserUpdatedOn() {
		return userUpdatedOn;
	}

	public void setUserUpdatedOn(Date userUpdatedOn) {
		this.userUpdatedOn = userUpdatedOn;
	}

	
	
	public User(int userId, String userFirstName, String userLastName, String userEmail, String userPassword,
			String userContactNumber, String userStatus, String userBillingAddress, String userBillingCity,
			int userBillingCountry, String userBillingZipcode, String userShippingAddress, String userShippingCity,
			int userShippingCountry, String userShippingZipcode, Date userCreatedOn, Date userUpdatedOn) {
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userContactNumber = userContactNumber;
		this.userStatus = userStatus;
		this.userBillingAddress = userBillingAddress;
		this.userBillingCity = userBillingCity;
		this.userBillingCountry = userBillingCountry;
		this.userBillingZipcode = userBillingZipcode;
		this.userShippingAddress = userShippingAddress;
		this.userShippingCity = userShippingCity;
		this.userShippingCountry = userShippingCountry;
		this.userShippingZipcode = userShippingZipcode;
		this.userCreatedOn = userCreatedOn;
		this.userUpdatedOn = userUpdatedOn;
	}
	
	

	public User() {
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userContactNumber="
				+ userContactNumber + ", userStatus=" + userStatus + ", userBillingAddress=" + userBillingAddress
				+ ", userBillingCity=" + userBillingCity + ", userBillingCountry=" + userBillingCountry
				+ ", userBillingZipcode=" + userBillingZipcode + ", userShippingAddress=" + userShippingAddress
				+ ", userShippingCity=" + userShippingCity + ", userShippingCountry=" + userShippingCountry
				+ ", userShippingZipcode=" + userShippingZipcode + ", userCreatedOn=" + userCreatedOn
				+ ", userUpdatedOn=" + userUpdatedOn + "]";
	}
}


















