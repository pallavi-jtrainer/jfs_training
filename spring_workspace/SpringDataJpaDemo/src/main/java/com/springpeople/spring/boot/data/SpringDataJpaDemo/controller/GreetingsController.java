package com.springpeople.spring.boot.data.SpringDataJpaDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	@GetMapping("/greetings/{user}")
	public String getGreetings(@PathVariable String user) {
		return "Hello " + user;
	}
}
