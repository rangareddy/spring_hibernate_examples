/**
 * 
 */
package com.ranga.dao;

import java.util.List;

import com.ranga.pojo.Employee;

/**
 * EmployeeDAO.java
 * @author ranga
 * Mar 22, 2014
 */
public interface EmployeeDAO extends DAOSupport<Employee> {
	/* (non-Javadoc)
	 * @see com.ranga.dao.DAOSupport#create(java.lang.Object)
	 */
	@Override
	public long create(Employee object);
	
	/* (non-Javadoc)
	 * @see com.ranga.dao.DAOSupport#delete(long)
	 */
	@Override
	public void delete(long id);
	
	/* (non-Javadoc)
	 * @see com.ranga.dao.DAOSupport#fetchAll()
	 */
	@Override
	public List<Employee> fetchAll();
	
	/* (non-Javadoc)
	 * @see com.ranga.dao.DAOSupport#fetchByid(long)
	 */
	@Override
	public Employee fetchByid(long id);
	
	/* (non-Javadoc)
	 * @see com.ranga.dao.DAOSupport#fetchByName(java.lang.String)
	 */
	@Override
	public Employee fetchByName(String name);
	
	
	/* (non-Javadoc)
	 * @see com.ranga.dao.DAOSupport#update(java.lang.Object)
	 */
	@Override
	public Employee update(Employee object);	
	
}
