package com.company.service.gpaStudentManagement;

import com.company.entity.GpaManagement;
import com.company.entity.Subject;
import com.company.service.StudentService.IStudentSer;

import java.io.IOException;

public interface GSMInterface {
    void inputMark() throws IOException;

    void sortGpaTranscriptFromStudentname();

    void sortGpaTranscriptFromSubjectname();

    void recordFile() throws IOException;

    void calcAvgmark();
    void showInfoGSM(GpaManagement[] gpaManagements);

    GpaManagement[] getGpaManagements();
}
