package com.company.entity;

import java.util.Scanner;

public class Student extends Person {

    private int studentId = 10000;
    private String className;

    public Student() {
        super();
    }

    public Student(String fullName, String address, String phoneNumber, int studentId, String className) {
        super(fullName, address, phoneNumber);
        this.studentId = studentId;
        this.className = className;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Pleas type class name ");
        className = sc.nextLine();

    }

    @Override
    public String toString() {
        return "studentId=" + studentId + ", " +
                super.toString() +
                ", className=" + className;
    }
}
