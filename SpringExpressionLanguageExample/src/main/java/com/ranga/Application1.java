package com.ranga;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranga.annotation.Author;

public class Application1 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		Author author = (Author) applicationContext.getBean("myAuthorBean");
		System.out.println(author);
	}
}