/**
 * 
 */
package com.ranga;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application.java
 * @author ranga
 * Mar 15, 2014
 */
public class Application {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDAO studentDAO = applicationContext.getBean(StudentDAOImpl.class);
		Student student = new Student();
		student.setId(143);
		student.setName("Ranga");
		student.setAge(25);
		// creating student
		studentDAO.createStudent(student);
		
		// retriving student
		student = studentDAO.getStudent(student.getId());
		System.out.println(student);
		
		// updating student
		student.setName("Ranga Reddy");
		student.setAge(26);
		studentDAO.updateStudent(student);
		
		System.out.println("Total Student Records: " + studentDAO.totalStudents());
		
		// retriving all students
		List<Student> students = studentDAO.getAllStudents();
		for (Student student2 : students) {
			System.out.println(student2);
		}
		
		// deleting student
		studentDAO.deleteStudent(student);		
	}
}
