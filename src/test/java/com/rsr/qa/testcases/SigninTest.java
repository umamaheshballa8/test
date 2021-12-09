package com.rsr.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.rsr.qa.base.TestBase;
import com.rsr.qa.pages.SignUpPage;
import com.rsr.qa.pages.SigninPage;
import com.rsr.qa.utlities.ExcalFileReader;

public class SigninTest extends TestBase {
	SignUpPage signupPage;
	ExcalFileReader ExcalFileReader;
	SigninPage signinpage;
	public SigninTest() throws IOException {
		super();
		}

	 @Test
		public void setup() throws Exception {	
		        initialization();
				signinpage= new SigninPage();
				signupPage = new SignUpPage();
			}
	    
	 @Test(priority=1)
	    public void clickinBut() throws InterruptedException {
		 signinpage.SignInBut();
	    }
	 @Test(priority=2)
		public void loginTest() throws Exception {
					
			  String userDir = System.getProperty("user.dir");
		      String sep = System.getProperty("file.separator");			      
		      File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
	          FileInputStream iFile = new FileInputStream(file);
	          XSSFWorkbook wb = new XSSFWorkbook(iFile);
	          XSSFSheet sheet = wb.getSheet("admin");
   	          int rowCount = sheet.getLastRowNum();
		      String username = sheet.getRow(0).getCell(1).getStringCellValue();
	            System.out.println("Username data  :"+username);
	            String password = sheet.getRow(1).getCell(1).getStringCellValue();
	            System.out.println("password data:"+password);
	            signinpage.login(username,password); 
	            
		}
	

}
