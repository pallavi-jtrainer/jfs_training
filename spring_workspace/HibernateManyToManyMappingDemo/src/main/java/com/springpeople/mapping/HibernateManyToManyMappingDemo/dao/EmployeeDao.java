package com.springpeople.mapping.HibernateManyToManyMappingDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.springpeople.mapping.HibernateManyToManyMappingDemo.entity.Employee;
import com.springpeople.mapping.HibernateManyToManyMappingDemo.entity.Projects;
import com.springpeople.mapping.HibernateManyToManyMappingDemo.util.HibernateUtil;

import jakarta.persistence.Query;

public class EmployeeDao {

	public static void saveEmployeeDetails(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Employee e = session.merge(employee);
		
		session.persist(e);
		transaction.commit();
		
		session.close();
	}
	
	public static Employee getEmployeeDetails(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Employee e = session.get(Employee.class, id);
		session.close();
		return e;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static List<Projects> getProjectsOfEmployee(long id) {
		String hql = " from Projects p where p.projectId in " 
				+ "(select projectId from projects_employee pe where pe.employeeId = :id)";
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		
		List<Projects> projects = query.getResultList();
		session.close();
		return projects;
	}
	
}
