package com.ranga.dao;

import java.util.List;

import com.ranga.pojo.Employee;

public interface EmployeeDAO {
	public long createEmployee(Employee employee);
	public Employee findEmployeeById(long id);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(long id);
	public List<Employee> fetchAllEmployees();
}