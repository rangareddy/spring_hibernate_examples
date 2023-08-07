package com.ranga;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranga.pojo.Employee;
import com.ranga.service.EmployeeService;
import com.ranga.service.EmployeeServiceImpl;

public class Application {
	public static void main(String[] args) {		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee employee = new Employee();		
		employee.setName("Ranga Reddy");
		employee.setAge(25);
		employee.setSalary(40000);
		
		EmployeeService employeeService = (EmployeeService) applicationContext.getBean("employeeService");
		long employeeId = employeeService.createEmployee(employee);

		System.out.println("Before update Employee Info :\n" + employeeService.findEmployeeById(employeeId));		
		employee.setAge(26);
		employee.setSalary(50000);
		employeeService.updateEmployee(employee);
		
		System.out.println("After update Employee Info :\n" + employeeService.findEmployeeById(employeeId));
		
		employee = new Employee();		
		employee.setName("Vinod Reddy");
		employee.setAge(26);
		employee.setSalary(30000);
		employeeService.createEmployee(employee);
		
		System.out.println("All Employees");
		List<Employee> employees = employeeService.fetchAllEmployees();
		System.out.println(employees);
						
		System.out.println("Deleting Employee with Id: "+employeeId);
		employeeService.deleteEmployee(employeeId);
		applicationContext.close();
	}
}