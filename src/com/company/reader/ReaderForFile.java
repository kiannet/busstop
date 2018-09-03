package com.company.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReaderForFile {
    private List<String> strings = new ArrayList<>();

    public void readFile(String filePath){

        try{
            FileInputStream fileInputStream = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                strings.add(strLine);
            }
        }catch (IOException e){
            System.out.println("Exception!");
        }

    }

    public List<String> getStrings() {
        return strings;
    }
}
