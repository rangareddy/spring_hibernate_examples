package com.ranga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello");
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Class loaded successfully!");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();			
		} 
		Connection con = null;
		Statement stmt = null;

		try {
			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/RangaDB", "ranga","ranga");
			System.out.println("Connection establised successfully");
			stmt = con.createStatement();
			
			System.out.println("Creating Student Table.");
			stmt.execute("create table student(id int, name varchar(20))");
			System.out.println("Student table created successfully.");
			
			System.out.println("Inserting values to the Student Table.\n");
			int i = stmt.executeUpdate("insert into student values(1,'ranga')");
			if(i != 0) {
				System.out.println("1 row inserted successfully.");
			}
			
			System.out.println("Displaying Student Details\n");
			ResultSet rs = stmt.executeQuery("select * from student");			
			while(rs.next()) {
			  System.out.println("Id : "+rs.getInt(1) +" Name: "+rs.getString(2));	
			}
		} catch (SQLException ex) {			
			ex.printStackTrace();			
		} finally {
			try {
				if(stmt!=null) {
					stmt.close();
					stmt = null;
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			
			try {
				if(con!=null) {
					con.close();
					con = null;
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
	}
}
