package com.springpeople.mapping.HibernateManyToManyMappingDemo;

import com.springpeople.mapping.HibernateManyToManyMappingDemo.dao.EmployeeDao;
import com.springpeople.mapping.HibernateManyToManyMappingDemo.dao.ProjectsDao;
import com.springpeople.mapping.HibernateManyToManyMappingDemo.entity.Employee;
import com.springpeople.mapping.HibernateManyToManyMappingDemo.entity.Projects;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Projects p1 = new Projects("Course Management System");
        Projects p2 = new Projects("Ticket Management System");
        
        Employee e1 = new Employee("Prithvi", "Raj");
        Employee e2 = new Employee("Komal", "Ravindra");
        
        e1.getProjects().add(p1);
        e1.getProjects().add(p2);
        
        e2.getProjects().add(p1);
        
        EmployeeDao.saveEmployeeDetails(e1);
        EmployeeDao.saveEmployeeDetails(e2);
        
//        ProjectsDao.saveProjectInfo(p1);
//        ProjectsDao.saveProjectInfo(p1);
    }
}
