/**
 * 
 */
package com.ranga.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ranga.dao.EmployeeDAO;
import com.ranga.pojo.Employee;

/**
 * EmployeeDAOImpl.java
 * @author ranga
 * Mar 22, 2014
 */

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.ranga.dao.EmployeeDAO#create(com.ranga.pojo.Employee)
	 */
	
	private Session getSession() {	
		return this.sessionFactory.openSession();
	}
	
	@Override
	public long create(Employee employee) {
		Session session = getSession();
		long employeeId = 0;
		Transaction transaction = session.beginTransaction();
		try {
			employeeId = (Long) session.save(employee);			
			transaction.commit();	
		} catch(Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		} finally {
			session.evict(employee);
			session.close();
		}
		return employeeId;
	}

	/* (non-Javadoc)
	 * @see com.ranga.dao.EmployeeDAO#delete(long)
	 */
	@Override
	public void delete(long id) {
		Session session = getSession();	
		Transaction transaction = session.beginTransaction();
		try {
			Employee employee = (Employee) session.get(Employee.class, id);
			session.delete(employee);
			transaction.commit();
		} catch(Exception ex) { 
			transaction.rollback();
		}		
		finally {
			session.close();
		}				
	}

	/* (non-Javadoc)
	 * @see com.ranga.dao.EmployeeDAO#fetchAll()
	 */
	@Override
	public List<Employee> fetchAll() {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> employees = new ArrayList<Employee>();
		try {
			Query query = session.createQuery("from Employee");
			employees = (List<Employee>) query.list();
			transaction.commit();
		} catch(Exception ex) {
			transaction.rollback();
			ex.printStackTrace();			
		} finally {			
			session.close();			
		}
		return employees;
	}

	/* (non-Javadoc)
	 * @see com.ranga.dao.EmployeeDAO#fetchByid(long)
	 */
	@Override
	public Employee fetchByid(long id) {
		Session session = getSession();			
		Employee employee = (Employee) session.load(Employee.class, id);		
		return employee;		
	}

	/* (non-Javadoc)
	 * @see com.ranga.dao.EmployeeDAO#fetchByName(java.lang.String)
	 */
	@Override
	public Employee fetchByName(String name) {		
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = null;
		try {
			employee = (Employee) session.byNaturalId(Employee.class).using("name", name).load();	
			transaction.commit();
		} catch(Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		}
		return employee;		
	}

	/* (non-Javadoc)
	 * @see com.ranga.dao.EmployeeDAO#update(com.ranga.pojo.Employee)
	 */
	@Override
	public Employee update(Employee employee) {		
		Session session = getSession();
		session.evict(employee);
		Transaction transaction = session.beginTransaction();
		try {
			session.update(employee);
			employee = (Employee) session.get(Employee.class, employee.getId());
			transaction.commit();
		} catch(Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		} finally {			
			session.close();
		}		
		return employee;
	}
}