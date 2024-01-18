package com.springpeople.mavendemo.factory;

import java.util.List;

import com.springpeople.mavendemo.connectivity.StudentDb;
import com.springpeople.mavendemo.entity.Courses;
import com.springpeople.mavendemo.entity.Students;

public class StudentsFactory {
	public static String registerStudent(Students s, int courseId) {
		String str = StudentDb.registerStudent(s, courseId);
		return str;
	}
	
	public static List<Courses> listAllCoursesForStudent(int id) {
		return StudentDb.listAllCoursesForStudent(id);
	}
	
	public static String getStudentName(int id) {
		return StudentDb.getStudentName(id);
	}
}
