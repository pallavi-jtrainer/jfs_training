package com.springpeople.criteria.HibernateCriteriaQueryDemo.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			
			registry = new StandardServiceRegistryBuilder().configure().build();
			
			MetadataSources sources = new MetadataSources(registry);
			
			Metadata data = sources.getMetadataBuilder().build();
			sessionFactory = data.getSessionFactoryBuilder().build();
			
		}
		
		return sessionFactory;
	}
	
	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
