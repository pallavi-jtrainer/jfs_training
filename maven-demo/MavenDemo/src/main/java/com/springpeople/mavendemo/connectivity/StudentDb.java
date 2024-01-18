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

public class StudentDb {
	private static int getLastRow() {
		int id = 0;
		Connection con = DbConnect.createConnection();
		
		if(con != null) {
			String sql = "SELECT * FROM STUDENTS ORDER BY STUDENT_ID DESC LIMIT 1";
			
			try {
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				
				while(rs.next() != false) {
					id = rs.getInt("STUDENT_ID");
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return id;
	}
	
	public static String registerStudent(Students s, int courseId) {
		int res = 0;
		String str = "Unable to register student";
		
		String sql = "INSERT INTO STUDENTS VALUES (?, ?, ?)";
		
		String sql1 = "INSERT INTO STUDENT_COURSE VALUES (?, ?)";
		
		Connection con = DbConnect.createConnection();
		
		if(con != null) {
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				int id = getLastRow();
				if (id == 0) {
					id = 1;
				} else {
					++id;
				}
				
				ps.setInt(1, id);
				ps.setString(2, s.getStudentName());
				ps.setString(3, s.getEmail());
				
				PreparedStatement ps1 = con.prepareStatement(sql1);
				ps1.setInt(1, id);
				ps1.setInt(2, courseId);
				
				
				res = ps.executeUpdate();
				
				if(res > 0) {
					int ans = ps1.executeUpdate();
					if(ans > 0) {
						str = "Student registered successfully. Happy Learning";
					}
				}
				con.close();
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return str;
		
	}
	
	public static List<Courses> listAllCoursesForStudent(int id) {
		String sql = "SELECT C.COURSE_ID, C.COURSE_NAME FROM STUDENTS S, "
				+ "STUDENT_COURSE SC, COURSES C WHERE SC.STUDENT_ID = S.STUDENT_ID AND SC.COURSE_ID = C.COURSE_ID "
				+ "AND S.STUDENT_ID = ?";
		
		Connection con = DbConnect.createConnection();
		List<Courses> courses = new ArrayList<Courses>();
		
		if(con != null) {
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next() != false) {
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
	public static String getStudentName(int id) {
		String sql = "SELECT STUDENT_NAME FROM STUDENTS WHERE STUDENT_ID = ?";
		
		Connection con = DbConnect.createConnection();
		String name = null;
		if(con != null) {
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next() != false) {
					name = rs.getString("STUDENT_NAME");
				}
				
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return name;
	}
}
