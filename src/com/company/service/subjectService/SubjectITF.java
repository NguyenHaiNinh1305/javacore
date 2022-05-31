package com.company.service.subjectService;

import com.company.entity.Subject;

import java.io.IOException;

public interface SubjectITF {

    Subject[] returnSubjectList();

    Subject[] getSubjects();

    void readFile();

    void recordFile() throws IOException;

    void showInfoSubject(Subject[] subjects);

}
