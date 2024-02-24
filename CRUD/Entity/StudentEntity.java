package com.Student.CRUD.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student_details")
public class StudentEntity {
	private long id;
	private String first_name;
	private String last_name;
	private double marks;
	private String email;
	
	public StudentEntity(){}
	
	public StudentEntity(long id,String first_name,String last_name,double marks,String email)
	{
		this.id=id;
		this.first_name=first_name;
		this.last_name=last_name;
		this.marks=marks;
		this.email=email;
	}

	@Id
	@GeneratedValue(strategy=jakarta.persistence.GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="first_name")
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	@Column(name="last_name")
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Column(name="marks")
	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	@Column(name="email", unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
