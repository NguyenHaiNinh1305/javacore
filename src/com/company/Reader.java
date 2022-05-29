package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    private String fullName;
    private int readerID = 43674;
    private String address;
    private String phoneNumber;
    private TypeReader typeReader;

    Scanner sc = new Scanner(System.in);

    public void inputReaderInfo() {

        System.out.println("Input full name: ");
        fullName = sc.nextLine();
        System.out.println("Input address: ");
        address = sc.nextLine();
        System.out.println("Input phone Number: ");
        phoneNumber = sc.nextLine();
        System.out.println("Pleas choose type reader 1-student 2-graduatedStudent 3-teacher ");
        int choose = sc.nextInt();
        switch (choose) {
            case 1:
                typeReader = TypeReader.student;
                break;
            case 2:
                typeReader = TypeReader.graduatedStudent;
                break;
            case 3:
                typeReader = TypeReader.teacher;
                break;
            default:
                System.out.println("Have no selection for this number");
                break;
        }


    }

    public Reader() {
    }

    public Reader(String fullName, int readerID, String address, String phoneNumber, TypeReader typeReader) {
        this.fullName = fullName;
        this.readerID = readerID;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.typeReader = typeReader;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getReaderID() {
        return readerID++;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TypeReader getTypeReader() {
        return typeReader;
    }

    public void setTypeReader(TypeReader typeReader) {
        this.typeReader = typeReader;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "fullName='" + fullName + '\'' +
                ", readerID=" + readerID +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", typeReader=" + typeReader +
                '}';
    }
}