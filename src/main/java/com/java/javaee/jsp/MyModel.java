package com.java.javaee.jsp;

public class MyModel {
    public Student getStudent() {
        Student student = new Student();
        //..
        student.setName("Max");
        student.setAge(22);
        return student;
    }
}
