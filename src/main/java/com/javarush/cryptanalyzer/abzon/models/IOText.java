package com.javarush.cryptanalyzer.abzon.models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class IOText {
    public final static String fileName = "\\Output_%s";
    public final static String DEFAULT_PATH_OUTPUT = "./src/main/resources/defaultIO/outPutUa";
    public final static String DEFAULT_PATH_INPUT = "./src/main/resources/defaultIO/InPutUa";

    public void writeToFile(String outputString, String pathToFile) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream( this.getFileName(pathToFile) + ".txt");
        fileOutputStream.write(outputString.getBytes());
        fileOutputStream.close();
    }

    private String getFileName(String pathToFile) {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        return String.format(pathToFile, dateTime.format(date));
    }

    public String readFromFile(String pathToFile) throws IOException {
        File file = new File(pathToFile + ".txt");
        Scanner scanner = new Scanner(file);
        StringBuilder result = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result.append(line);
        }
        scanner.close();
        return result.toString();
    }
}
