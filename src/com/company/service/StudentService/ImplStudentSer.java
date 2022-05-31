package com.company.service.StudentService;

import com.company.entity.Student;
import com.company.entity.Subject;
import com.company.entity.TypeSubject;

import java.io.*;
import java.util.Scanner;

public class ImplStudentSer implements IStudentSer {
    private Student[] students;

    public Student[] getStudents() {
        return students;
    }



    @Override
    public Student[] returnStudentList() {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Type Student quantities you want");
        int n = sc.nextInt();
        students = new Student[n];
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.setStudentId(student.getStudentId() + i);
            student.input();
            students[i] = student;
        }
        return students;
    }


    @Override
    public void readFile() {
        System.out.println("Loading student...");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("students.txt");
            Scanner sc = new Scanner(fileInputStream);
            if (sc.hasNext()) {
                int i = 0;
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] arrStudent = getEleOfStudents(line);
                    int id = Integer.parseInt(arrStudent[0]);
                    String name = arrStudent[1];
                    String address = arrStudent[2];
                    String phoneNum = arrStudent[3];
                    String className = arrStudent[4];
                    Student student = new Student(name, address, phoneNum, id, className);
                    students[i] = student;
                    i++;
                }
            } else {
                System.out.println("(empty)");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }

    public String[] getEleOfStudents(String student) {
        String[] arrStudent = student.split(", ");
        for (int i = 0; i < arrStudent.length; i++) {
            String[] subArr = arrStudent[i].split("=");
            arrStudent[i] = subArr[subArr.length - 1];
        }
        return arrStudent;
    }

    @Override
    public void recordFile() throws IOException {
        File file = new File("students.txt");
        FileOutputStream fos = new FileOutputStream(file);
        for (Student student : students) {
            String str = student.toString();
            try {
                fos.write(str.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            fos.write("\n".getBytes());
        }
        System.out.println("Saving to file...\r\n" + "Bye!");


    }

    @Override
    public void showInfoStudent(Student[] Students) {
        if (students == null) {
            System.out.println("Please add readers first");
            return;
        }

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].toString());
        }
    }
}
