package com.ranga.employee.service;

import java.util.List;

import com.ranga.employee.bean.Employee;

/** 
 * @author Ranga Reddy
 * @version 1.0
 * @since 25 July, 2015
 */

public interface EmployeeService {
	void createEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(long employeeId);
	Employee getEmployee(long employeeId);
	List<Employee> getEmployees();
}