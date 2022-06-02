package com.company.entity;

import java.io.Serializable;
import java.util.Scanner;

public class Student extends Person implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int ID = 10000;

    private int studentId;
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
        this.studentId = this.ID;
        this.ID++;
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
