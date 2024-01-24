package com.springpeople.spring.jdbctemplate.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.springpeople.spring.jdbctemplate.entity.Student;

@Component
public class StudentDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public StudentDao(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	public void insertStudentDetails(Student student) {
		String sql = "INSERT INTO STUDENT (STUDENTID, STUDENTNAME) VALUES (?, ?)";
		int res = jdbcTemplate.update(sql, student.getStudentId(), student.getStudentName());
		
		if(res > 0) {
			System.out.println("Student details added");
		} else
			System.out.println("Unable to insert data");
	}
}
