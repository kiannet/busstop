package com.company.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {
    private String regexp = "[A-Za-z]+ (([0,1][0-9])|(2[0-3])):[0-5][0-9] (([0,1][0-9])|(2[0-3])):[0-5][0-9]";

    public boolean validateString(String string){
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
