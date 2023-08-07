package com.ranga.pojo;

import java.io.Serializable;

public class Person implements Serializable {
	private long personId;
	private String personName;
	private int age;
	public Person(long personId, String personName, int age) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.age = age;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName
				+ ", age=" + age + "]";
	}	
}
