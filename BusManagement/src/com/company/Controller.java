package com.company;

import com.company.entity.Driver;
import com.company.entity.Rotes;
import com.company.entity.Route;
import com.company.service.driverSer.DriverService;
import com.company.service.rosterSer.RosterService;
import com.company.service.routeSer.RouterService;
import com.company.utils.DataUtil;
import com.company.utils.File.FileUtil;
import com.company.utils.InputNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static FileUtil fileUtil = new FileUtil();
    public static DriverService driverService = new DriverService();
    public static RosterService rosterService = new RosterService();
    public static RouterService routerService = new RouterService();

    private void initializedData() {
        Object driverData = fileUtil.readeFile(DriverService.FILE_NAME);
        DriverService.drivers
                = DataUtil.isNullOrEmpty(driverData) ? new ArrayList<>() : (List<Driver>) driverData;

        Object routerData = fileUtil.readeFile(RouterService.FILE_NAME);
        RouterService.routes
                = DataUtil.isNullOrEmpty(routerData) ? new ArrayList<>() : (List<Route>) routerData;

        Object rosterData = fileUtil.readeFile(RosterService.FILE_NAME);
        RosterService.rotesList
                = DataUtil.isNullOrEmpty(rosterData) ? new ArrayList<>() : (List<Rotes>) rosterData;
    }

    public void processTask() {
        initializedData();
        int choose = 0;
        do {
            showMenu();
            choose = InputNumberUtil.returnInt();
            switch (choose) {
                case 1:
                    driverService.addDrivers();
                    break;
                case 2:
                    routerService.addRoutes();
                    break;
                case 3:
                    rosterService.assignTasks();
                    break;
                case 4:
                    rosterService.sortTaskListFromDriverName();
                    break;
                case 5:
                    rosterService.returnTotalDistanceOfDrivers();
                    break;
                case 6:
                    driverService.showDriver();
                    break;
                case 7:
                    routerService.showRoutes();
                    break;
                case 8:
                    rosterService.showAssignTaskList();
                    break;
                case 10:
                    System.out.println("finish");
                    return;
                default:
                    System.out.println("Please re-type correct selection");
                    break;
            }
        } while (choose != 10);
    }

    public static void showMenu() {
        System.out.println("/****************************************/");
        System.out.println("1. Add Drivers.\n" + "2. Add Routes.\n" + "3. Assign tasks.\n"
                + "4. Sort task list from driver name.\n" + "5. Calculate Total distances of drivers.\n" + "6. Load all Drivers from file.\n"
                + "7. Load all Routes form file.\n" + "8. Load all roters form file.\n" + "10. Exit.");
        System.out.println("/****************************************/");
    }


}
