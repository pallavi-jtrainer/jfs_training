package com.springpeople.hibernate.mapping.HibernateSample.dao;

import com.springpeople.hibernate.mapping.HibernateSample.entity.Employee;
import com.springpeople.hibernate.mapping.HibernateSample.entity.Projects;
import com.springpeople.hibernate.mapping.HibernateSample.utils.JpaUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class EmployeeDao {
	
	public static void createEmployee(Employee e) {
		EntityManager em = JpaUtils.getEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public static void updateProjectDetails(long id, long pId) {
		EntityManager em = JpaUtils.getEntityManager();
		em.getTransaction().begin();
		
		Employee e = em.find(Employee.class, id);
		Projects p = em.find(Projects.class, pId);
		
		e.setProjects(p);
//		Query query =  em.createQuery("update Employee e set e.project_id="  
//				+ pId + " where e.employeeId=" + id);
//		int res = query.executeUpdate();
		
		em.getTransaction().commit();
//		if(res > 0) {
//			System.out.println("Employee updated");
//		} else {
//			System.out.println("update unsuccessfull");
//		}
	}
}
