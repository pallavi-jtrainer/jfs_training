package com.springpeople.hibernate.mapping.OneToOneMappingDemo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_details")
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int id;
	
	@Column(name="pan", length=10, nullable = false, unique = true)
	private String pan;
	
	@Column(name="phone", length=10, nullable=false, unique=true)
	private String phone;
	
	@Column(name="salary", nullable=false)
	private double salary;
	
	@Column(name="hiring_date", nullable=false)
	private LocalDate hiringDate;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	public EmployeeDetails() {}
	
	public EmployeeDetails(String pan, String phone, double salary, LocalDate hiringDate) {
		this.pan = pan;
		this.phone = phone;
		this.salary = salary;
		this.hiringDate = hiringDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(LocalDate hiringDate) {
		this.hiringDate = hiringDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", pan=" + pan + ", phone=" + phone + ", salary=" + salary
				+ ", hiringDate=" + hiringDate + ", employee=" + employee + "]";
	}
	
	
}
