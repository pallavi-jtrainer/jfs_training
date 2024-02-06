package com.springpeople.spring.boot.SpringBootBackEndForNg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpeople.spring.boot.SpringBootBackEndForNg.entity.Student;
import com.springpeople.spring.boot.SpringBootBackEndForNg.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping
	public ResponseEntity<List<Student>> listAll() {
		return ResponseEntity.ok(service.listAllStudents());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getById(@PathVariable long id) {
		return ResponseEntity.ok(service.getByStudentId(id));
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Student> getByEmail(@PathVariable String email) {
		return ResponseEntity.ok(service.getByEmail(email));
	}
	
	@PostMapping
	public ResponseEntity<Student> postStudent(Student s) {
		return ResponseEntity.ok(service.createStudent(s));
	}
	
	@PutMapping("/pass/{id}/{pass}")
	public ResponseEntity<String> updatePassword(@PathVariable long id, @PathVariable String pass) {
		return ResponseEntity.ok(service.updatePassword(id, pass));
	}	
}
