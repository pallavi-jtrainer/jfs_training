package com.springpeople.mapping.HibernateManyToManyMappingDemo.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.springpeople.mapping.HibernateManyToManyMappingDemo.entity.Employee;
import com.springpeople.mapping.HibernateManyToManyMappingDemo.entity.Projects;

public class HibernateUtil {

private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			Configuration config = new Configuration();
			
			Properties props = new Properties();
			
			//db connection
			props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			props.put(Environment.URL, "jdbc:mysql://localhost:3306/slk_hibernate_db");
			props.put(Environment.USER, "root");
			props.put(Environment.PASS, "Pass1234");
			
			//hibernate properties
			props.put(Environment.SHOW_SQL, "true");
			props.put(Environment.HBM2DDL_AUTO, "update");
			
			config.setProperties(props);
			config.addAnnotatedClass(Employee.class);
			config.addAnnotatedClass(Projects.class);
			
			ServiceRegistry service = new StandardServiceRegistryBuilder()
					.applySettings(config.getProperties()).build();
			
			sessionFactory = config.buildSessionFactory();
			
		}
		
		return sessionFactory;
	}
}
