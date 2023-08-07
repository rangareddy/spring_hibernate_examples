package com.ranga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ranga
 * @date 16-Jul-2013
 */

public class Application {
	private static final String deleteStudent = "DELETE FROM STUDENT WHERE Id = ?";
	private static final String updateStudent = "UPDATE STUDENT SET Name=?, Age=? WHERE Id =?";
	private static final String selectStudent = "SELECT * FROM STUDENT WHERE Id = ";
	private static final String createStudent = "INSERT INTO STUDENT(Id, Name, Age) VALUES(?, ?, ?)";
	private static final String generatePrimaryKey = "SELECT MAX(Id) from STUDENT";
    public static void main(String args[]) throws Exception {
    	
        // Creating a Student object and setting the values
        Student st = new Student();
        st.setStudentName("Ranga");
        st.setAge(20);
        
        // inserting Student object and getting the studentId
        long studentId = createStudent(st);
        
        // fetching the Student object by using studentId
        Student student = getStudent(studentId);
        
        // displaying student data before update
        System.out.println("Before Update : " + student.toString());
        
        // updating the student object values
        student.setStudentName("RangaReddy");
        student.setAge(25);        
        // updating the modified student
        updateStudent(student);
        
        student = getStudent(studentId);
        // displaying the updated data
        System.out.println("After Update : " + student);
        
        // deleting the student
        deleteStudent(studentId);
    }

    private static void deleteStudent(long studentId) throws SQLException {
        Connection con = DBUtil.getConnection();        
        PreparedStatement pstmt = con.prepareStatement(deleteStudent);
        pstmt.setLong(1, studentId);
        DBUtil.beginTransaction();
        int res = pstmt.executeUpdate();
        if (res != 0) {
            DBUtil.commit();
        } else {
            DBUtil.rollback();
        }
        DBUtil.closeDBUtil(null, pstmt, con);
    }

    private static void updateStudent(Student stu) throws SQLException {        
        Connection con = DBUtil.getConnection();
        PreparedStatement pstmt = con.prepareStatement(updateStudent);
        pstmt.setString(1, stu.getStudentName());
        pstmt.setInt(2, stu.getAge());
        pstmt.setLong(3, stu.getStudentId());
        DBUtil.beginTransaction();
        int result = pstmt.executeUpdate();
        if (result != 0) {
            DBUtil.commit();
        } else {
            DBUtil.rollback();
        }
        DBUtil.closeDBUtil(null, pstmt, con);
    }

    private static Student getStudent(long studentId) throws SQLException {        
        Connection con = DBUtil.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(selectStudent+studentId);
        DBUtil.beginTransaction();
        Student student = null;
        if (rs.next()) {
            student = new Student();
            student.setStudentId(rs.getLong(1));
            student.setStudentName(rs.getString(2));
            student.setAge(rs.getInt(3));
            DBUtil.commit();
        } else {
            DBUtil.rollback();
        }
        DBUtil.closeDBUtil(rs, stmt, con);
        return student;
    }

    private static long createStudent(Student stu) throws Exception {
        long studentId = generateStudentId() + 1;        
        Connection con = DBUtil.getConnection();
        PreparedStatement pstmt = con.prepareStatement(createStudent);
        pstmt.setLong(1, studentId);
        pstmt.setString(2, stu.getStudentName());
        pstmt.setInt(3, stu.getAge());
        DBUtil.beginTransaction();
        int result = pstmt.executeUpdate();
        if (result != 0) {
            DBUtil.commit();
        } else {
            DBUtil.rollback();
        }
        DBUtil.closeDBUtil(null, pstmt, con);
        return studentId;
    }

    private static long generateStudentId() {        
        Connection con = null;
        Statement stmt = null;
        long res = 0;
        try {
            con = DBUtil.getConnection();
            stmt = con.createStatement();
            res = stmt.executeUpdate(generatePrimaryKey);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DBUtil.closeDBUtil(null, stmt, con);
        return res;
    }
}
