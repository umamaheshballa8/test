package com.rsr.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.rsr.qa.base.TestBase;
import com.rsr.qa.pages.ApplicationConfiguration;
import com.rsr.qa.pages.SignUpPage;
import com.rsr.qa.pages.SigninPage;
import com.rsr.qa.pages.userinfoPage;
import com.rsr.qa.utlities.ExcalFileReader;

public class ApplicationConfigurationTest extends TestBase{
	SignUpPage signupPage;
	ExcalFileReader ExcalFileReader;
	SigninPage signinpage;
	userinfoPage userinfopage;
	ApplicationConfiguration appConfig;

	public ApplicationConfigurationTest() throws IOException {
		super();
		
	}

	@Test
	public void setup() throws Exception {
		userinfopage=new userinfoPage();
		signupPage =new SignUpPage();
		signinpage =new SigninPage();
		ExcalFileReader ExcalFileReader;		   
		appConfig = new ApplicationConfiguration();
	  }

	 //@Test(priority=1)
	    public void clickinBut() throws InterruptedException {
		 signinpage.SignInBut();
	    }
	     

		//@Test(priority=2)
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

	@Test(priority=3)
	public void AppConfigModule() {
		appConfig.AppConfig();
	}



	@Test (priority=4)
	public void ListOfDomainNames() throws Exception {


		String userDir = System.getProperty("user.dir");
		String sep = System.getProperty("file.separator");	

		File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
		FileInputStream iFile = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(iFile);
		XSSFSheet sheet = wb.getSheet("App Configuration");

		int rowCount = sheet.getLastRowNum();

		String domains = sheet.getRow(0).getCell(1).getStringCellValue();
		appConfig.ListofDomainNames(domains);
	}


	@Test (priority=5)
	public void SMTP_Server_Host() throws Exception {


		String userDir = System.getProperty("user.dir");
		String sep = System.getProperty("file.separator");	

		File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
		FileInputStream iFile = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(iFile);
		XSSFSheet sheet = wb.getSheet("App Configuration");

		int rowCount = sheet.getLastRowNum();

		String serverHost = sheet.getRow(1).getCell(1).getStringCellValue();
		appConfig.SMTPServerHost(serverHost);
	}




	@Test (priority=6)
	public void SMTP_Server_Port() throws Exception {


		String userDir = System.getProperty("user.dir");
		String sep = System.getProperty("file.separator");	

		File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
		FileInputStream iFile = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(iFile);
		XSSFSheet sheet = wb.getSheet("App Configuration");

		int rowCount = sheet.getLastRowNum();

		DataFormatter formatter = new DataFormatter();
		String val = formatter.formatCellValue(sheet.getRow(2).getCell(1));
		
		appConfig.SMTPServerPort(val);
	}

	//	 @Test (priority=6)
	/*	public void SMTP_Server_Port() throws Exception {


			  String userDir = System.getProperty("user.dir");
		      String sep = System.getProperty("file.separator");	

		      File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
	        FileInputStream iFile = new FileInputStream(file);

	      XSSFWorkbook wb = new XSSFWorkbook(iFile);
	      XSSFSheet sheet = wb.getSheet("App Configuration");

	      int rowCount = sheet.getLastRowNum();

	      String serverPort = sheet.getRow(2).getCell(1).getStringCellValue();
	            appConfig.SMTPServerPort(serverPort);
		}
	 */	 


	@Test (priority=7)
	public void ReviewerScopeMailerId() throws Exception {


		String userDir = System.getProperty("user.dir");
		String sep = System.getProperty("file.separator");	

		File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
		FileInputStream iFile = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(iFile);
		XSSFSheet sheet = wb.getSheet("App Configuration");

		int rowCount = sheet.getLastRowNum();

		String mailId = sheet.getRow(3).getCell(1).getStringCellValue();
		appConfig.RSMailerId(mailId);
	}


	@Test (priority=8)
	public void ReviewerScopeMailerPassword() throws Exception {


		String userDir = System.getProperty("user.dir");
		String sep = System.getProperty("file.separator");	

		File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
		FileInputStream iFile = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(iFile);
		XSSFSheet sheet = wb.getSheet("App Configuration");

		int rowCount = sheet.getLastRowNum();

		String password = sheet.getRow(4).getCell(1).getStringCellValue();
		appConfig.RSMailerpassword(password);
	}


	@Test (priority=9)
	public void AdminUserEmail() throws Exception {


		String userDir = System.getProperty("user.dir");
		String sep = System.getProperty("file.separator");	

		File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
		FileInputStream iFile = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(iFile);
		XSSFSheet sheet = wb.getSheet("App Configuration");

		int rowCount = sheet.getLastRowNum();

		String adminUser = sheet.getRow(5).getCell(1).getStringCellValue();
		appConfig.AdminMail(adminUser);
	}


	@Test (priority=10)
	public void Question_Query_params() throws Exception {


		String userDir = System.getProperty("user.dir");
		String sep = System.getProperty("file.separator");	

		File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
		FileInputStream iFile = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(iFile);
		XSSFSheet sheet = wb.getSheet("App Configuration");

		int rowCount = sheet.getLastRowNum();

		String query = sheet.getRow(6).getCell(1).getStringCellValue();
		appConfig.QuestionsQueryParams(query);
	}

	@Test (priority=11)
	public void File_upload_Query_params() throws Exception {


		String userDir = System.getProperty("user.dir");
		String sep = System.getProperty("file.separator");	

		File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
		FileInputStream iFile = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(iFile);
		XSSFSheet sheet = wb.getSheet("App Configuration");

		int rowCount = sheet.getLastRowNum();

		String fileuploadquery = sheet.getRow(7).getCell(1).getStringCellValue();
		appConfig.FileuploadQueryParams(fileuploadquery);
	}

	@Test (priority=12)
	public void Output_files_list() throws Exception {


		String userDir = System.getProperty("user.dir");
		String sep = System.getProperty("file.separator");	

		File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
		FileInputStream iFile = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(iFile);
		XSSFSheet sheet = wb.getSheet("App Configuration");

		int rowCount = sheet.getLastRowNum();

		String outputfiles = sheet.getRow(8).getCell(1).getStringCellValue();
		appConfig.OutputFiles(outputfiles);
	}
	
	@Test(priority=13)
	public void SubmitButton(){
		appConfig.Submit();
	}
	
	
	@Test(priority=14)
	public void CloseSavedDataPopup() throws InterruptedException {
		appConfig.SavedData();
	}

}
