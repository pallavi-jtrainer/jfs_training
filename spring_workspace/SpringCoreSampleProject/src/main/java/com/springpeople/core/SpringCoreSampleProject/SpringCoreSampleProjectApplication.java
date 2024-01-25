package com.springpeople.core.SpringCoreSampleProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springpeople.core.SpringCoreSampleProject.entity.Courses;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SpringCoreSampleProjectApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringCoreSampleProjectApplication.class, args);
//	}
//
//}


public class SpringCoreSampleProjectApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		Courses course = ctx.getBean(Courses.class);
		System.out.println(course.getId());
		System.out.println(course.getCourseName());
		System.out.println(course.getS().toString());
		
	}
}