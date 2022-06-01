package com.company.service.gpaStudentManagement;

import com.company.entity.GpaManagement;
import com.company.entity.Subject;
import com.company.entity.Transcript;
import com.company.entity.TypeSubject;
import com.company.service.StudentService.IStudentSer;
import com.company.service.StudentService.ImplStudentSer;
import com.company.service.subjectService.SubjectITF;
import com.company.service.subjectService.SubjectImpl;

import java.io.*;
import java.util.Scanner;

public class GSMImpl implements GSMInterface {
    private IStudentSer iStudentSer;
    private SubjectITF isubjectITF;
    private GpaManagement gpaManagement;
    private GpaManagement[] gpaManagements;
    Scanner sc;

    public GSMImpl() {
        iStudentSer = new ImplStudentSer();
        isubjectITF = new SubjectImpl();
    }

    public GpaManagement[] getGpaManagements() {
        return gpaManagements;
    }

    @Override
    public void inputMark() throws IOException {
        iStudentSer.readFile();
        if (iStudentSer.getStudents() == null) {
            System.out.println("Please add student first");
            iStudentSer.returnStudentList();
            iStudentSer.recordFile();
        }
        isubjectITF.readFile();
        if (isubjectITF.getSubjects() == null) {
            System.out.println("Please add subject");
            isubjectITF.returnSubjectList();
            isubjectITF.recordFile();
        }
        gpaManagements = new GpaManagement[iStudentSer.getStudents().length];
        for (int i = 0; i < iStudentSer.getStudents().length; i++) {
            System.out.println("Student " + i);
            System.out.println("Type number of subject you want to input mark - maximum-" + isubjectITF.getSubjects().length);
            int numOfSubject = typeNumOfSubjectWantToinputMark();
            Transcript[] transcripts = new Transcript[numOfSubject];
            for (int j = 0; j < transcripts.length; j++) {
                System.out.println("Please type subject Id ");
                Subject subject = getSubjectFromId();
                Transcript transcript = new Transcript();
                transcript.setSubject(subject);
                System.out.println("Type mark");
                float mark = returnInputMark();
                transcript.setMark(mark);
                transcripts[j] = transcript;
            }
            gpaManagement = new GpaManagement(iStudentSer.getStudents()[i], transcripts);
            gpaManagements[i] = gpaManagement;
        }
    }

    public float returnInputMark() {
        boolean check = false;
        do {
            try {
                sc = new Scanner(System.in);
                float mark = sc.nextFloat();
                if (mark >= 0 && mark <= 10) {
                    check = true;
                    return mark;
                }
                System.out.println("Please enter valid mark range");
            } catch (Exception e) {
                System.err.println("invalid!");
            }
        } while (check == false);

        return 0;
    }

    public int typeNumOfSubjectWantToinputMark() {
        boolean check = false;
        sc = new Scanner(System.in);
        do {
            int num = sc.nextInt();
            if (num <= isubjectITF.getSubjects().length) {
                check = true;
                return num;
            }
        } while (check == false);
        return 0;
    }

    public Subject getSubjectFromId() throws IOException {
        if (isubjectITF.getSubjects() == null) {
            System.out.println("Please add subject");
            isubjectITF.returnSubjectList();
            isubjectITF.recordFile();
            isubjectITF.readFile();
        }
        boolean check = false;
        do {
            try {
                sc = new Scanner(System.in);
                int subjectId = sc.nextInt();
                for (int i = 0; i < isubjectITF.getSubjects().length; i++) {
                    if (isubjectITF.getSubjects()[i].getSubjectId() == subjectId) {
                        check = true;
//                        System.out.print("Student has id " + "");
                        return isubjectITF.getSubjects()[i];
                    }
                }
                System.out.println("Not found subject id. Please re-type!");
            } catch (Exception e) {
                System.err.println("invalid number");
            }
        } while (check == false);
        return null;
    }


    @Override
    public void sortGpaTranscriptFromStudentname() {
        if(gpaManagements == null){
            System.out.println("please input mark first");
        }
        for (int i = 0; i < gpaManagements.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < gpaManagements.length; j++) {
                if (gpaManagements[j].getStudent().getFullName().compareTo(gpaManagements[minPos].getStudent().getFullName()) > 0) {
                    minPos = j;
                }
            }
            GpaManagement temp = gpaManagements[minPos];
            gpaManagements[minPos] = gpaManagements[i];
            gpaManagements[i] = temp;
        }
    }

    @Override
    public void sortGpaTranscriptFromSubjectname() {
        for (int i = 0; i < gpaManagements.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; i <= gpaManagements.length; j++) {
                if (gpaManagements[j].getStudent().getFullName().compareTo(gpaManagements[minPos].getStudent().getFullName()) > 0) {
                    minPos = j;
                }
            }
            GpaManagement temp = gpaManagements[minPos];
            gpaManagements[minPos] = gpaManagements[i];
            gpaManagements[i] = temp;
        }
    }

    @Override
    public void readFile() {
        System.out.println("Loading subjects...");
        FileInputStream fileInputStream = null;
        setLengthGsm();
        try {
            fileInputStream = new FileInputStream("transcripts.txt");
            Scanner sc = new Scanner(fileInputStream);
            if (sc.hasNext()) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    System.out.println(line);
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

    public void setLengthGsm() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("transcripts.txt");
            Scanner sc = new Scanner(fileInputStream);
            if (sc.hasNext()) {
                int count = 0;
                while (sc.hasNextLine() && !(sc.nextLine()).equals("")) {
                    count++;
                }
                gpaManagements = new GpaManagement[count];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void recordFile() throws IOException {
        File file = new File("transcripts.txt");
        FileOutputStream fos = new FileOutputStream(file, true);
        for (GpaManagement gpaManagement : gpaManagements) {
            String str = gpaManagement.toString();
            try {
                fos.write(str.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            fos.write("\n".getBytes());
        }
        System.out.println("Saving to file...\r\n" + "Bye!");
    }

    public void calcAvgmark() {
        if (gpaManagements == null) {
            System.out.println("please input mark first");
            return;
        }
        sc = new Scanner(System.in);
        boolean check = false;
        do {
            try {
                int id = sc.nextInt();
                float avgM = 0;
                for (int i = 0; i < gpaManagements.length; i++) {
                    if (gpaManagements[i].getStudent().getStudentId() == id) {
                        avgM = gpaManagements[i].getAveragemark();
                        check = true;
                        System.out.println("Avg mark of student has id " + id + " is: " + avgM);
                        return;
                    }
                }
                System.out.println("not found student Id");
            } catch (Exception e) {
                System.err.println("invalid number");
            }
        } while (check == false);
        return;
    }

    @Override
    public void showInfoGSM(GpaManagement[] gpaManagements) {
        if (gpaManagements == null) {
            System.out.println("Please add readers first");
            return;
        }

        for (int i = 0; i < gpaManagements.length; i++) {
            System.out.println(gpaManagements[i].toString());
        }
    }


}
