package com.varasofttech.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.varasofttech.pojo.Employee;
import com.varasofttech.pojo.PermanentEmployee;
import com.varasofttech.pojo.Person;
import com.varasofttech.util.HibernateUtil;

public class Application {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFacoty();
		Session session = null;
		Transaction transaction = null;
		
		Person person= new Person();
    	person.setFirstName("ranga");
    	person.setLastName("reddy");
    	person.setAge(25);
   	 
    	Employee employee= new Employee();
    	employee.setFirstName("raja");
    	employee.setLastName("reddy");
    	employee.setAge(45);
    	employee.setDesignation("Project Lead");
    	employee.setSalary(120000.0);
   	 
    	PermanentEmployee permanentEmployee= new PermanentEmployee();
    	permanentEmployee.setFirstName("vasundra");
    	permanentEmployee.setLastName("reddy");
    	permanentEmployee.setAge(40);
    	permanentEmployee.setDesignation("Architect");
    	permanentEmployee.setSalary(150000.0);
    	permanentEmployee.setNoOfLeaves(15);
    	permanentEmployee.setAllowance(5000.00);
    	
    	try {
    		session = sessionFactory.openSession();
    		transaction = session.beginTransaction();
    		
    		session.save(person);
        	session.save(employee);
        	session.save(permanentEmployee);
        	session.flush();
        	transaction.commit();
        	
    	} catch(Exception ex) {
    		ex.printStackTrace();
    		if(transaction != null)
    			transaction.rollback();
    	} finally {
    		if(session != null) {
    			session.close();
    			session = null;
    		}
    	}    	
	}
	
}
