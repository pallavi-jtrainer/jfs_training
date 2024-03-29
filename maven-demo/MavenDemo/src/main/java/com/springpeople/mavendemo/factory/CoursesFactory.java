package com.springpeople.mavendemo.factory;

import java.util.List;

import com.springpeople.mavendemo.connectivity.CoursesDb;
import com.springpeople.mavendemo.entity.Courses;
import com.springpeople.mavendemo.entity.Students;

public class CoursesFactory {

	public static List<Courses> listAll() {
		List<Courses> courses = CoursesDb.listAllCourses();
		return courses;
	}
	
	public static List<Students> listAllStudentsForCourse(int id) {
		List<Students> students = CoursesDb.listAllStudentsForCourse(id);
		return students;
	}
	
	public static String getCourseName(int id) {
		return CoursesDb.getCourseName(id);
	}
}
