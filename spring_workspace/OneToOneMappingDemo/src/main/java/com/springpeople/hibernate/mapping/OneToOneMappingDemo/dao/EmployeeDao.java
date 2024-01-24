package com.springpeople.hibernate.mapping.OneToOneMappingDemo.dao;

import com.springpeople.hibernate.mapping.OneToOneMappingDemo.entity.Employee;
import com.springpeople.hibernate.mapping.OneToOneMappingDemo.entity.EmployeeDetails;
import com.springpeople.hibernate.mapping.OneToOneMappingDemo.utils.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class EmployeeDao {

	public static void viewEmployeeDetails(int id) {
		EntityManager em = HibernateUtil.getEntityManager();
		
		Employee e = em.find(Employee.class, id);
		EmployeeDetails ed = em.find(EmployeeDetails.class, id);
		
		e.setEmpDetails(ed);
		 
		System.out.println(e.toString());
		
	}
	
	public static void createEmployee(Employee e) {
		EntityManager em = HibernateUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public static void updateEmployeeEmail(Employee emp) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("update employee e set e.email = " + emp.getEmail()
				+ " where e.employee_id = " + emp.getId());
		
		int res = query.executeUpdate();
		
		em.getTransaction().commit();
		
		if(res > 0) {
			System.out.println("Email updated");
		} else {
			System.out.println("Update unsuccessful! Try later!");
		}
	}
	
	public static void viewAllEmployees() {}
	

}
