package com.company.service.gpaStudentManagement;

import com.company.Controller;
import com.company.entity.GpaManagement;
import com.company.entity.Student;
import com.company.entity.Subject;
import com.company.entity.Transcript;
import com.company.service.StudentService.StudentService;
import com.company.service.subjectService.SubjectService;
import com.company.utils.DataUtil;
import com.company.utils.InputNumberUtil;

public class GPAStudentMngService {
	public static GpaManagement[] gpaManagements;
	public static final String FILE_NAME = "transcripts.txt";

	public void inputMark() {
		if (StudentService.students.length == 0 && SubjectService.subjects.length == 0) {
			System.out.println("Please input student and subject first");
			return;
		}
		System.out.println("Please type student id you want to input mark");
		Student student = StudentService.findStudentFromId();
		Transcript[] transcripts = createTranscript();
		if (transcripts == null) {
			return;
		}
		GpaManagement gpaManagement = new GpaManagement(student, transcripts);
		addGpaManagementToArray(gpaManagement);
		Controller.fileUtil.writeDataToFile(gpaManagements, FILE_NAME);
	}

	public void addGpaManagementToArray(GpaManagement gpaManagement) {
		for (int i = 0; i < gpaManagements.length; i++) {
			if (DataUtil.isNullOrEmpty(gpaManagements[i])) {
				gpaManagements[i] = gpaManagement;
				break;
			}
		}
	}

	public int returnNotNullSubject() {
		int count = 0;
		for (int i = 0; i < SubjectService.subjects.length; i++) {
			if (!DataUtil.isNullOrEmpty(SubjectService.subjects[i])) {
				count++;
			}
		}
		return count;
	}

	public Transcript[] createTranscript() {
		if (returnNotNullSubject() == 0) {
			System.out.println("Please add subject first!");
			return null;
		}
		System.out.println("please type number of subject (maximunm-" + returnNotNullSubject() + ")");
		int numOfSubject = InputNumberUtil.returnInt();
		Transcript[] transcripts = new Transcript[numOfSubject];
		do {
			for (int i = 0; i < numOfSubject; i++) {
				Subject subject = SubjectService.findSubjectFromId();
				System.out.println("input mark");
				float mark = InputNumberUtil.returnFloatVar();
				Transcript transcript = new Transcript();
				transcript.setSubject(subject);
				transcript.setMark(mark);
				transcripts[i] = transcript;
			}
			return transcripts;
		} while (numOfSubject > returnNotNullSubject());

	}

	public void showGpaTrans() {
		for (int i = 0; i < gpaManagements.length; i++) {
			GpaManagement gpaManagement = gpaManagements[i];
			if (DataUtil.isNullOrEmpty(gpaManagement)) {
				break;
			}
			System.out.println(gpaManagement);
		}
	}

	public void calculateGpa() {
		Student student = StudentService.findStudentFromId();
		for (int i = 0; i < gpaManagements.length; i++) {
			if (!DataUtil.isNullOrEmpty(gpaManagements[i])) {
				if (student.getStudentId() == gpaManagements[i].getStudent().getStudentId()) {
					System.out.println(gpaManagements[i].getAveragemark());
					break;
				}
			}
		}
	}

	public void sortGpaFromStudentname() {
		for (int i = 0; i < gpaManagements.length - 1; i++) {
			if (!DataUtil.isNullOrEmpty(gpaManagements[i])) {
				String studentName = gpaManagements[i].getStudent().getFullName();
				int minPos = i;
				for (int j = i + 1; j < gpaManagements.length; j++) {
					if (!DataUtil.isNullOrEmpty(gpaManagements[j])) {
						String studentName2 = gpaManagements[j].getStudent().getFullName();
						if (studentName.compareTo(studentName2) > 0) {
							minPos = j;
						}
					}

					GpaManagement temp = gpaManagements[minPos];
					gpaManagements[minPos] = gpaManagements[i];
					gpaManagements[i] = temp;
				}
			}
		}
		Controller.fileUtil.writeDataToFile(gpaManagements, FILE_NAME);
	}

}
