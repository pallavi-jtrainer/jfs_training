package com.springpeople.hibernate.mapping.OneToOneMappingDemo.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("persistence");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void close() {
		emf.close();
	}
}
