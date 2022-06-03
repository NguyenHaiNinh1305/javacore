package com.company.entity;

import com.company.utils.InputNumberUtil;

public class Route {

    public static int ID = 100;
    private int routeId;
    private float distance;
    private int busStop;

    public Route() {
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getBusStop() {
        return busStop;
    }

    public void setBusStop(int busStop) {
        this.busStop = busStop;
    }

    @Override
    public String toString() {
        return
                "routeId=" + routeId +
                ", distance=" + distance +
                ", busStop=" + busStop ;
    }

    public void input(){
       this.routeId = this.ID;
        this.ID++;
        System.out.println("Input distance: ");
        distance =  InputNumberUtil.returnFloatVar();
        System.out.println("Input number of busstop: ");
        busStop = InputNumberUtil.returnInt();
    }
}
