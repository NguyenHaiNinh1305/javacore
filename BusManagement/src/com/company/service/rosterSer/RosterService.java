package com.company.service.rosterSer;

import com.company.Controller;
import com.company.entity.Driver;
import com.company.entity.Rotes;
import com.company.entity.RouteAndTimes;
import com.company.service.RouteAndTimeSer.RouteAndTimeService;
import com.company.service.driverSer.DriverService;
import com.company.service.routeSer.RouterService;
import com.company.utils.InputNumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RosterService {
    public static List<Rotes> rotesList;
    public static final String FILE_NAME = "Roters.txt";


    public void assignTasks() {
        if (DriverService.drivers.size() == 0 || RouterService.routes.size() == 0) {
            System.out.println("Please enter Driver and router first");
            return;
        }
        Driver driver = null;
        do {
            driver = DriverService.findDriverFromId();
        } while (driver == null);
        List<RouteAndTimes> routeAndTimes = new ArrayList<>();
        routeAndTimes = RouteAndTimeService.createRouteAndTimes(driver);
        Rotes rotes = new Rotes();
        rotes.setDriver(driver);
        rotes.setRouteAndTimes(routeAndTimes);
        rotesList.add(rotes);
        Controller.fileUtil.writeFile(rotesList, FILE_NAME);

    }

    public void showAssignTaskList() {
        for (int i = 0; i < rotesList.size(); i++) {
            System.out.println(rotesList.get(i).toString());
        }
    }

    public static int returnInputNumOfTask(Driver driver) {
        if (rotesList.size() > 0) {
            for (int i = 0; i < rotesList.size(); i++) {
                if (rotesList.get(i).getDriver().getDriverID() == driver.getDriverID()) {
                    int num = 0;
                    do {
                        System.out.println("Please enter num of task maximum " + (15 - rotesList.get(i).getTotalTask()));
                        num = InputNumberUtil.returnInt();
                        return num;
                    } while ((15 - rotesList.get(i).getTotalTask()) - num < 0);
                }
            }
        } else {
            int num = 0;
            do {
                System.out.println("Please enter num of task maximum " + "15");
                num = InputNumberUtil.returnInt();
                return num;
            } while (15 - num < 0);
        }
        return 0;
    }

    public void sortTaskListFromDriverName() {
//        Collections.sort(rotesList);
        rotesList.sort((Rotes r1, Rotes r2) -> r1.getDriver().getName().compareTo(r2.getDriver().getName()));
        Controller.fileUtil.writeFile(rotesList, FILE_NAME);
    }

    public void returnTotalDistanceOfDrivers() {
        if (rotesList.size() == 0) {
            System.out.println("Please input task first");
            return;
        }
        System.out.printf("%20s %20s %20s \n", "ID", "Name", "Total distance");
        for (Rotes rotes : rotesList) {
            System.out.printf("%20s %20s %20s \n"
                    , rotes.getDriver().getDriverID(), rotes.getDriver().getName(), rotes.getTotalDistance());
        }
    }

}
