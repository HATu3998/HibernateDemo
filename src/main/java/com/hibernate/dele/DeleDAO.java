package com.hibernate.dele;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Users;
import com.hibernate.utils.HibernateUtil;

public class DeleDAO {
	

	
	public static void deleteEntityById(int id) {
	    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    Transaction transaction = null;
	    
	    try {
	        transaction = session.beginTransaction();
	        Users user = session.get(Users.class, id);
	        
	        if (user != null) {
	            session.delete(user);
	            transaction.commit();
	            System.out.println("Entity with id " + id + " deleted successfully.");
	        } else {
	            System.out.println("Entity with id " + id + " not found.");
	        }
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}

}
