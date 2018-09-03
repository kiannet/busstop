package com.company;

import com.company.comparator.TimeComparator;
import com.company.entity.Service;
import com.company.logic.SorterForServices;
import com.company.parser.StringParser;
import com.company.reader.ReaderForFile;
import com.company.writer.WriterForFile;

import java.util.Collections;
import java.util.List;

public class Main {
    private static String inputFilePath = "./src/com/company/file/input.txt";
    private static String outputFilePath = "./src/com/company/file/output.txt";

    public static void main(String[] args) {
        ReaderForFile readerForFile = new ReaderForFile();
        readerForFile.readFile(inputFilePath); //считывание файла

        List<String> strings = readerForFile.getStrings(); //формирование списка строк из файла

        StringParser stringParser = new StringParser();
        List<Service> services = stringParser.parseStrings(strings); //преобразование строк в объекты Service

        SorterForServices sorterForServices = new SorterForServices();

        List<Service> servicesWithoutLongOnes = sorterForServices.removeLongServices(services); //удаление поездок длительностью больше часа

        List<Service> servicesWithoutNotEfficientOnes = sorterForServices.removeNotEfficientServices(servicesWithoutLongOnes); //удаление не самых быстрых поездок в сравнении с остальными

        sorterForServices.divideSevicesByCompanies(servicesWithoutNotEfficientOnes); //разделение поездок на два списка - компании Grotty и компании Posh

        sorterForServices.removeTheSameTimeService(); //удаление поездок компании Grotty, если у Posh есть такая же поездка

        Collections.sort(sorterForServices.getGrottyServices(), new TimeComparator()); //сортировка по времени
        Collections.sort(sorterForServices.getPoshServices(), new TimeComparator()); //сортировка по времени


        WriterForFile writerForFile = new WriterForFile();
        writerForFile.writeToFile(outputFilePath, sorterForServices.getPoshServices(), sorterForServices.getGrottyServices()); //запись результатов в файл

    }
}
