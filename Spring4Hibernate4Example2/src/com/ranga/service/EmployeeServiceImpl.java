package com.ranga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ranga.dao.EmployeeDAO;
import com.ranga.pojo.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public long createEmployee(Employee employee) {
		return employeeDAO.createEmployee(employee);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
	}

	@Override
	@Transactional
	public Employee findEmployeeById(long employeeId) {
		return employeeDAO.findEmployeeById(employeeId);
	}

	@Override
	@Transactional
	public void deleteEmployee(long employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}
	
	@Override
	@Transactional
	public List<Employee> fetchAllEmployees() {
		return employeeDAO.fetchAllEmployees();
	}
}