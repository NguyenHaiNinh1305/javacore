package com.company.service.RouteAndTimeSer;

import com.company.entity.Driver;
import com.company.entity.Route;
import com.company.entity.RouteAndTimes;
import com.company.service.driverSer.DriverService;
import com.company.service.rosterSer.RosterService;
import com.company.service.routeSer.RouterService;
import com.company.utils.InputNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class RouteAndTimeService {

    public static List<RouteAndTimes> createRouteAndTimes(Driver driver) {
        int num = 0;
        do {
            System.out.println("Enter number of route assign task to driver");
            num = InputNumberUtil.returnInt();
        } while (num > RouterService.routes.size());
        List<RouteAndTimes> routeAndTimesList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Route route = null;
            do {
                route = RouterService.findRouterFromId();
            } while (route == null);
            int numOfTask = RosterService.returnInputNumOfTask(driver);
            RouteAndTimes routeAndTimes = new RouteAndTimes(route, numOfTask);
            routeAndTimesList.add(routeAndTimes);
        }
        return routeAndTimesList;
    }

}
