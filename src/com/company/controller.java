package com.company;

import com.company.service.StudentService.IStudentSer;
import com.company.service.StudentService.ImplStudentSer;
import com.company.service.gpaStudentManagement.GSMImpl;
import com.company.service.gpaStudentManagement.GSMInterface;
import com.company.service.subjectService.SubjectITF;
import com.company.service.subjectService.SubjectImpl;

import java.io.IOException;
import java.util.Scanner;

public class controller {

    private GSMInterface gsmInterface;
    private IStudentSer iStudentSer;
    private SubjectITF isubjectITF;

    public controller() {
        gsmInterface = new GSMImpl();
        iStudentSer = new ImplStudentSer();
        isubjectITF = new SubjectImpl();
    }

    public void processTask() {

        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            choose = sc.nextInt();
            try {
                showMenu();
                switch (choose) {
                    case 1:
                        iStudentSer.returnStudentList();
                        iStudentSer.recordFile();
                        iStudentSer.showInfoStudent(iStudentSer.getStudents());

                        break;
                    case 2:
                        isubjectITF.returnSubjectList();
                        isubjectITF.recordFile();
                        isubjectITF.showInfoSubject(isubjectITF.getSubjects());
                        break;
                    case 3:
                        try {
                            gsmInterface.inputMark();
                            gsmInterface.recordFile();
                            gsmInterface.showInfoGSM(gsmInterface.getGpaManagements());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        gsmInterface.sortGpaTranscriptFromStudentname();
                        break;
                    case 5:
                        gsmInterface.calcAvgmark();
                        break;
                    case 0:
                        System.out.println("finish");
                        return;
                    default:
                        System.out.println("Please re-type correct selection");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Invalid number");
            }
        } while (choose != 0);
    }

    public static void showMenu() {
        System.out.println("/****************************************/");
        System.out.println("1. Add student.\n" + "2. Add subject.\n" + "3. Input mark.\n"
                + "4. Sort Gpa managements from student name.\n" + "5. Calculate average mark.\n" + "0. Exit.");
        System.out.println("/****************************************/");
    }

}
