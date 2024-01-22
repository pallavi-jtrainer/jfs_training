package com.springpeople.hibernate.HibernateEntityManagerDemo.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtility {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void close() {
		emf.close();
	}
}
