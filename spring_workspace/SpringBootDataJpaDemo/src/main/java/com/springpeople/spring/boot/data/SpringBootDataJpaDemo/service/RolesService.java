package com.springpeople.spring.boot.data.SpringBootDataJpaDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpeople.spring.boot.data.SpringBootDataJpaDemo.entity.Roles;
import com.springpeople.spring.boot.data.SpringBootDataJpaDemo.repository.RolesRepository;

@Service
public class RolesService {
	@Autowired
	private RolesRepository repo;
	
	public List<Roles> listAll() {
		return repo.findAll();
	}
	
	public Roles createRole(Roles role) {
		return repo.save(role);
	}
}
