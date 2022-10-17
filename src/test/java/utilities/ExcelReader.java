package utilities;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import static utilities.Constants.SUITE_XL_PATH;

public class ExcelReader {
    public FileInputStream fis;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public FileOutputStream fos;


    public ExcelReader() {
        try {
            fis = new FileInputStream(SUITE_XL_PATH);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            String str =setCellData();
            setCellDataForLogout(str);
     //       fis.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
        public int getRowCount(String sheetName){
            int index = workbook.getSheetIndex(sheetName);
            if(index==-1)
                return 0;
            else{
                sheet = workbook.getSheetAt(index);
                int number=sheet.getLastRowNum()+1;
                return number;
            }

        }

        // returns number of columns in a sheet
        public int getColumnCount(String sheetName){
            // check if sheet exists

            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0);

            if(row==null)
                return -1;

            return row.getLastCellNum();

        }

        // returns the data from a cell
        public String getCellData(String sheetName,int colNum,int rowNum){
            try{
                if(rowNum <=0)
                    return "";

                int index = workbook.getSheetIndex(sheetName);

                if(index==-1)
                    return "";


                sheet = workbook.getSheetAt(index);
                row = sheet.getRow(rowNum-1);
                if(row==null)
                    return "";
                cell = row.getCell(colNum);
                if(cell==null)
                    return "";

                if(cell.getCellType()== CellType.STRING)
                    return cell.getStringCellValue();
                else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA ){

                    String cellText  = String.valueOf(cell.getNumericCellValue());

                    return cellText;
                }else if(cell.getCellType()==CellType.BLANK)
                    return "";
                else
                    return String.valueOf(cell.getBooleanCellValue());
            }
            catch(Exception e){

                e.printStackTrace();
                return "row "+rowNum+" or column "+colNum +" does not exist  in xlsx";
            }
        }

    public String setCellData() throws IOException {
        String data = Common_Utilities.generateRandomEmail(15);
        System.out.println("login email" +data);
        sheet = workbook.getSheet("loginTest");
        row = sheet.getRow(1);
        cell = row.createCell(0);
        cell.setCellValue(data);
        fos = new FileOutputStream(SUITE_XL_PATH);
        workbook.write(fos);
        return data;

    }
    public void setCellDataForLogout(String data) throws IOException {
        sheet = workbook.getSheet("logoutTest");
        row = sheet.getRow(2);
        cell = row.createCell(0);
        cell.setCellValue(data);
        fos = new FileOutputStream(SUITE_XL_PATH);
        workbook.write(fos);

    }
}
