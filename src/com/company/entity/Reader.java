package com.company.entity;

import java.util.Scanner;

public class Reader extends Person {

    private int readerID = 10000;
    private TypeReader typeReader;

    public Reader() {
        super();
    }

    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }

    public TypeReader getTypeReader() {
        return typeReader;
    }

    public void setTypeReader(TypeReader typeReader) {
        this.typeReader = typeReader;
    }

    @Override
    public String toString() {
        return super.toString() +
                "readerID=" + readerID +
                ", typeReader=" + typeReader;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc;

        System.out.println("Pleas choose type reader 1-student 2-graduatedStudent 3-teacher ");

        boolean check = false;
        do {
            sc = new Scanner(System.in);
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    typeReader = TypeReader.student;
                    check = true;
                    break;
                case 2:
                    typeReader = TypeReader.graduatedStudent;
                    check = true;
                    break;
                case 3:
                    typeReader = TypeReader.teacher;
                    check = true;
                    break;
                default:
                    System.out.println("Have no selection for this number");
                    System.out.println("Please re-type");
                    break;
            }
        } while (check == false);

    }
}
