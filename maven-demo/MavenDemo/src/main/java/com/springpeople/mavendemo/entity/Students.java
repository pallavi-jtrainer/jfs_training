package com.springpeople.mavendemo.entity;

import java.util.Objects;

public class Students {
	private int studentId;
	private String studentName;
	private String email;
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Students() {}

	public Students(int studentId, String studentName, String email) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, studentId, studentName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		return Objects.equals(email, other.email) && studentId == other.studentId
				&& Objects.equals(studentName, other.studentName);
	}

	@Override
	public String toString() {
		return "Students [studentId=" + studentId + ", studentName=" + studentName + ", email=" + email + "]";
	}
	
	
	
}
