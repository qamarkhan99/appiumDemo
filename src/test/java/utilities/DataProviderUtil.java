package utilities;

import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;
import java.util.Hashtable;
import static base.AppFactory.excel;


public class DataProviderUtil {

    @DataProvider(name="dp")
    public Object[][] getData(Method m) {

        String sheetName = m.getName();
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);

        Object[][] data = new Object[rows - 1][1];

        Hashtable<String,String> table = null;

        for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

            table = new Hashtable<>();

            for (int colNum = 0; colNum < cols; colNum++) {

                // data[0][0]
                table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
                data[rowNum - 2][0] = table;
            }

        }

        return data;

    }
}
