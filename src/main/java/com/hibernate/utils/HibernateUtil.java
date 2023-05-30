package com.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {
		try {
			Configuration configuration=new Configuration();
			configuration.configure("hibernate.cfg.xml");
			return configuration.buildSessionFactory();
			
		}
catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
		return null;
	}
	
	
}
