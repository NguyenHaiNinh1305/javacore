package com.company.service.StudentService;

import com.company.Controller;
import com.company.entity.Student;
import com.company.utils.DataUtil;
import com.company.utils.InputNumberUtil;


public class StudentService {
    public static Student[] students;
    public static final String FILE_NAME = "students.txt";

    public void showStudents() {
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            if (DataUtil.isNullOrEmpty(student)) {
                break;
            }
            System.out.println(student);
        }
    }

    public void addStudents() {
        System.out.println("Please enter number of students");
        int num = InputNumberUtil.returnInt();
        for (int i = 0; i < num; i++) {
            Student student = new Student();
            student.input();
            addStudentToArray(student);
        }
        Controller.fileUtil.writeDataToFile(students, FILE_NAME);
    }

    public void addStudentToArray(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (DataUtil.isNullOrEmpty(students[i])) {
                students[i] = student;
                break;
            }
        }
    }


    public static Student findStudentFromId() {
        boolean check = false;
        do {
            System.out.println("Enter Student id");
            int id = InputNumberUtil.returnInt();
            for (int i = 0; i < students.length; i++) {
                Student student = students[i];
                if (!DataUtil.isNullOrEmpty(student)) {
                    if (id == student.getStudentId()) {
                        check = true;
                        return student;
                    }
                }
            }
        } while (check == false);
        return null;
    }
}
