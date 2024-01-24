package com.springpeople.hibernate.mapping.OneToOneMappingDemo.dao;

import com.springpeople.hibernate.mapping.OneToOneMappingDemo.entity.EmployeeDetails;
import com.springpeople.hibernate.mapping.OneToOneMappingDemo.utils.HibernateUtil;

import jakarta.persistence.EntityManager;

public class EmployeeDetailsDao {

	public static void addEmployeeDetails(EmployeeDetails ed) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(ed);
		em.getTransaction().commit();
	}
	
	public static void updateEmployeeDetails(EmployeeDetails e) {}
	
	public static void getEmployeeDetails(int id) {}
}
