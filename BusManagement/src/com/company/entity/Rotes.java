package com.company.entity;

import java.util.List;

public class Rotes {
    private Driver driver;
    private List<RouteAndTimes> routeAndTimes;

    public Rotes() {
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<RouteAndTimes> getRouteAndTimes() {
        return routeAndTimes;
    }

    public void setRouteAndTimes(List<RouteAndTimes> routeAndTimes) {
        this.routeAndTimes = routeAndTimes;
    }

    public int getTotalTask() {
        int sum = 0;
        for (int i = 0; i < routeAndTimes.size(); i++) {
            sum += routeAndTimes.get(i).getTimesDrive();
        }
        return sum;
    }

    public float getTotalDistance() {
        float sum = 0;
        for (int i = 0; i < routeAndTimes.size(); i++) {
            sum += routeAndTimes.get(i).getRoute().getDistance() * routeAndTimes.get(i).getTimesDrive();
        }
        return sum;
    }

    @Override
    public String toString() {
        return
                driver + ", " + routeAndTimes;
    }
}
