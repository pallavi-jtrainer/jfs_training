package com.springpeople.spring.boot.SpringBootNamedQueriesDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpeople.spring.boot.SpringBootNamedQueriesDemo.entity.Users;
import com.springpeople.spring.boot.SpringBootNamedQueriesDemo.repository.UsersRepository;
import com.springpeople.spring.boot.SpringBootNamedQueriesDemo.utils.UserStatus;

@Service
public class UsersService {
	@Autowired
	private UsersRepository userRepository;
	
	public List<Users> getAllUsersByStatus(String status) {
		UserStatus stat = UserStatus.valueOf(status);
		return userRepository.findAllByStatus(stat);
	}
	
	public Users getUserByPhone(String ph) {
		return userRepository.findByUserPhone(ph);
	}
	
	public List<Users> listAllUsers() {
		return userRepository.findAll();
	}
	
	public Optional<Users> getUserById(long id) {
		
//		Users user = userRepository.getById(id);
		
		Optional<Users> user = userRepository.findById(id);
		return user;
	}
	
	public Users getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public Users saveUser(Users user) {
		return userRepository.save(user);
	}
	
	public List<Users> getAllBySalaryBetween(double min, double max) {
		return userRepository.getUsersWithSalaryBetween(min, max);
	}
}
