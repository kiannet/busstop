package com.company.entity;

import java.time.LocalTime;

public class Service {
    private String company;
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public String getCompany() {
        return company;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return company + " " + departureTime + " " + arrivalTime;
    }
}
