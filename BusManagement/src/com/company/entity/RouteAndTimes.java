package com.company.entity;

public class RouteAndTimes {
    private Route route;
    private int timesDrive;

    public RouteAndTimes(Route route, int timesDrive) {
        this.route = route;
        this.timesDrive = timesDrive;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getTimesDrive() {
        return timesDrive;
    }

    public void setTimesDrive(int timesDrive) {
        this.timesDrive = timesDrive;
    }

    @Override
    public String toString() {
        return
                "route=" + route +
                ", timesDrive=" + timesDrive;
    }
}
