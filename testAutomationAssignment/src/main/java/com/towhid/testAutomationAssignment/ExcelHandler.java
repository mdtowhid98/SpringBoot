package com.towhid.testAutomationAssignment;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelHandler {
    private static final String FILE_PATH = "C:\\Users\\Admin\\Desktop\\[Task.xlsx]Sheet1"; // Change this path to your file path

    // Read the data from the specific tab based on today's day
    public static String[] getDataForToday() throws IOException {
        FileInputStream fis = new FileInputStream(new File(FILE_PATH));
        Workbook workbook = new XSSFWorkbook(fis);

        // Get current day of the week
        String currentDay = new SimpleDateFormat("EEEE").format(new Date());
        Sheet sheet = workbook.getSheet(currentDay);

        int rowCount = sheet.getPhysicalNumberOfRows();
        String[] keywords = new String[rowCount - 1];

        for (int i = 1; i < rowCount; i++) { // Skip header row
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0); // Assuming data is in the first column
            keywords[i - 1] = cell.getStringCellValue();
        }

        workbook.close();
        return keywords;
    }

    // Write the longest and shortest suggestions back to the Excel file
    public static void writeResults(String keyword, String longest, String shortest) throws IOException {
        FileInputStream fis = new FileInputStream(new File(FILE_PATH));
        Workbook workbook = new XSSFWorkbook(fis);

        String currentDay = new SimpleDateFormat("EEEE").format(new Date());
        Sheet sheet = workbook.getSheet(currentDay);

        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            Cell keywordCell = row.getCell(0);

            if (keywordCell.getStringCellValue().equals(keyword)) {
                row.createCell(1).setCellValue(longest); // Column 2 for Longest
                row.createCell(2).setCellValue(shortest); // Column 3 for Shortest
                break;
            }
        }

        fis.close();
        FileOutputStream fos = new FileOutputStream(FILE_PATH);
        workbook.write(fos);
        workbook.close();
        fos.close();
    }
}
