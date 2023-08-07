package com.ranga.service;

import java.util.List;

import com.ranga.pojo.Employee;

public interface EmployeeService {
	public long createEmployee(Employee employee);
	public Employee findEmployeeById(long employeeId);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(long employeeId);
	public List<Employee> fetchAllEmployees();
}