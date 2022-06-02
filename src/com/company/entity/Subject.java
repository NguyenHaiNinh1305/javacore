package com.company.entity;

import com.company.utils.InputNumberUtil;

import java.io.Serializable;
import java.util.Scanner;

public class Subject implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int ID;
    private int subjectId = 10000;
    private String subjectName;
    private int creadits;
    private TypeSubject typeSubject;
    Scanner sc;


    public Subject() {
    }

    public Subject(int subjectId, String subjectName, int creadits, TypeSubject typeSubject) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.creadits = creadits;
        this.typeSubject = typeSubject;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCreadits() {
        return creadits;
    }

    public void setCreadits(int creadits) {
        this.creadits = creadits;
    }

    public TypeSubject getTypeSubject() {
        return typeSubject;
    }

    public void setTypeSubject(TypeSubject typeSubject) {
        this.typeSubject = typeSubject;
    }

    public void inputSubjectInfo() {
        System.out.println("Input subject name: ");
        sc = new Scanner(System.in);
        subjectName = sc.nextLine();

        System.out.println("Input number of creadits: ");
        creadits = InputNumberUtil.returnInt();
        System.out.println("Pleas choose type reader 1-generalSubject 2-basicSubject 3-specializedSubject ");
        boolean check = false;
        do {
            int choose = InputNumberUtil.returnInt();
            switch (choose) {
                case 1:
                    typeSubject = TypeSubject.generalSubject;
                    check = true;
                    break;
                case 2:
                    typeSubject = TypeSubject.basicSubject;
                    check = true;
                    break;
                case 3:
                    typeSubject = TypeSubject.specializedSubject;
                    check = true;
                    break;
                default:
                    System.out.println("Have no selection for this number");
                    System.out.println(("Please re-type!"));
                    break;
            }
        } while (check == false);
    }


    @Override
    public String toString() {
        return
                "subjectId=" + subjectId +
                        ", subjectName=" + subjectName +
                        ", creadits=" + creadits +
                        ", typeSubject=" + typeSubject
                ;
    }


}
