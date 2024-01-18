package com.springpeople.mavendemo.connectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.springpeople.mavendemo.entity.Courses;
import com.springpeople.mavendemo.entity.Students;

public class CoursesDb {

	public static List<Courses> listAllCourses() {
		String sql = "SELECT * FROM COURSES";
		List<Courses> courses = new ArrayList<Courses>();
		
		Connection con = DbConnect.createConnection();
		
		if(con != null) {
			try {
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				
				while(rs.next()) {
					Courses c = new Courses();
					c.setCourseId(rs.getInt("COURSE_ID"));
					c.setCourseName(rs.getString("COURSE_NAME"));
					courses.add(c);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return courses;
	}
	
	public static List<Students> listAllStudentsForCourse(int courseId) {
		String sql = "SELECT S.STUDENT_ID, S.STUDENT_NAME, S.EMAIL FROM STUDENTS S, "
				+ "STUDENT_COURSE SC, COURSES C WHERE SC.STUDENT_ID = S.STUDENT_ID AND SC.COURSE_ID = C.COURSE_ID "
				+ "AND C.COURSE_ID = ?";
		
		Connection con = DbConnect.createConnection();
		List<Students> students = new ArrayList<Students>();
		
		if(con != null) {
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, courseId);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next() != false) {
					Students s = new Students();
					s.setStudentId(rs.getInt("STUDENT_ID"));
					s.setStudentName(rs.getString("STUDENT_NAME"));
					s.setEmail(rs.getString("EMAIL"));
					
					students.add(s);
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
			
	}
	
	public static String getCourseName(int id) {
		String sql = "SELECT COURSE_NAME FROM COURSES WHERE COURSE_ID = ?";
		
		Connection con = DbConnect.createConnection();
		String coursename = null;
		if(con != null) {
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next() != false) {
					coursename = rs.getString("COURSE_NAME");
				}
				
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return coursename;
	}
}
