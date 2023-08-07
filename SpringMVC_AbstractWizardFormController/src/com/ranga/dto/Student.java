/**
 * 
 */
package com.ranga.dto;

import java.io.Serializable;

/**
 * Student.java
 * @author ranga
 * Apr 12, 2014
 */
public class Student implements Serializable {
	private static final long serialVersionUID = 7863893947483090337L;
	private String firstName;
	private String lastName;
	private String address;
	private int age;
	private String gender;
	private String username;
	private String password;		
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", age=" + age + ", username="
				+ username + ", password=" + password + ", gender=" + gender + "]";
	}	
}
