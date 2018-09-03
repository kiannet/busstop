package com.company.writer;

import com.company.entity.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterForFile {

    public void writeToFile(String filePath, List<Service> poshList, List<Service> grottyList){

        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);


        for(Service poshService : poshList) {
            writer.write( poshService.toString() + System.getProperty("line.separator"));
        }

        writer.write(System.getProperty("line.separator"));

        for(Service grottyService : grottyList) {
            writer.write(grottyService.toString() + System.getProperty("line.separator"));
        }

        writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception!");
        }
    }
}
