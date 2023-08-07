package com.ranga;

import java.util.List;

/**
 * StudentDAO.java
 * @author ranga
 * Mar 15, 2014
 */
public interface StudentDAO {
	public void createStudent(Student student);
	public Student getStudent(long id);
	public void updateStudent(Student student);
	public void deleteStudent(Student student);
	public List<Student> getAllStudents();
	public int totalStudents();
}
