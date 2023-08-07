package com.ranga;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

/**
 * Application.java
 * @author ranga
 * Mar 8, 2014
 */

public class Application {
	public static void main(String[] args) throws Exception { 
		
		Employee employee = new Employee();
		employee.setId(143);
		employee.setName("Ranga Reddy");
		employee.setAge(25);
		
		// Initializing XStream
		XStream xstream = new XStream(new StaxDriver());
		
		// Creating aliases
		xstream.alias("employee", Employee.class);
		
		//Serializing an object to XML
		String xml = xstream.toXML(employee);
		System.out.println(xml);
		
		//Deserializing an object back from XML
		Employee employee2 = (Employee)xstream.fromXML(xml);
		System.out.println(employee2);
					        
	}	
}

/* Note:
    1. Create element name to class name aliases for any custom classes using xstream.alias(String elementName, Class cls);
    2. Convert an object to XML using xstream.toXML(Object obj);
    3. Convert XML back to an object using xstream.fromXML(String xml);
 */
