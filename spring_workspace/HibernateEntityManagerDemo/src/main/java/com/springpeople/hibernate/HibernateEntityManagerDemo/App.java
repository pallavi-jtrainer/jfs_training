package com.springpeople.hibernate.HibernateEntityManagerDemo;

import com.springpeople.hibernate.HibernateEntityManagerDemo.dao.EmployeeDao;
import com.springpeople.hibernate.HibernateEntityManagerDemo.entity.Employee;
import com.springpeople.hibernate.HibernateEntityManagerDemo.utils.JPAUtility;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        Employee e = new Employee("Prithvi", "Raj", "pr@cn.c", 23456.00);
//        
//        EmployeeDao.createEmployee(e);
    	EmployeeDao.updateEmployee(1, 34567.00);
    	EmployeeDao.retrieveAllEmployees();
    	
    	JPAUtility.close();
        
    }
}
