package com.SpringBlood.SpringBloodApplication.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="registration_table")
public class RegistrationEntity {

	private long id;
	private String fullName;
	private String email;
	private long mobile;
	private String bloodGroup;
	private String dob;
	private String city;
	private String password;
	private String conPassword;
	
	public RegistrationEntity() {}
	
	public RegistrationEntity(long id,String fullName,String email,long mobile,String dob,String city,String password,String conPassword)
	{
		this.id=id;
		this.fullName=fullName;
		this.email=email;
		this.mobile=mobile;
		this.dob=dob;
		this.city=city;
		this.password=password;
		this.conPassword=conPassword;
	}
	
	
	@Id
	@GeneratedValue(strategy=jakarta.persistence.GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
@Column(name="fullName")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
@Column(name="email",unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

@Column(name="mobile")
	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
@Column(name="bloodGroup")
	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

@Column(name="DateOfBirth")
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

@Column(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

@Column(name="confirmPassword")
	public String getConPassword() {
		return conPassword;
	}

	public void setConPassword(String conPassword) {
		this.conPassword = conPassword;
	}
	
	
}






