package com.springpeople.hibernate.mapping.HibernateMappingDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springpeople.hibernate.mapping.HibernateMappingDemo.entity.Courses;
import com.springpeople.hibernate.mapping.HibernateMappingDemo.entity.Student;
import com.springpeople.hibernate.mapping.HibernateMappingDemo.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Courses c = new Courses("Java Essentials");
        
        
        Transaction tx = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        try{
        	tx = session.beginTransaction();
        	
        	session.persist(c);
        	
        	tx.commit();
        }catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
