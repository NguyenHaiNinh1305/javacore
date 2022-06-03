package com.company.service.driverSer;

import com.company.Controller;
import com.company.entity.Driver;
import com.company.utils.DataUtil;
import com.company.utils.InputNumberUtil;

import java.util.List;

public class DriverService {
    public static List<Driver> drivers;
    public static final String FILE_NAME = "Drivers.txt";

    public void addDrivers() {
        System.out.println("Please enter number of Drivers");
        int num = InputNumberUtil.returnInt();
        for (int i = 0; i < num; i++) {
            Driver driver = new Driver();
            driver.input();
            drivers.add(driver);
        }
        Controller.fileUtil.writeFile(drivers, FILE_NAME);
    }

    public void showDriver() {
        for (int i = 0; i < drivers.size(); i++) {
            System.out.println(drivers.get(i));
        }
    }

    public static Driver findDriverFromId() {
        System.out.println("Enter Driver id");
        int id = InputNumberUtil.returnInt();
        for (int i = 0; i < drivers.size(); i++) {
            Driver driver = drivers.get(i);
            if (!DataUtil.isNullOrEmpty(driver)) {
                if (id == driver.getDriverID()) {
                    return driver;
                }
            }
        }
        return null;
    }
}
