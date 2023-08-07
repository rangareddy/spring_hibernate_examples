package com.varasofttech.pojo;

public class Employee extends Person {
	private static final long serialVersionUID = -5050456251835366554L;
	private String designation;
    private Double salary;
    
    public Employee() {
    	super();
    }
    
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [designation=" + designation + ", salary=" + salary
				+ "]";
	}
}