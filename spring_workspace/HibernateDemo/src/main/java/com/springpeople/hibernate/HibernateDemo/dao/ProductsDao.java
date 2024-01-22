package com.springpeople.hibernate.HibernateDemo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.query.Query;

import com.springpeople.hibernate.HibernateDemo.utils.HibernateUtil;

import jakarta.persistence.Query;

public class ProductsDao {
	
	public static void updateProduct(int id, double price) {
		
		Transaction tx = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			
			@SuppressWarnings("deprecation")
			Query query = session.createNativeQuery("update Products set unitprice="
					+ price + " where productId=" + id);
			int res = query.executeUpdate();
			
			tx.commit();
			
			if (res > 0) {
				System.out.println("Product updated");
			} else {
				System.out.println("Update unsuccessful");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
