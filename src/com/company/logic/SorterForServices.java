package com.company.logic;

import com.company.constant.Company;
import com.company.entity.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SorterForServices {
    private List<Service> grottyServices = new ArrayList<>();
    private List<Service> poshServices = new ArrayList<>();

    public List<Service> getGrottyServices() {
        return grottyServices;
    }

    public List<Service> getPoshServices() {
        return poshServices;
    }

    public void divideSevicesByCompanies(List<Service> services){

        for (int i = 0; i < services.size(); i++){
            if(services.get(i).getCompany().equals(Company.GROTTY)){
                grottyServices.add(services.get(i));
            } else if(services.get(i).getCompany().equals(Company.POSH)){
                poshServices.add(services.get(i));
            }
        }

    }

    public List<Service> removeLongServices(List<Service> services){

        Iterator<Service> iterator = services.iterator();
        while (iterator.hasNext()) {
            Service service = iterator.next();
            int departureMinutes = service.getDepartureTime().getHour();
            int arrivalHour = service.getArrivalTime().getHour();

            //System.out.println(departureMinutes);
            //System.out.println(arrivalHour);

            if (arrivalHour - departureMinutes > 1){
                iterator.remove();
            }
        }

        return services;
    }

    public List<Service> removeNotEfficientServices(List<Service> services){

        for (int i = 0; i < services.size(); i++) {
            for (int j = 0; j < services.size(); j++) {
                if(services.get(i).getDepartureTime().equals(services.get(j).getDepartureTime())
                && services.get(i).getArrivalTime().isBefore(services.get(j).getArrivalTime())){
                    services.remove(services.get(j));
                }

                if(services.get(i).getArrivalTime().equals(services.get(j).getArrivalTime())
                        && services.get(i).getDepartureTime().isBefore(services.get(j).getDepartureTime())){
                    services.remove(services.get(i));
                }

                if(services.get(i).getArrivalTime().isBefore(services.get(j).getArrivalTime())
                        && services.get(i).getDepartureTime().isAfter(services.get(j).getDepartureTime())){
                    services.remove(services.get(j));
                }

            }
        }

        return services;
    }

    public void removeTheSameTimeService() {

        for (int i = 0; i < grottyServices.size(); i++) {
            for (int j = 0; j < poshServices.size(); j++) {
                if (grottyServices.get(i).getDepartureTime().equals(poshServices.get(j).getDepartureTime())
                        && grottyServices.get(i).getArrivalTime().equals(poshServices.get(j).getArrivalTime())) {

                    grottyServices.remove(i);
                }
            }
        }
    }

}
