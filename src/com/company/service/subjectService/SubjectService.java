package com.company.service.subjectService;

import com.company.Controller;
import com.company.entity.Student;
import com.company.entity.Subject;
import com.company.utils.DataUtil;
import com.company.utils.InputNumberUtil;


public class SubjectService {

    public static Subject[] subjects;
    public static final String FILE_NAME = "subjects.txt";

    public void showSubjects() {
        for (int i = 0; i < subjects.length; i++) {
            Subject subject = subjects[i];
            if (DataUtil.isNullOrEmpty(subject)) {
                break;
            }
            System.out.println(subject);
        }
    }

    public void addSubjects() {
        System.out.println("Please enter number of subjects");
        int num = InputNumberUtil.returnInt();
        for (int i = 0; i < num; i++) {
            Subject subject = new Subject();
            subject.inputSubjectInfo();
            addSubjectToArray(subject);
        }
        Controller.fileUtil.writeDataToFile(subjects, FILE_NAME);
    }

    public void addSubjectToArray(Subject subject) {
        for (int i = 0; i < subjects.length; i++) {
            if (DataUtil.isNullOrEmpty(subjects[i])) {
                subjects[i] = subject;
                break;
            }
        }
    }

    public static Subject findSubjectFromId() {
        boolean check = false;
        do {
            System.out.println("Enter Subject id");
            int id = InputNumberUtil.returnInt();
            for (int i = 0; i < subjects.length; i++) {
                Subject subject = subjects[i];
                if (!DataUtil.isNullOrEmpty(subject)) {
                    if (id == subject.getSubjectId()) {
                        check = true;
                        return subject;
                    }
                }
            }
        } while (check == false);
        return null;
    }

}

