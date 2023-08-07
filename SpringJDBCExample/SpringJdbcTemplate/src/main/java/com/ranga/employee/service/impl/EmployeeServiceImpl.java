package com.ranga.employee.service.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.ranga.employee.bean.Employee;
import com.ranga.employee.service.EmployeeService;
import com.ranga.util.MyJdbcTemplate;
/**
 * 
 * @author Ranga Reddy
 * @version 1.0
 * @since 25 July, 2015
 */
public class EmployeeServiceImpl implements EmployeeService {
	
	private MyJdbcTemplate myJdbcTemplate;
	public EmployeeServiceImpl() {
		
	}
		
	public MyJdbcTemplate getMyJdbcTemplate() {
		return myJdbcTemplate;
	}


	public void setMyJdbcTemplate(MyJdbcTemplate myJdbcTemplate) {
		this.myJdbcTemplate = myJdbcTemplate;
	}


	public void createEmployee(Employee employee) {
		String query = "insert into Employee (id, name, age) values (?,?,?)";                
        Object[] args = new Object[] {employee.getId(), employee.getName(), employee.getAge()};
		int rowsUpdated = myJdbcTemplate.create(query, args);		
		if(rowsUpdated != 0) {
        	System.out.println("Employee Information is created.");
        } else {
        	System.out.println("Employee Information is not created.");
        } 
	}
	
	public void updateEmployee(Employee employee) {
		String query = "update Employee set name=?, age=? where id=?";        
        Object[] params = new Object[] {employee.getName(), employee.getAge(), employee.getId()};
        int rowsUpdated = myJdbcTemplate.update(query, params);
        if(rowsUpdated != 0) {
        	System.out.println("Employee Information is updated.");
        } else {
        	System.out.println("Employee Information is not updated.");
        }        
	}
	
	public void deleteEmployee(long employeeId) {
		String query = "delete from Employee where id=?";  		
        int rowsUpdated = myJdbcTemplate.delete(query, employeeId);
        if(rowsUpdated != 0) {
        	System.out.println("Employee Information is deleted.");
        } else {
        	System.out.println("Employee Information is not deleted.");
        }          
	}
	
	public Employee getEmployee(long employeeId) {
		String query = "select id, name, age from Employee where id = ?";
		Employee employee = myJdbcTemplate.getObject(query, new Object[]{employeeId}, new EmployeeMapper());         
		return employee;
	}
	
	public List<Employee> getEmployees() {
		String query = "SELECT * from Employee";
		return myJdbcTemplate.getObjectList(query, new EmployeeMapper());
	}	
	
	/**
	 * Converting the ResultSet object to Employee object using RowMapper.	 
	 */
	@SuppressWarnings("serial")
	private class EmployeeMapper implements Serializable, RowMapper<Employee> {		
		private static final String EMP_AGE = "age";
		private static final String EMP_NAME = "name";
		private static final String EMP_ID = "id";

		public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setId(resultSet.getLong(EMP_ID));
			employee.setName(resultSet.getString(EMP_NAME));
			employee.setAge(resultSet.getInt(EMP_AGE));
			return employee;
		}		
	}
}