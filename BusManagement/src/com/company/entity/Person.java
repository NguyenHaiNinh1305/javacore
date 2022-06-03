package com.company.entity;

import com.company.service.driverSer.PersonSer;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable, PersonSer {

    private String name, address, phonneNum;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonneNum() {
        return phonneNum;
    }

    public void setPhonneNum(String phonneNum) {
        this.phonneNum = phonneNum;
    }


    @Override
    public void input() {
        Scanner sc;
        System.out.println("Input full name: ");
        sc = new Scanner(System.in);
        name = sc.nextLine();
        System.out.println("Input address: ");
        sc = new Scanner(System.in);
        address = sc.nextLine();
        System.out.println("Input phone Number: ");
        phonneNum = sc.nextLine();
    }

    @Override
    public String toString() {
        return
                "name=" + name +
                        ", address=" + address +
                        ", phonneNum=" + phonneNum
                ;
    }
}
