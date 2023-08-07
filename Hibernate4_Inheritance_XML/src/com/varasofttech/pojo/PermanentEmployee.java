package com.varasofttech.pojo;

public class PermanentEmployee extends Employee {
	private static final long serialVersionUID = -9128526681505398594L;
	
	private double allowance;
    private int noOfLeaves;
    
    public PermanentEmployee() {
		super();
	}
	// Getter & Setter methods 
    public double getAllowance() {
   	 return allowance;
    }
    public void setAllowance(double allowance) {
   	 this.allowance = allowance;
    }
    public int getNoOfLeaves() {
   	 return noOfLeaves;
    }
    public void setNoOfLeaves(int noOfLeaves) {
   	 this.noOfLeaves = noOfLeaves;
    }
	@Override
	public String toString() {
		return "PermanentEmployee [allowance=" + allowance + ", noOfLeaves="
				+ noOfLeaves + "]";
	}  
}
