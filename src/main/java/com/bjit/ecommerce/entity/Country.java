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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="country")
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="country_id")
	private int countryId;
	
	@Column(name="country_code")
	@NotEmpty(message="Country code can not be empty")
	private String countryCode;
	
	@Column(name="country_name")
	@NotEmpty(message="Country Name can not be empty")
	private String countryName;
	
	@Column(name="country_created_on")
	private Date countryCreatedOn;
	
	@Column(name="country_updated_on")
	private Date countryUpdatedOn;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Date getCountryCreatedOn() {
		return countryCreatedOn;
	}

	public void setCountryCreatedOn(Date countryCreatedOn) {
		this.countryCreatedOn = countryCreatedOn;
	}

	public Date getCountryUpdatedOn() {
		return countryUpdatedOn;
	}

	public void setCountryUpdatedOn(Date countryUpdatedOn) {
		this.countryUpdatedOn = countryUpdatedOn;
	}
	
	@PrePersist
	public void prePersist() {
		this.countryCreatedOn = new Date();
		this.countryUpdatedOn = new Date();
	}
	
	@PreUpdate
	public void preUpdate() {
		this.countryUpdatedOn = new Date();
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryCode=" + countryCode + ", countryName=" + countryName
				+ ", countryCreatedOn=" + countryCreatedOn + ", countryUpdatedOn=" + countryUpdatedOn + "]";
	}
}








