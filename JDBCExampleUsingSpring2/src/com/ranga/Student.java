/**
 * 
 */
package com.ranga;

import java.io.Serializable;

/**
 * Student.java
 * @author ranga
 * Mar 15, 2014
 */
public class Student implements Serializable {
	private long id;
	private String name;
	private int age;
	
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
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}	
}
