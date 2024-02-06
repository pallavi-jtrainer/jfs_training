package com.springpeople.spring.boot.SpringBootBackEndForNg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpeople.spring.boot.SpringBootBackEndForNg.entity.Student;
import com.springpeople.spring.boot.SpringBootBackEndForNg.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public List<Student> listAllStudents() {
		return repo.findAll();
	}
	
	public Student getByStudentId(long id) {
		return repo.findByStudentId(id);
	}
	
	public Student getByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public Student createStudent(Student s) {
		return repo.save(s);
	}
	
	public String updatePassword(long id, String pass) {
		int res = repo.updatePassword(id, pass);
		
		if(res > 0) {
			return "Password updated successfully";
		} else
			return "Update unsuccessful";
	}
}
