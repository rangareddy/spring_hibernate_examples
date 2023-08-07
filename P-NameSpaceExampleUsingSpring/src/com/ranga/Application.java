package com.ranga;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");		
		App app = (App) applicationContext.getBean("application");
		System.out.println(app);
	}
}
