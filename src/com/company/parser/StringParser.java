package com.company.parser;

import com.company.entity.Service;
import com.company.validator.StringValidator;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {

    private StringValidator stringValidator = new StringValidator();

    public List<Service> parseStrings(List<String> strings){

        List<Service> services = new ArrayList<>();

        for (int i = 0; i < strings.size(); i++){
            if (stringValidator.validateString(strings.get(i))) {
                String[] words;
                words = strings.get(i).split(" ");
                List<String> wordsList = new ArrayList<>(Arrays.asList(words));
                Service service = new Service();
                service.setCompany(wordsList.get(0));
                service.setDepartureTime(LocalTime.parse(wordsList.get(1)));
                service.setArrivalTime(LocalTime.parse(wordsList.get(2)));

                services.add(service);
            }
            else {
                System.out.println("Incorrect string format!");
            }
        }

        return services;
    }

}
