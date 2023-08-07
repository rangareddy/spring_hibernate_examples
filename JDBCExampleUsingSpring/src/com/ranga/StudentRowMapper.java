/**
 * 
 */
package com.ranga;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * StudentRowMapper.java
 * @author ranga
 * Mar 16, 2014
 */
public class StudentRowMapper implements RowMapper<Student> {
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentResultSetExtractor studentResultSetExtractor = new StudentResultSetExtractor();
		return studentResultSetExtractor.extractData(rs);
	}
}