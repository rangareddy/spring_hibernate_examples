package com.ranga;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {
    private long studentId;
    private String studentName;
    private int age;
      
    public Student(long studentId, String studentName, int age) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
    }
    public Student() {
        super();
    }
    public long getStudentId() {
        return studentId;
    }
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentName="
                + studentName + ", age=" + age + "]";
    }  
}