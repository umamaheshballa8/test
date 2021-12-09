package excelExportAndFileIO;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo22 {

    public void readExcel(String filePath,String fileName,String sheetName) throws IOException{
    	 String path="C:\\Users\\HP\\eclipse-workspace\\Eic_testing\\src\\main\\java\\com\\eic\\qa\\testdata\\Book1.xlsx";
      File file =    new File(path);

      FileInputStream inputStream = new FileInputStream(file);

    Workbook Demo22 = null;

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

       if(fileExtensionName.equals(".xlsx")){

    	   Demo22 = new XSSFWorkbook(inputStream);

    }

    //Check condition if the file is xls file

    else if(fileExtensionName.equals(".xls")){

        //If it is xls file then create object of HSSFWorkbook class

    	Demo22 = new HSSFWorkbook(inputStream);

    }

    //Read sheet inside the workbook by its name

    Sheet Sheet1 = Demo22.getSheet(sheetName);

    //Find number of rows in excel file

    int rowCount = Sheet1.getLastRowNum()-Sheet1.getFirstRowNum();

    //Create a loop over all the rows of excel file to read it

    for (int i = 0; i < rowCount+1; i++) {

        Row row = Sheet1.getRow(i);

        //Create a loop to print cell values in a row

        for (int j = 0; j < row.getLastCellNum(); j++) {

            //Print Excel data in console

            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

        }

        System.out.println();
    } 

    }  

    //Main function is calling readExcel function to read data from excel file

    public static void main(String...strings) throws IOException{

    //Create an object of ReadGuru99ExcelFile class

    	Demo22 objExcelFile = new Demo22();

    //Prepare the path of excel file

    String filePath = "C:\\Users\\HP\\eclipse-workspace\\Eic_testing\\src\\main\\java\\com\\eic\\qa\\testdata";

    //Call read file method of the class to read data

    objExcelFile.readExcel(filePath,"Book2.xlsx","Sheet1");

    }

}