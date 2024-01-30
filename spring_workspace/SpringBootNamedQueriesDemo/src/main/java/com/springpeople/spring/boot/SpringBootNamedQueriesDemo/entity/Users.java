package com.springpeople.spring.boot.SpringBootNamedQueriesDemo.entity;

import java.util.Objects;

import com.springpeople.spring.boot.SpringBootNamedQueriesDemo.utils.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
//@NoArgsConstructor
////@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//@Data
//@NamedQuery(name = "Users.findByEmail", query = "select u from Users u where u.email = ?1")
@NamedQueries({
		@NamedQuery(name ="Users.findByEmail", 
				query = "select u from Users u where u.email = ?1"),
		@NamedQuery(name = "Users.findByUserPhone", 
				query = "select u from Users u where u.phone = ?1"),
		@NamedQuery(name = "Users.getUsersWithSalaryBetween",
				query = "select u from Users u where u.salary between ?1 and ?2")
})
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable=false, unique=true)
	private String email;
	
	@Column(name = "phone", nullable=false, unique = true)
	private String phone;
	
	@Column(name="salary")
	private double salary;
	
	@Enumerated(EnumType.STRING)
	private UserStatus status;

	public Users(String firstName, String lastName, String email, String phone, 
			double salary, UserStatus status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.status = status;
	}

	public UserStatus getStatus() {
		return status;
	}
	
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", salary=" + salary + ", status=" + status + "]";
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	

	public Users() {}
}
