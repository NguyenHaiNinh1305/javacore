package com.company.service.subjectService;

import com.company.entity.Subject;
import com.company.entity.TypeSubject;

import java.io.*;
import java.util.Scanner;

public class SubjectImpl implements SubjectITF {

    private Subject[] subjects;

    public Subject[] getSubjects() {
        return subjects;
    }

    @Override
    public Subject[] returnSubjectList() {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Type subject quantities you want");
        int n = sc.nextInt();
        subjects = new Subject[n];
        for (int i = 0; i < n; i++) {
            Subject subject = new Subject();
            subject.setSubjectId(findPosForId() +10000 + i);
            subject.inputSubjectInfo();
            subjects[i] = subject;
        }
        return subjects;
    }
    public int findPosForId() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("subjects.txt");
            Scanner sc = new Scanner(fileInputStream);
            if (sc.hasNext()) {
                int count = 0;
                while (sc.hasNextLine() && !(sc.nextLine()).equals("")) {
                    count++;
                }
                return count;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void setLengthSubject() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("subjects.txt");
            Scanner sc = new Scanner(fileInputStream);
            if (sc.hasNext()) {
                int count = 0;
                while (sc.hasNextLine() && !(sc.nextLine()).equals("")) {
                    count++;
                }
                subjects = new Subject[count];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile() {
        System.out.println("Loading subjects...");
        FileInputStream fileInputStream = null;
        setLengthSubject();
        try {
            fileInputStream = new FileInputStream("subjects.txt");
            Scanner sc = new Scanner(fileInputStream);
            if (sc.hasNext()) {
                int i = 0;
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (line.equals("")) {
                        break;
                    }
                    String[] arrSubject = getEleOfSubject(line);
                    int id = Integer.parseInt(arrSubject[0]);
                    String name = arrSubject[1];
                    String type = arrSubject[3];
                    TypeSubject typeSubject = TypeSubject.valueOf(type);
                    int creadits = Integer.parseInt(arrSubject[2]);
                    Subject subject = new Subject(id, name, creadits, typeSubject);
                    subjects[i] = subject;
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
                e.printStackTrace();
            }
        }


    }

    public String[] getEleOfSubject(String subject) {
        String[] arrSubject = subject.split(", ");
        for (int i = 0; i < arrSubject.length; i++) {
            String[] subArr = arrSubject[i].split("=");
            arrSubject[i] = subArr[subArr.length - 1];
        }
        return arrSubject;
    }

    @Override
    public void recordFile() throws IOException {
        File file = new File("subjects.txt");
        FileOutputStream fos = new FileOutputStream(file, true);
        for (Subject subject : subjects) {
            String str = subject.toString();
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
    public void showInfoSubject(Subject[] subjects) {
        if (subjects == null) {
            System.out.println("Please add subject first");
            return;
        }

        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i].toString());
        }
    }

}

