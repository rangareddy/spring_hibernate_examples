package com.ranga;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ranga.pojo.Person;

public class Application {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure();		
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();		
		Person person = new Person(0, "Ranga", 25);
		session.save(person);
		System.out.println("Done!");		
	}
}
