CRUD( Create Read Update Delete) Operations By Using JDBC
=========================================================

Step1: Create Student table

Oracle DB
-----------------
CREATE TABLE STUDENT
   (ID NUMBER(19,0) NOT NULL, 
	  NAME VARCHAR2(255 CHAR), 
	  AGE NUMBER(10,0), 
	  PRIMARY KEY (ID));
	  
MySQL DB
-----------------------------------
CREATE TABLE `student` (
  `Id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
);

Output:
---------------------------------------------------------

Before Update : Student [studentId=2, studentName=Ranga, age=20]
After Update : Student [studentId=2, studentName=RangaReddy, age=25]

