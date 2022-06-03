package com.company.service.routeSer;

import com.company.Controller;
import com.company.entity.Route;
import com.company.utils.DataUtil;
import com.company.utils.InputNumberUtil;

import java.util.Arrays;
import java.util.List;

public class RouterService {

    public static List<Route> routes;
    public static final String FILE_NAME = "Routers.txt";

    public void addRoutes() {
        System.out.println("Please enter number of Routes");
        int num = InputNumberUtil.returnInt();
        for (int i = 0; i < num; i++) {
            Route route = new Route();
            route.input();
            routes.add(route);
        }
        Controller.fileUtil.writeFile(routes, FILE_NAME);
    }

    public void showRoutes() {
        for (int i = 0; i < routes.size(); i++) {
            System.out.println(routes.get(i));
        }
    }

    public static Route findRouterFromId() {
        System.out.println("Enter Route id");
        int id = InputNumberUtil.returnInt();
        for (int i = 0; i < routes.size(); i++) {
            Route route = routes.get(i);
            if (!DataUtil.isNullOrEmpty(route)) {
                if (id == route.getRouteId()) ;
                return route;
            }
        }
        return null;
    }
}
