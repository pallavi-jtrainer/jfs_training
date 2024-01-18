package com.springpeople.mavendemo.entity;

import java.util.Objects;

public class Courses {

	private int courseId;
	private String courseName;
	
	public int getCourseId() {
		return courseId;
	}
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public Courses() {}
	
	public Courses(int courseId, String courseName) {
		this.courseId = courseId;
		this.courseName = courseName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseId, courseName);
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
		return courseId == other.courseId && Objects.equals(courseName, other.courseName);
	}

	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + "]";
	}
}
