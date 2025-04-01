package com.edureka.selenium.demoblaze.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class CSVReader {

    public static List<Map<String, String>> readCSV(String filePath) {
        List<Map<String, String>> testData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String[] headers = br.readLine().split(",");
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> row = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    row.put(headers[i].trim(), values[i].trim());
                }
                testData.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData;
    }
}
