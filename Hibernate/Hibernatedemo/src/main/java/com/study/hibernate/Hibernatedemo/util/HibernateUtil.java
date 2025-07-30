package com.study.hibernate.Hibernatedemo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory factory;

	static {

//		FACTORY = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		try {
			factory = new Configuration().configure().buildSessionFactory();

		} catch (Throwable e) {
			// TODO: handle exception
			 e.printStackTrace(); // ADD THIS LINE
			throw new ExceptionInInitializerError(e);
		}

	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
