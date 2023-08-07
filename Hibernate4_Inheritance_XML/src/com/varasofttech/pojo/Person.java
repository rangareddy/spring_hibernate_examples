package com.varasofttech.pojo;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 6281099766897902592L;
	
	private long id;
    private String firstName;
    private String lastName;
    private int age;
    
    public Person() {
		super();
	}
    
	// Getter & Setter methods
    public long getId() {
   	 return id;
    }
    public void setId(long id) {
   	 this.id = id;
    }
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
    public int getAge() {
   	 return age;
    }
    public void setAge(int age) {
   	 this.age = age;
    }
    
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + "]";
	}   	 
}
