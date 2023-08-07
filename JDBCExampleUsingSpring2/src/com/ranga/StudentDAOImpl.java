package com.ranga;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * StudentDAOImpl.java
 * @author ranga
 * Mar 15, 2014
 */

public class StudentDAOImpl implements StudentDAO {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public void createStudent(Student student) {
		Map namedParameters = new HashMap();
		namedParameters.put("id", student.getId());
		namedParameters.put("name", student.getName());
		namedParameters.put("age",student.getAge());
		this.namedParameterJdbcTemplate.update("insert into Student(id, name, age) values(:id, :name,:age)", namedParameters);		
	}
	
	@Override
	public Student getStudent(long id) {
		SqlParameterSource namedParameters = new MapSqlParameterSource("id",id);
		return this.namedParameterJdbcTemplate.queryForObject("select * from Student where id = :id",namedParameters, new StudentRowMapper());
	}
	@Override
	public void updateStudent(Student student) {
		Map namedParameters = new HashMap();
		namedParameters.put("id", student.getId());
		namedParameters.put("name", student.getName());
		namedParameters.put("age",student.getAge());
		this.namedParameterJdbcTemplate.update("update Student set name = :name, age= :age ", namedParameters);		
	}	
	@Override
	public void deleteStudent(Student student) {
		SqlParameterSource namedParameters = new MapSqlParameterSource("id",student.getId());
		this.namedParameterJdbcTemplate.update("delete from Student where id = :id", namedParameters);		
	}
	
	@Override
	public List<Student> getAllStudents() {
		return this.namedParameterJdbcTemplate.query( "select * from Student", new StudentRowMapper());			
	}	
	
	@Override
	public int totalStudents() {
		String sql = "select count(*) from Student";
		SqlParameterSource namedParameters = new MapSqlParameterSource();
	    return this.namedParameterJdbcTemplate.queryForInt(sql, namedParameters);		
	}
}