package com.springpeople.hibernate.mapping.OneToOneMappingDemo;

import java.time.LocalDate;

import com.springpeople.hibernate.mapping.OneToOneMappingDemo.dao.EmployeeDao;
import com.springpeople.hibernate.mapping.OneToOneMappingDemo.dao.EmployeeDetailsDao;
import com.springpeople.hibernate.mapping.OneToOneMappingDemo.entity.Employee;
import com.springpeople.hibernate.mapping.OneToOneMappingDemo.entity.EmployeeDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Employee emp = new Employee("Prithvi", "Raj", "pr121@djj.c");
        EmployeeDetails ed = new EmployeeDetails("ATWP12121S", "329292111", 34292.00, LocalDate.now());
        emp.setEmpDetails(ed);
        ed.setEmployee(emp);
        
        EmployeeDao.createEmployee(emp);
      //  EmployeeDetailsDao.addEmployeeDetails(ed);
       
        
    }
}
