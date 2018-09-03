package com.company.comparator;

import com.company.entity.Service;

import java.util.Comparator;

public class TimeComparator implements Comparator<Service> {


    public int compare(Service service1, Service service2){

            if(service1.getDepartureTime().isAfter(service2.getDepartureTime()))
                return 1;
            else if(service1.getDepartureTime().isBefore(service2.getDepartureTime()))
                return -1;
            else
                return 0;
    }

}
