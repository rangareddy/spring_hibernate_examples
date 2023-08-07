package com.ranga;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee employee = (Employee) applicationContext.getBean("classic_employee");
		System.out.println(employee);
		Employee c_namespace_employee = (Employee) applicationContext.getBean("c_namespace_employee");
		System.out.println(c_namespace_employee);
	}
}
