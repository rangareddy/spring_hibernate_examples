/**
 * 
 */
package com.ranga;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranga.dao.EmployeeDAO;
import com.ranga.dao.impl.EmployeeDAOImpl;
import com.ranga.pojo.Employee;

/**
 * Application.java
 * @author ranga
 * Mar 22, 2014
 */
public class Application {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDAO employeeDAO = applicationContext.getBean(EmployeeDAOImpl.class);
		
		Employee employee = new Employee();		
		employee.setName("Ranga Reddy");
		employee.setAge(25);
		employee.setSalary(40000);
		
		long employeeId = employeeDAO.create(employee);		
		employee = employeeDAO.fetchByid(employeeId);	
		System.out.println("\nAfter Creation: "+employee);
		employee.setAge(26);
		employee.setSalary(50000);
		employee = employeeDAO.update(employee);
		System.out.println("\nAfter Updation: "+employee);
		
		employee = employeeDAO.fetchByName(employee.getName());
		System.out.println("\nFetch By Name: "+employee);
		
		List<Employee> employees = employeeDAO.fetchAll();
		System.out.println("\nAll Employees:\n"+employees);
		
		employeeDAO.delete(employee.getId());
		System.out.println("\nEmployee deleted successfully...");
		
	}
}
