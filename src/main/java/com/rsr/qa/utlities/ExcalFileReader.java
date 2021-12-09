package com.rsr.qa.utlities;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcalFileReader  {
	private FileInputStream fis;
	private FileOutputStream fileOut;
	private static String wb;
	public static String url;
	private Sheet sh;
	private Cell cell;
	private Row row;
	private CellStyle cellstyle;
	private Color mycolor;
	private String excelFilePath;
	private Map<String, Integer> columns = new HashMap<String, Integer>();
	
	public void setExcelFile(String ExcelPath, String SheetName) throws Exception {
		try {
			  String urlStr = "https://eic-capacity-planner.s3.us-east-2.amazonaws.com/IntegrationTesting/Resources/scenario_input.xlsx";
		        URL url = new URL(urlStr);
		        URLConnection uc = url.openConnection();
		        uc.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		       
		        Workbook wb = new XSSFWorkbook(uc.getInputStream());
		    // System.out.println("text:"+wb);
			//File fis = new File(ExcelPath);
			//wb = WorkbookFactory.create(fis);
			sh = wb.getSheet(SheetName);
			//sh = wb.getSheetAt(0); //0 - index of 1st sheet
			/*if (sh == null) {
				sh = wb.createSheet(SheetName);
			}*/
				
			this.excelFilePath = ExcelPath;
			
		//sh.getRow(0).forEach(cell ->{columns.put(cell.getStringCellValue(), cell.getColumnIndex());});
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			}
		}
		
	public String getCellData(int rownum, int column) throws Exception
	{
		try {
			cell = sh.getRow(rownum).getCell(column);
			String CellData = null;
			switch(cell.getCellType()) {
			case STRING:
			CellData=cell.getStringCellValue();
			break;
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(cell)) {
					CellData=String.valueOf(cell.getDateCellValue());
				}
				else {
					CellData=String.valueOf((double)cell.getNumericCellValue());
				}
				break;
			case BOOLEAN:
				CellData=Boolean.toString(cell.getBooleanCellValue());
				break;
			case BLANK:
				CellData="";
				break;
			default:
				break;
			}
			return CellData;
		}catch (Exception e){return "";}
		}
	
	
	 public String getCellData(String columnName,int rownum)throws Exception{
		return getCellData(rownum,columns.get(columnName));
		
	}
	 
	 public static void main(String [] args) throws Exception {
		 ExcalFileReader excel=new ExcalFileReader();
		 excel.setExcelFile(wb, "ScenarioInput");
		 System.out.println(excel.getCellData(4,1));
		// System.out.println(excel.getCellData(26, 1));
		// System.out.println(excel.getCellData(1, 1));
		
	 }


	}
			
	


