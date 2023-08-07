package com.ranga.employee.bean;

import java.io.Serializable;

/* 
 * @author Ranga Reddy
 * @version 1.0
 * @since 25 July, 2015
 */

public class Employee implements Serializable {
	private static final long serialVersionUID = -5673249183724100273L;
	
	private long id;
	private String name;
	private int age;
	
	public Employee() {
		super();
	}
		
	public Employee(long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}		
}