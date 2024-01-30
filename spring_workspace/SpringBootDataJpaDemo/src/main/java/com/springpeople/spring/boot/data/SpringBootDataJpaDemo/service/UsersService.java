package com.springpeople.spring.boot.data.SpringBootDataJpaDemo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpeople.spring.boot.data.SpringBootDataJpaDemo.entity.Roles;
import com.springpeople.spring.boot.data.SpringBootDataJpaDemo.entity.Users;
import com.springpeople.spring.boot.data.SpringBootDataJpaDemo.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository repo;
	
	public List<Users> listUsersByRole(String role) {
		return repo.findAllByRoleName(role);
	}
	
	public Users saveUser(Users user) {
		return repo.save(user);
	}
	
	public Users addRoleToUser(long id, Roles role) {
		Users user = repo.findById(id).get();
		Set<Roles> userRole = user.getRoles();
		userRole.add(role);
		
		user.setRoles(userRole);
		return repo.save(user);
	}
}
