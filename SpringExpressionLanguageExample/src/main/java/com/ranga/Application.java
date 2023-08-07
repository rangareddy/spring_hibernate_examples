package com.ranga;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranga.xml.Author;

public class Application {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		Author author = (Author) applicationContext.getBean("authorBean");
		System.out.println(author);
	}
}
