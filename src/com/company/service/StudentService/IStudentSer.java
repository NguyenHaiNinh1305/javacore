package com.company.service.StudentService;

import com.company.entity.Student;
import com.company.entity.Subject;

import java.io.IOException;

public interface IStudentSer {
    Student[] returnStudentList();

    Student[] getStudents();

    void readFile();

    void recordFile() throws IOException;

    void showInfoStudent(Student[] Students);
}
