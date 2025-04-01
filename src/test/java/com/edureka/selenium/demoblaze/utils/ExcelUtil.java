package com.edureka.selenium.demoblaze.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * This class is part of the Demoblaze automation framework.
 */
public class ExcelUtil {

    public static String getCellData(String fileName, String sheetName, int rowNum, int colNum) {
        String value = "";
        try {
            // Adjust the path if needed
            String filePath = "src/test/resources/testdata/" + fileName;
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);

            if (cell != null) {
                cell.setCellType(CellType.STRING); // Force all to string
                value = cell.getStringCellValue();
            }

            workbook.close();
            fis.close();
        } catch (Exception e) {
            System.out.println("❌ Failed to read Excel data: " + e.getMessage());
        }
        return value;
    }
}
