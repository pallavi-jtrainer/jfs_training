package com.springpeople.spring.jdbctemplate.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(value="com.springpeople.spring.jdbctemplate")
//@PropertySource("classpath:database.properties")
public class AppConfig {
	private final String URL = "jdbc:mysql://localhost:3306/mappingdb";
	private final String USER = "root";
	private final String PASSWORD = "Pass1234";
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
//	@Autowired
//	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManager = new DriverManagerDataSource();
		driverManager.setDriverClassName(DRIVER);
		driverManager.setUrl(URL);
		driverManager.setUsername(USER);
		driverManager.setPassword(PASSWORD);
		
		return driverManager;
	}
}
