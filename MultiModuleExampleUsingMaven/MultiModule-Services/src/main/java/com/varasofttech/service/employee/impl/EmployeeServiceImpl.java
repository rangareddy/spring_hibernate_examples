package com.varasofttech.service.employee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varasofttech.business.Employee;
import com.varasofttech.dao.employee.EmployeeDAO;
import com.varasofttech.service.employee.EmployeeService;

/**
 * @author Ranga Reddy
 * @date Jan 26, 2015
 * @version 1.0
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	/* (non-Javadoc)
	 * @see com.varasofttech.service.employee.EmployeeService#createEmployee(com.varasofttech.Employee)
	 */
	public long createEmployee(Employee employee) {
		return employeeDAO.createEmployee(employee);
	}

	/* (non-Javadoc)
	 * @see com.varasofttech.service.employee.EmployeeService#updateEmployee(com.varasofttech.Employee)
	 */
	public Employee updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	/* (non-Javadoc)
	 * @see com.varasofttech.service.employee.EmployeeService#deleteEmployee(com.varasofttech.Employee)
	 */
	public void deleteEmployee(Employee employee) {
		employeeDAO.deleteEmployee(employee);
	}

	/* (non-Javadoc)
	 * @see com.varasofttech.service.employee.EmployeeService#deleteEmployee(long)
	 */
	public void deleteEmployee(long employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

	/* (non-Javadoc)
	 * @see com.varasofttech.service.employee.EmployeeService#getEmployee(long)
	 */
	public Employee getEmployee(long employeeId) {
		return employeeDAO.getEmployee(employeeId);
	}

	/* (non-Javadoc)
	 * @see com.varasofttech.service.employee.EmployeeService#getAllEmployee()
	 */
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}
}
