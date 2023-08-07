package com.ranga.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ranga.pojo.Employee;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public long createEmployee(Employee employee) {
		return (Long) getCurrentSession().save(employee);
	}

	@Override
	public Employee findEmployeeById(long employeeId) {
		return (Employee) getCurrentSession().get(Employee.class, employeeId);
	}

	@Override
	public void updateEmployee(Employee employee) {
		getCurrentSession().update(employee);
	}
	
	@Override
	public void deleteEmployee(long employeeId) {
		Employee employee = (Employee) getCurrentSession().get(Employee.class, employeeId);
		getCurrentSession().delete(employee);
	}
	
	public List<Employee> fetchAllEmployees() {
		return (List<Employee>) getCurrentSession().createQuery("from Employee").list();
	}
}