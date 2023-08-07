/**
 * 
 */
package com.varasofttech.service.employee;

import java.util.List;

import com.varasofttech.business.Employee;

/**
 * @author Ranga Reddy
 * @date Jan 26, 2015
 * @version 1.0
 */
public interface EmployeeService {
	public long createEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public void deleteEmployee(long employeeId);
	public Employee getEmployee(long employeeId);
	public List<Employee> getAllEmployees();
}
