package com.springpeople.spring.boot.SpringBootNamedQueriesDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpeople.spring.boot.SpringBootNamedQueriesDemo.entity.Users;
import com.springpeople.spring.boot.SpringBootNamedQueriesDemo.service.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsresController {

	@Autowired
	private UsersService service;
	
	@GetMapping("/status/{status}")
	public List<Users> listAllUsersByStatus(@PathVariable String status) {
		return service.getAllUsersByStatus(status);
	}
	
	@GetMapping("/salary/{min}/{max}")
	public List<Users> getAllUsersWithSalaryBetween(@PathVariable double min, @PathVariable double max) {
		return service.getAllBySalaryBetween(min, max);
	}
	
	@GetMapping("/phone/{ph}")
	public Users getUserByPhone(@PathVariable String ph) {
		return service.getUserByPhone(ph);
	}
	
	@GetMapping("/{id}")
	public Optional<Users> getUserDetails(@PathVariable long id) {
		return service.getUserById(id);
	}
	
	@PostMapping
	public Users createUser(@RequestBody Users user) {
		return service.saveUser(user);
	}
	
	@GetMapping
	public List<Users> getAllUsers() {
		return service.listAllUsers();
	}
	
	@GetMapping("/email/{email}")	
	public Users getByEmail(@PathVariable String email) {
		return service.getUserByEmail(email);
	}
	
}
