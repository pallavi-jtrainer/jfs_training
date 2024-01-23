package com.springpeople.hibernate.mapping.HibernateMappingDemo.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			try {
				registry = new StandardServiceRegistryBuilder().configure().build();
			
				MetadataSources sources = new MetadataSources(registry);
				
				Metadata metadata = sources.getMetadataBuilder().build();
				
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			}catch (Exception e) {
				e.printStackTrace();
				if(registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		
		return sessionFactory;
	}
	
	public static void shutdown() {
		if(registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
//	private static SessionFactory sessionFactory;
//	
//	private static SessionFactory buildSessionFactory() {
//		try {
//			Configuration config = new Configuration();
//			config.configure("hibernate.cfg.xml");
//			
//			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
//			sessionFactory = config.buildSessionFactory(serviceRegistry);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return sessionFactory;
//	}
//	
//	public static SessionFactory getSessionFactory() {
//		return buildSessionFactory();
//	}
}
