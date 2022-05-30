package com.company.entity;

import com.company.service.PersonInterface;

import java.util.Scanner;

public class Person implements PersonInterface {

    private String fullName;
    private String address;
    private String phoneNumber;


    public Person() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    @Override
    public String toString() {
        return
                "fullName='" + fullName + '\'' +
                        ", address='" + address + '\'' +
                        ", phoneNumber='" + phoneNumber + '\''
                ;
    }

    @Override
    public void input() {
        Scanner sc;
        System.out.println("Input full name: ");
        sc = new Scanner(System.in);
        fullName = sc.nextLine();
        System.out.println("Input address: ");
        sc = new Scanner(System.in);
        address = sc.nextLine();
        System.out.println("Input phone Number: ");
        phoneNumber = sc.nextLine();
    }
}
