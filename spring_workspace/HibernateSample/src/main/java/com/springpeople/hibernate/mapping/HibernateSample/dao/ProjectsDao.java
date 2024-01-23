package com.springpeople.hibernate.mapping.HibernateSample.dao;

import java.util.List;

import com.springpeople.hibernate.mapping.HibernateSample.entity.Employee;
import com.springpeople.hibernate.mapping.HibernateSample.entity.Projects;
import com.springpeople.hibernate.mapping.HibernateSample.utils.JpaUtils;

import jakarta.persistence.EntityManager;
//import jakarta.persistence.Query;

public class ProjectsDao {

	public static void createProject(Projects project) {
		EntityManager em = JpaUtils.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(project);
		
		em.getTransaction().commit();
	}
	
	public static List<Projects> listAllProjects() {
		EntityManager em = JpaUtils.getEntityManager();
		
		List<Projects> projects = em.createQuery("from Projects", Projects.class).getResultList();
		return projects;
	}
	
	public static Projects getEmployeesListForProject(long id) {
		Projects project = new Projects();
		
		EntityManager em = JpaUtils.getEntityManager();
		Employee e = new Employee();
	//	long pId = e.getProjects().getId();
		
		List<Employee> employees = em.createQuery("Select e from Employee e where e.getProjects().getId()=" 
				+ id, Employee.class).getResultList(); 
		
		project.setEmployees(employees);
		
		return project;
	}
}
