package com.springpeople.criteria.HibernateCriteriaQueryDemo;

import java.util.List;

import com.springpeople.criteria.HibernateCriteriaQueryDemo.dao.EmployeeDao;
import com.springpeople.criteria.HibernateCriteriaQueryDemo.entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        Employee e1 = new Employee("Prithvi", "Raj", 25600);
//        Employee e2 = new Employee("Upasana", "R", 23450);
//        
//        EmployeeDao.uploadEmployeeDetails(e1);
//        EmployeeDao.uploadEmployeeDetails(e2);
        
        List<Employee> employees = EmployeeDao.listAll();
        
        for(Employee e: employees) {
        	System.out.println(e.toString());
        }
    }
}
