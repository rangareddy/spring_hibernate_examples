package com.ranga;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ranga.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		SessionFactory sessionFactory1 = HibernateUtil.getSessionFactory();
		Session session1 = null, session2 = null;

		session1 = sessionFactory1.openSession();
		session2 = sessionFactory1.openSession();

		if (session1 == session2) {
			System.out.println("Both seesions are equal by using openSession()");
		} else {
			System.out.println("Both seesions are not equal by using openSession()");
		}

		session1 = sessionFactory1.getCurrentSession();
		session2 = sessionFactory1.getCurrentSession();
		if (session1 == session2) {
			System.out.println("Both seesions are equal by using getCurrentSession()");
		} else {
			System.out.println("Both seesions are not equal by using getCurrentSession()");
		}

	}
}
