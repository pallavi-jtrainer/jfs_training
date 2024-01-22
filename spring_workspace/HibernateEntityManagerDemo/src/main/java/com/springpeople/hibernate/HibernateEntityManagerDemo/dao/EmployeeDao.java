package com.springpeople.hibernate.HibernateEntityManagerDemo.dao;

import java.util.List;

import com.springpeople.hibernate.HibernateEntityManagerDemo.entity.Employee;
import com.springpeople.hibernate.HibernateEntityManagerDemo.utils.JPAUtility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class EmployeeDao {

	public static void updateEmployee(int id, double sal) {
		EntityManager em = JPAUtility.getEntityManager();
		
		em.getTransaction().begin();
		Employee emp = em.find(Employee.class, id);
		
		emp.setSalary(sal);
		em.getTransaction().commit();
		
//		JPAUtility.close();
		
	}
	
	public static void createEmployee(Employee e) {
		EntityManager em = JPAUtility.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(e);
		em.getTransaction().commit();
	//	JPAUtility.close();
	}
	
	public static void retrieveAllEmployees() {
		EntityManager em = JPAUtility.getEntityManager();
		
		Query query = em.createQuery("Select e from Employee e");
		@SuppressWarnings("unchecked")
		List<Employee> employees = query.getResultList();
		
		if(employees.size() == 0) {
			System.out.println("No Employees");
		} else {
			employees.forEach(emp -> System.out.println(emp.toString()));
		}
		
	//	JPAUtility.close();
	}
	
}
