package com.springpeople.spring.di.SpringDiDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springpeople.spring.di.SpringDiDemo.model.Books;

@Configuration
@ComponentScan(value="com.springpeople.spring.di.SpringDiDemo")
public class AppConfig {

	@Bean
	public Books getBook() {
		return new Books(12, "Jack Reacher", 250.00);
	}
}
