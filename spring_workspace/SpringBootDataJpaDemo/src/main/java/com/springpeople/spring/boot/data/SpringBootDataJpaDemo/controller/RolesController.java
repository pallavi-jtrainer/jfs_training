package com.springpeople.spring.boot.data.SpringBootDataJpaDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springpeople.spring.boot.data.SpringBootDataJpaDemo.entity.Roles;
import com.springpeople.spring.boot.data.SpringBootDataJpaDemo.service.RolesService;

@RestController
@RequestMapping("/roles")
public class RolesController {

	@Autowired
	private RolesService service;
	
	@GetMapping
	public ResponseEntity<List<Roles>> listAllRoles() {
		return ResponseEntity.ok(service.listAll());
	}
	
	@PostMapping
//	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PATCH}, produces = "application/json")
	public ResponseEntity<Roles> createRole(@RequestBody Roles role) {
		return ResponseEntity.ok(service.createRole(role));
	}
}
