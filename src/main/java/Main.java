import com.matritellabs.utama.readxls.ExcelReader;

// xlsReader - https://github.com/jay-yeo/xlsReader
public class Main {

    // Main method
    public static void main(String[] args) {

        // Open .xls file
        ExcelReader xlsFile = new ExcelReader("tmp/files/jutott_neki.xls");

        // Run view function
        xlsFile.viewFirstCol();

        // Close .xls file
        xlsFile.closeExcelFile();

    }

}
