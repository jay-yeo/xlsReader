import com.matritellabs.utama.readxls.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.IOException;

// xlsReader - https://github.com/jay-yeo/xlsReader
public class Main {

    // Main method
    public static void main(String[] args) throws IOException, InvalidFormatException {

        // Open .xls file
        ExcelReader xlsFile = new ExcelReader("tmp/files/jutott_neki.xls");

        // Run view function
        xlsFile.viewFirstCol();

        // Close .xls file
        xlsFile.closeExcelFile();

    }

}
