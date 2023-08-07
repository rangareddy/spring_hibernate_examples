Hibernate4 examples by using Gradle
-----------------------------------------

This project demonstrate how to develop and run the Hibernate application by using gradle.

System configuration:
---------------------
Java            : JDK1.6 or Above
Gradle version  : 1.x
Database        : Oracle11g
Maven version   : 3.x

Executing this Project:
--------------------------

Step1: Download the Hibernate4WithGradleExample zip file or use the git command to download 
(git clone https://github.com/rangareddy/Hibernate4WithGradleExample.git)

Extract the zip file. (or)

Step2: Go to src/main/resources/ folder and edit the hibernate.cfg.xml file and give the Database properties
like Dialect class, username and password etc.

Step3: Run the following command in terminal or command prompt.

$ gradle -q runApp

output will be

Employee [id = 1, name = Ranga Reddy, age = 25]

See the same program how to develop step by step in my blog
(http://myjourneyonjava.blogspot.in/2013/11/hibernate4x-application-example-by.html)


Author
-------------------------

Author:: Ranga Reddy (rangareddy.avula@gmail.com)
Blog: myjourneyonjava.blogspot.com
