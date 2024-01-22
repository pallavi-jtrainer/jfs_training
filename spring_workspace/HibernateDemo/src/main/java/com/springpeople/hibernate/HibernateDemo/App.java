package com.springpeople.hibernate.HibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.springpeople.hibernate.HibernateDemo.dao.ProductsDao;
import com.springpeople.hibernate.HibernateDemo.entity.Products;
import com.springpeople.hibernate.HibernateDemo.utils.HibernateUtil;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ProductsDao.updateProduct(2, 125.00);
//        Products p1 = new Products(5, "Blue Ball Point Pens", 10.00);
//        Products p2 = new Products(6, "Black Ball Point Pens", 10.00);
        
//        Transaction tx = null; // only ddl and dml statemetns
        
//        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
////        	tx = session.beginTransaction();
//        	
////        	session.persist(p1);
////        	session.persist(p2);
//        	
////        	tx.commit();
//        	
//        	List<Products> products = session.createQuery("from Products", Products.class).list();
//        	products.forEach(p -> System.out.println(p.toString()));
//        	
//        	
//        } catch (Exception e) {
////        	if(tx != null) {
////        		tx.rollback();
////        	}
//        	
//        	e.printStackTrace();
//        }
//        
    	
    	
    }
}
