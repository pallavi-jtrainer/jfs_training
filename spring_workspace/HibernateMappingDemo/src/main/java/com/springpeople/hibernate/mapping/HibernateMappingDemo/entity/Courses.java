package com.springpeople.hibernate.mapping.HibernateMappingDemo.entity;

import java.util.Objects;
import java.util.Set;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

public class Courses {
	private long id;
	private String courseName;
	private Set<Student> students;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(courseName, id, students);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Courses other = (Courses) obj;
		return Objects.equals(courseName, other.courseName) && id == other.id
				&& Objects.equals(students, other.students);
	}
	
	public Courses() {}
	
	public Courses(String courseName) {
		this.courseName = courseName;
	}
}
