package com.matritellabs.utama.readxls;

import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;

// ExcelReader class
public class ExcelReader {

    private static Workbook xlsFile;
    private final static Logger log = LoggerFactory.getLogger(ExcelReader.class);

    // Constructor
    public ExcelReader(String filePath) {
        setExcelFile(filePath);
    }


    // Open Excel file and set .xls File field
    public void setExcelFile(String filePath) {
        // Open .xls file
        try {
            Workbook workbook = WorkbookFactory.create(new File(filePath));

            xlsFile = workbook;

            // Log new file
            log.info("New ExcelReader instance with " + filePath + " file");

        } catch (Exception ex) {
            // Log exception
            log.error(ex.toString());
        }

    }

    // Close .xls file
    public void closeExcelFile() {
        try {
            // Close file
            xlsFile.close();

            // Log close file
            log.info("Closing file");
        } catch (Exception ex) {
            // Log exception
            log.error(ex.toString());
        }
    }

    // Read the first column of each worksheet
    public void viewFirstCol() {

        // DataFormatter to format cell values as String
        DataFormatter dataFormatter = new DataFormatter();

        // Loop through sheets and rows, printing results
        for(Sheet sheet: xlsFile) {
            System.out.println("\n" + sheet.getSheetName().toUpperCase());
            for (Row row: sheet) {
                for(Cell cell: row) {
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.print(cellValue);
                }
                System.out.println();
            }
        }

        // Log
        log.info("Successfully printed results!");


    }

}