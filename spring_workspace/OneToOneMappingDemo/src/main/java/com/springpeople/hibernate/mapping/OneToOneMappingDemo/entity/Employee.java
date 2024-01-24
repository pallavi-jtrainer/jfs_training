package com.springpeople.hibernate.mapping.OneToOneMappingDemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int id;
	
	@Column(name="first_name", nullable = false, length=50)
	private String firstName;
	
	@Column(name="last_name", nullable=false, length=50)
	private String lastName;
	
	@Column(name="email", nullable = false, length=150, unique=true)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	private EmployeeDetails empDetails;
	
	public Employee() {}
	
	public Employee(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmployeeDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmployeeDetails empDetails) {
		this.empDetails = empDetails;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", empDetails=" + empDetails.toString() + "]";
	}
	
	
	
	
}
