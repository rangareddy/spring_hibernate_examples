# SpringJDBCExample
Spring JDBC Example Program

This program demonstrates the how to integrate Spring with JDBC.

# Tools used:
-------------------------------------------------------------------
1. Java8
2. Eclipse Luna
3. Maven 3.0.4
4. MySQL 5.5.9

# Script Code to Create a Table:

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

#How to run the Application:

Right Click on Application.java and Select Run As --> Java Application.

Creating Employee Information: 
Employee Information is created.

Retrieving Employee Information: 
Employee Information: Employee [id=1, name=Ranga, age=27]

Updating Employee Information: 
Employee Information is updated.

Displaying all Employees Information: 
Employee [id=1, name=Ranga Reddy, age=28]

Deleting Employee Information: 
Employee Information is deleted.

#Happy Coding!..   
