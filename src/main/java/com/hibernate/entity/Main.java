package com.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtil;

public class Main {
 
	static final SessionFactory factory=HibernateUtil.getSessionFactory();
	public static void main(String[] args) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Users u=new Users();
		//u.setId(1);
		u.setUsername("eee");
		u.setPassword("eee");
		session.save(u);
		tx.commit();
		//session.close();
System.out.print("done");
	}
}
