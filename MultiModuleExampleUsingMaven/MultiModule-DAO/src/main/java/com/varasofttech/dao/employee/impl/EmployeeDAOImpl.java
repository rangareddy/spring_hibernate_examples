/**
 * 
 */
package com.varasofttech.dao.employee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.varasofttech.business.Employee;
import com.varasofttech.dao.basedao.HibernateTemplate;
import com.varasofttech.dao.basedao.QueryType;
import com.varasofttech.dao.employee.EmployeeDAO;

/**
 * @author Ranga Reddy
 * @date Jan 26, 2015
 * @version 1.0
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/* (non-Javadoc)
	 * @see com.varasofttech.employee.EmployeeDAO#createEmployee(com.varasofttech.Employee)
	 */
	public long createEmployee(Employee employee) {		
		return (Long) hibernateTemplate.save(employee);
	}

	/* (non-Javadoc)
	 * @see com.varasofttech.employee.EmployeeDAO#updateEmployee(com.varasofttech.Employee)
	 */
	public Employee updateEmployee(Employee employee) {		
		return hibernateTemplate.update(employee);
	}

	/* (non-Javadoc)
	 * @see com.varasofttech.employee.EmployeeDAO#deleteEmployee(com.varasofttech.Employee)
	 */
	public void deleteEmployee(Employee employee) {
		hibernateTemplate.delete(employee);		
	}

	/* (non-Javadoc)
	 * @see com.varasofttech.employee.EmployeeDAO#deleteEmployee(long)
	 */
	public void deleteEmployee(long employeeId) {
		hibernateTemplate.delete(Employee.class, employeeId);			
	}

	/* (non-Javadoc)
	 * @see com.varasofttech.employee.EmployeeDAO#getEmployee(long)
	 */
	public Employee getEmployee(long employeeId) {		
		return hibernateTemplate.get(Employee.class, employeeId);
	}

	/* (non-Javadoc)
	 * @see com.varasofttech.employee.EmployeeDAO#getAllEmployee()
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		String queryName = "SELECT e FROM Employee e";
		return hibernateTemplate.getResultList(queryName, null, QueryType.HibernateQuery);
	}
}
