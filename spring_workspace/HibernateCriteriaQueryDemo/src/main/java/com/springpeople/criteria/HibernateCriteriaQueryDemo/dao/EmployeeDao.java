package com.springpeople.criteria.HibernateCriteriaQueryDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.springpeople.criteria.HibernateCriteriaQueryDemo.entity.Employee;
import com.springpeople.criteria.HibernateCriteriaQueryDemo.util.HibernateUtil;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class EmployeeDao {
	public static void uploadEmployeeDetails(Employee e) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(e);
		tx.commit();
		
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Employee> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
//		List<Employee> employees = session.createQuery(" from Employee", Employee.class).list();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		
		cq.select(root);
//		cq.select(root).where(cb.gt(root.get("salary"), 30000 ));
		Query query = session.createQuery(cq);
		List<Employee> employees = query.getResultList();
		
		session.close();
		
		return employees;
	}
	
	public static Employee getEmployeeDetails(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		
		cq.select(root).where(cb.equal(root.get("employeeId"), id));
				
		Query query = session.createQuery(cq);
		Employee e = (Employee) query.getSingleResult();
		session.close();
		return e;
	}
}
