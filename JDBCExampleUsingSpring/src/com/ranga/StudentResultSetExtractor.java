/**
 * 
 */
package com.ranga;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 * StudentResultSetExtractor.java
 * @author ranga
 * Mar 16, 2014
 */

public class StudentResultSetExtractor implements ResultSetExtractor<Student> {
	@Override
	public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
		Student student = new Student();
		student.setId(rs.getLong(1));
	    student.setName(rs.getString(2));
	    student.setAge(rs.getInt(3));	    
		return student;
	}
}