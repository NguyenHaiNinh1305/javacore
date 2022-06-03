package com.company.entity;

import com.company.utils.InputNumberUtil;

public class Driver extends Person {
    public static int ID = 10000;
    private int driverID;
    private Level level;

    public Driver() {
        super();
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        driverID = driverID;
    }


    public void input() {
        this.driverID = this.ID;
        this.ID++;
        super.input();
        System.out.println("Pleas type choose level 1-A 2-B 3-C 4-D 5-E 6-F ");
        boolean check = false;
        do {
            int choose = InputNumberUtil.returnInt();
            switch (choose) {
                case 1:
                    level = Level.A;
                    check = true;
                    break;
                case 2:
                    level = Level.B;
                    check = true;
                    break;
                case 3:
                    level = Level.C;
                    check = true;
                    break;
                case 4:
                    level = Level.D;
                    check = true;
                    break;
                case 5:
                    level = Level.E;
                    check = true;
                    break;
                case 6:
                    level = Level.F;
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
        return "driverID=" + driverID + ", " +
                super.toString() +
                ", level=" + level;
    }
}
