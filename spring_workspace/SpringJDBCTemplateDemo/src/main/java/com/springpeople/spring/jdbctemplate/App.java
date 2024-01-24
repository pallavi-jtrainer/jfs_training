package com.springpeople.spring.jdbctemplate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springpeople.spring.jdbctemplate.config.AppConfig;
import com.springpeople.spring.jdbctemplate.dao.StudentDao;
import com.springpeople.spring.jdbctemplate.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	StudentDao dao = context.getBean(StudentDao.class);
    	
    	Student s = new Student(2, "Student 2");
    	dao.insertStudentDetails(s);
    	
    	context.close();
    }
}
