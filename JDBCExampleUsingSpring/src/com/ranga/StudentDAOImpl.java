package com.ranga;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * StudentDAOImpl.java
 * @author ranga
 * Mar 15, 2014
 */

public class StudentDAOImpl implements StudentDAO {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {		
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public void createStudent(Student student) {
		this.jdbcTemplate.update("insert into Student(id, name, age) values(?,?,?)", student.getId(), student.getName(), student.getAge());		
	}
	@Override
	public Student getStudent(long id) {		
		return this.jdbcTemplate.queryForObject("select * from Student where id = ?",new Object[]{id}, new StudentRowMapper());
	}
	@Override
	public void updateStudent(Student student) {
		this.jdbcTemplate.update("update Student set name = ?, age=? ", new Object[]{student.getName(), student.getAge()});	
	}	
	@Override
	public void deleteStudent(Student student) {
		this.jdbcTemplate.update("delete from Student where id = ? ", student.getId());		
	}
	@Override
	public List<Student> getAllStudents() {
		return this.jdbcTemplate.query( "select * from Student", new StudentRowMapper());			
	}	
	
	@Override
	public int totalStudents() {
		return this.jdbcTemplate.queryForInt("select count(*) from Student");
	}
}