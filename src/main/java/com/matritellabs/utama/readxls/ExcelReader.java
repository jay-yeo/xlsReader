package com.matritellabs.utama.readxls;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReader {

    private static String filePath;
    private static Workbook xlsFile;

    // Constructor
    public ExcelReader(String filePath) throws IOException, InvalidFormatException {
        this.filePath = filePath;
        setExcelFile();
    }


    // Open .xlsx file and set .xlsxFile field
    public void setExcelFile() throws IOException, InvalidFormatException {
        // Open .xls file
        Workbook workbook = WorkbookFactory.create(new File(filePath));

        this.xlsFile = workbook;
    }

    // Close .xls file
    public void closeExcelFile() throws IOException {
        // Close file
        xlsFile.close();
    }

    // Read the first column of each worksheet
    public void viewFirstCol() {

        // DataFormatter to format cell values as String
        DataFormatter dataFormatter = new DataFormatter();

        // Loop through sheets and rows, printing results
        for(Sheet sheet: xlsFile) {
            System.out.println("\nSHEET: " + sheet.getSheetName().toUpperCase());
            for (Row row: sheet) {
                for(Cell cell: row) {
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.print(cellValue);
                }
                System.out.println();
            }
        }

    }

}