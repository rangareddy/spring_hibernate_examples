/**
 * 
 */
package com.ranga.pojo;

import java.io.Serializable;

/**
 * Employee.java
 * @author ranga
 * Mar 22, 2014
 */
public class Employee implements Serializable {
	private long id;
	private String name;
	private int age;
	private float salary;
	public Employee() {
		super();		
	}
	public Employee(long id, String name, int age, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
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
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age
				+ ", salary=" + salary + "]";
	}		
}
