package com.springpeople.mapping.HibernateManyToManyMappingDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.springpeople.mapping.HibernateManyToManyMappingDemo.entity.Employee;
import com.springpeople.mapping.HibernateManyToManyMappingDemo.entity.Projects;
import com.springpeople.mapping.HibernateManyToManyMappingDemo.util.HibernateUtil;

import jakarta.persistence.Query;
 
public class ProjectsDao {
	public static void saveProjectInfo(Projects p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		session.persist(p);
		transaction.commit();
		session.close();
	}
	
	public static Projects getProjectDetails(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Projects project = session.get(Projects.class, id);
		session.close();
		
		return project;
	}
	
	public static List<Employee> listOfEmployeesInProject(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = " from Employee e where e.employeeId in ("
				+ "select pe.projectId from projects_employee pe where pe.projectId = :id)";
		
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		
		List<Employee> employees = query.getResultList();
		session.close();
		return employees;
	} 
}
