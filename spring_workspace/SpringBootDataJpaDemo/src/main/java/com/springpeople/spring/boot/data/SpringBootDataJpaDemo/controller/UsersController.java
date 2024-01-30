package com.springpeople.spring.boot.data.SpringBootDataJpaDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springpeople.spring.boot.data.SpringBootDataJpaDemo.entity.Roles;
import com.springpeople.spring.boot.data.SpringBootDataJpaDemo.entity.Users;
import com.springpeople.spring.boot.data.SpringBootDataJpaDemo.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService service;

	
//	public UsersController(UsersService service) {
//		this.service = service;
//	}
	
	/**
	 * 
	 * @param roletype
	 * @return
	 */
	
	
	@GetMapping
	public ResponseEntity<List<Users>> getUsers(@RequestParam String roletype){
		return ResponseEntity.ok(service.listUsersByRole(roletype));
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	
	@PostMapping("/save")
	public ResponseEntity<Users> saveUser(@RequestBody Users user){
		return ResponseEntity.ok(service.saveUser(user));
	}
	
	
	/**
	 * 
	 * @param userid
	 * @param role
	 */
	
	@PutMapping("/addrole/{userid}")
	public Users addRoleToUser(@PathVariable long userid,@RequestBody Roles role) {
		return service.addRoleToUser(userid,role);
	}
	
	
	
}
