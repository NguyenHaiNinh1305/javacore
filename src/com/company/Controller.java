package com.company;

import com.company.entity.GpaManagement;
import com.company.entity.Student;
import com.company.entity.Subject;
import com.company.service.StudentService.StudentService;
import com.company.service.gpaStudentManagement.GPAStudentMngService;
import com.company.service.subjectService.SubjectService;
import com.company.utils.DataUtil;
import com.company.utils.InputNumberUtil;
import com.company.utils.file.FileUtil;
public class Controller {
    public static FileUtil fileUtil = new FileUtil();
    public static StudentService studentService = new StudentService();
    public static SubjectService subjectService = new SubjectService();
    public static GPAStudentMngService gpaStudentMngService = new GPAStudentMngService();
    public Controller() {

    }

    private static void initializeDataFromFile(){
        Object subjectData = fileUtil.readDataFromFile(SubjectService.FILE_NAME);
        SubjectService.subjects = DataUtil.isNullOrEmpty(subjectData) ? new Subject[100] : (Subject[]) subjectData;

        Object studentData = fileUtil.readDataFromFile(StudentService.FILE_NAME);
        StudentService.students = DataUtil.isNullOrEmpty(studentData) ? new Student[100] : (Student[]) studentData;

        Object transcriptData = fileUtil.readDataFromFile(GPAStudentMngService.FILE_NAME);
        GPAStudentMngService.gpaManagements = DataUtil.isNullOrEmpty(transcriptData) ? new GpaManagement[100] : (GpaManagement[]) transcriptData;
    }
    public void processTask() {
        initializeDataFromFile();
        int choose = 0;
        do {
            showMenu();
            choose = InputNumberUtil.returnInt();
            switch (choose) {
                case 1:
                    studentService.addStudents();
                    break;
                case 2:
                    subjectService.addSubjects();
                    break;
                case 3:
                  gpaStudentMngService.inputMark();
                    break;
                case 4:
                	gpaStudentMngService.sortGpaFromStudentname();
                    break;
                case 5:
                	gpaStudentMngService.calculateGpa();
                    break;
                case 6:
                    studentService.showStudents();
                    break;
                case 7:
                    subjectService.showSubjects();
                    break;
                case 8:
                    gpaStudentMngService.showGpaTrans();
                    break;
                case 10:
                    System.out.println("finish");
                    return;
                default:
                    System.out.println("Please re-type correct selection");
                    break;
            }
    } while(choose !=10);
}

    public static void showMenu() {
        System.out.println("/****************************************/");
        System.out.println("1. Add student.\n" + "2. Add subject.\n" + "3. Input mark.\n"
                + "4. Sort Gpa managements from student name.\n" + "5. Calculate average mark.\n" + "6. Load all students from file.\n"
                + "7. Load all subjects form file.\n" + "8. Load all Gpa managements form file.\n" + "10. Exit.");
        System.out.println("/****************************************/");
    }

}
