package com.ranga.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranga.employee.bean.Employee;
import com.ranga.employee.service.EmployeeService;


public class Application {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        
        //Get the EmployeeService Bean
        EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeService.class);
        Employee employee  = new Employee(1, "Ranga", 27);
        
        // Creating Employee
        System.out.println("Creating Employee Information: ");
        employeeService.createEmployee(employee);
        
        // Getting Employee
        System.out.println("\nRetrieving Employee Information: ");
        employee = employeeService.getEmployee(employee.getId());
        
        System.out.println("Employee Information: "+employee);
        System.out.println("\nUpdating Employee Information: ");
        // Updating Employee
        employee.setName("Ranga Reddy");
        employee.setAge(28);
        employeeService.updateEmployee(employee);
        
        // Getting all Employees
        System.out.println("\nDisplaying all Employees Information: ");
        List<Employee> employees = employeeService.getEmployees();
        for(Employee emp : employees) {
        	System.out.println(emp);
        }
        
        // Deleting Employee
        System.out.println("\nDeleting Employee Information: ");
        employeeService.deleteEmployee(employee.getId());
                
	}
}