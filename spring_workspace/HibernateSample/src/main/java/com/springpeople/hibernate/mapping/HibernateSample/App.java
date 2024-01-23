package com.springpeople.hibernate.mapping.HibernateSample;

import java.time.LocalDate;

import com.springpeople.hibernate.mapping.HibernateSample.dao.EmployeeDao;
import com.springpeople.hibernate.mapping.HibernateSample.dao.ProjectsDao;
import com.springpeople.hibernate.mapping.HibernateSample.entity.Employee;
import com.springpeople.hibernate.mapping.HibernateSample.entity.Projects;
import com.springpeople.hibernate.mapping.HibernateSample.utils.JpaUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	LocalDate l = LocalDate.now();
//    	
//    	l = l.plusMonths(2);
//        ProjectsDao.createProject(new Projects("Paychex_HR", LocalDate.now(), l));
//        
//        EmployeeDao.createEmployee(new Employee("Employee", "One", "emp1@fhfhf.c"));
    	
    	EmployeeDao.updateProjectDetails(1, 1);
        
        JpaUtils.close();
    }
}
