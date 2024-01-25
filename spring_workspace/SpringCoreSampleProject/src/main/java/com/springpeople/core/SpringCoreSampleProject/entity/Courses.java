package com.springpeople.core.SpringCoreSampleProject.entity;

import org.springframework.stereotype.Component;

@Component
public class Courses {
	private int id;
	private String courseName;
	private Student s;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String name) {
		this.courseName = name;
	}
	
	public Student getS() {
		return s;
	}
	
	public void setS(Student s) {
		this.s = s;
	}
	
	public Courses(int id, String courseName, Student s) {
		this.id = id;
		this.courseName = courseName;
		this.s = s;
	}
	
	public Courses() {
		
	}
	
	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + courseName + ", s=" + s + "]";
	}
	
	
}
