package com.rsr.qa.testcases;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.rsr.qa.base.TestBase;
import com.rsr.qa.pages.SignUpPage;
import com.rsr.qa.utlities.ExcalFileReader;

public class SignUpTest extends TestBase {
	
	SignUpPage signupPage;
	ExcalFileReader ExcalFileReader;
	
	
	public SignUpTest() throws IOException{
		super();
	}
	
	
    @Test
	public void setup() throws Exception {		
			initialization();
			signupPage =new SignUpPage();
		}
    
    
    @Test(priority=1)
    public void signupbutton() {
    	signupPage.SignupBut();
    }
     
		
	@Test(priority=2)
	public void FirstName() throws Exception {		
		  String userDir = System.getProperty("user.dir");
	      String sep = System.getProperty("file.separator");	
	      File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
          FileInputStream iFile = new FileInputStream(file);
          XSSFWorkbook wb = new XSSFWorkbook(iFile);
          XSSFSheet sheet = wb.getSheet("SignUp");
          int rowCount = sheet.getLastRowNum();		  
          String firstname = sheet.getRow(1).getCell(1).getStringCellValue();
          System.out.println("f name: "+firstname);
          signupPage.FirstName(firstname);
        }
	
	@Test (priority=3)
	public void LastName() throws Exception {		
		  String userDir = System.getProperty("user.dir");
	      String sep = System.getProperty("file.separator");	      
	      File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
          FileInputStream iFile = new FileInputStream(file);
          XSSFWorkbook wb = new XSSFWorkbook(iFile);
          XSSFSheet sheet = wb.getSheet("SignUp");
          int rowCount = sheet.getLastRowNum();
          String lastname = sheet.getRow(2).getCell(1).getStringCellValue();
          System.out.println("last name : "+lastname);
          signupPage.LastName(lastname);
            
	}
	
	@Test (priority=4)
	public void OrganizationName() throws Exception {			
		  String userDir = System.getProperty("user.dir");
	      String sep = System.getProperty("file.separator");	      
	      File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
          FileInputStream iFile = new FileInputStream(file);
          XSSFWorkbook wb = new XSSFWorkbook(iFile);
          XSSFSheet sheet = wb.getSheet("SignUp");
          int rowCount = sheet.getLastRowNum();        
          String organizationname = sheet.getRow(3).getCell(1).getStringCellValue();
          System.out.println("Oranization name : "+organizationname);
          signupPage.OrganizationName(organizationname);
	}
	
	
	@Test (priority=5)
	public void Phone() throws Exception {
		  String userDir = System.getProperty("user.dir");
	      String sep = System.getProperty("file.separator");		      
	      File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
          FileInputStream iFile = new FileInputStream(file);
          XSSFWorkbook wb = new XSSFWorkbook(iFile);
          XSSFSheet sheet = wb.getSheet("SignUp");
          int rowCount = sheet.getLastRowNum(); 
          XSSFCell phoneNo =sheet.getRow(4).getCell(1);	
          if(!phoneNo.getStringCellValue().equals("")){
          String phoneNo1= phoneNo.getStringCellValue();
	        System.out.println("phone number :"+phoneNo1);
      	      //String FarmSize = String.valueOf(phoneNo1);
              signupPage.Phone(phoneNo1);
             }else {
  	         logger.info("User Not ginen Phone Number");
          } 
	}
       
          
	@Test (priority=6)
	public void EmailAddress() throws Exception {		
		  String userDir = System.getProperty("user.dir");
	      String sep = System.getProperty("file.separator");	
	      File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
          FileInputStream iFile = new FileInputStream(file);
          XSSFWorkbook wb = new XSSFWorkbook(iFile);
          XSSFSheet sheet = wb.getSheet("SignUp");
          int rowCount = sheet.getLastRowNum();
          String eaddress = sheet.getRow(5).getCell(1).getStringCellValue();
          signupPage.EmailAddress(eaddress);
	}
	
	@Test (priority=7)
	public void Password() throws Exception {
		 String userDir = System.getProperty("user.dir");
	     String sep = System.getProperty("file.separator");	
	     File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
         FileInputStream iFile = new FileInputStream(file);
         XSSFWorkbook wb = new XSSFWorkbook(iFile);
         XSSFSheet sheet = wb.getSheet("SignUp");
         int rowCount = sheet.getLastRowNum();
         String password = sheet.getRow(6).getCell(1).getStringCellValue();
         signupPage.Password(password);
            
	}
	
	
	@Test (priority=8)
	public void CPassword() throws Exception {
		 String userDir = System.getProperty("user.dir");
	     String sep = System.getProperty("file.separator");	
	     File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
         FileInputStream iFile = new FileInputStream(file);
         XSSFWorkbook wb = new XSSFWorkbook(iFile);
         XSSFSheet sheet = wb.getSheet("SignUp");
         int rowCount = sheet.getLastRowNum();
         String password = sheet.getRow(6).getCell(1).getStringCellValue();
         String confirmpassword = sheet.getRow(7).getCell(1).getStringCellValue();
       if(password==confirmpassword) {  
    	signupPage.CPassword(confirmpassword);
        logger.info("both passwords are matched");
         	}
        else {
         		Assert.assertEquals(password,confirmpassword);         		
         		logger.info(" password and confirmpassword are not equal");
               	}
        
	}
	
	@Test (priority=9)
	public void CName() throws Exception {
	     String userDir = System.getProperty("user.dir");
	     String sep = System.getProperty("file.separator");	
	     File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
         FileInputStream iFile = new FileInputStream(file);
         XSSFWorkbook wb = new XSSFWorkbook(iFile);
         XSSFSheet sheet = wb.getSheet("SignUp");
         int rowCount = sheet.getLastRowNum();
         String conferencename = sheet.getRow(8).getCell(1).getStringCellValue();
         signupPage.CName(conferencename);
	}
	
	@Test (priority=11)
	public void CUrl() throws Exception {
		 String userDir = System.getProperty("user.dir");
	     String sep = System.getProperty("file.separator");	
	     File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
         FileInputStream iFile = new FileInputStream(file);
         XSSFWorkbook wb = new XSSFWorkbook(iFile);
         XSSFSheet sheet = wb.getSheet("SignUp");
         int rowCount = sheet.getLastRowNum();         
         XSSFCell curl =sheet.getRow(9).getCell(1);	
         if(!curl.getStringCellValue().equals("")){
	        String curl1= curl.getStringCellValue();
	        System.out.println("phone number :"+curl1);
     	     // String FarmSize = String.valueOf(phoneNo1);
             signupPage.Phone(curl1);
             
              }else {
 	         logger.info("Conference URL Not Available");
         } 
                 
         
	}
	
	@Test (priority=12)
	public void RoleInConference() throws Exception {
		  signupPage.RoleInConference();
	}
       
	
	
	
  //@Test(priority=14)
	public void StartDate() throws IOException, InterruptedException {
	 signupPage.StartDateFinal();
	
}	
	
//	@Test(priority=15)
	public void EndDate() throws IOException {
		signupPage.EndDateFinal();
	}
	
	
	@Test (priority=18)
		public void SSS() throws Exception {			
	        signupPage.SSS();
		}
		@Test(priority=20)
	     public void radiobutton() throws InterruptedException {
			
		  signupPage.RadioButton();
			
		}
	@Test(priority=21)	
	public void ReCapthabut() {
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		signupPage.rC();
	}
	
	@Test(priority=26)
     public void signup() throws InterruptedException, IOException {
	
		
		signupPage.SignUp();
		
	 
}
	
	@Test(priority=27)
	public void HomePage() {
		signupPage.HomePage();
	}
	
	
	
	//@Test(priority=30)
	public void Teardown() {
		driver.close();
	}
	
}
            
           
       /*     
        //Selection of Start Date
    		String month ="December 2021";
    		String date ="10";
    	    
    		WebElement wait = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[11]/div[1]/div/input"));
    	   JavascriptExecutor executor2 = (JavascriptExecutor)driver;
    	    executor2.executeScript("arguments[0].click();", wait);
    	    
    		while(true)
    		{
    			String text=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[11]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]")).getText();
    		    
    			
    			if(text.equals(month) )
    			{
    				break;
    			}
    			else
    			{
    				WebElement wait2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[11]/div[2]/div[2]/div/div/button[2]"));
    				JavascriptExecutor executor3 = (JavascriptExecutor)driver;
    			    executor3.executeScript("arguments[0].click();", wait2);
    			}
    			
    			
    		}
    		 
    		WebElement wait3 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[11]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[contains(text(),"+date+")]"));
    		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
    	    executor4.executeScript("arguments[0].click();", wait3);
    		
    	    
    	    //End Date Selection
    	    String month1 ="December 2021";
    		String date1 ="15";
    	    
    		WebElement wait4 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[12]/div[1]/div/input"));
    		JavascriptExecutor executor5 = (JavascriptExecutor)driver;
    		executor2.executeScript("arguments[0].click();", wait4);
           
    		while(true)
    		{
    			String text1=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[12]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]")).getText();
    		    if(text1.equals(month1))
    		    {
    		    	break;
    		    }
    		    else
    		    {
    		    	WebElement wait5 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[12]/div[2]/div[2]/div/div/button"));
    				JavascriptExecutor executor6 = (JavascriptExecutor)driver;
    			    executor6.executeScript("arguments[0].click();", wait5);
    		    }
    		    
    		}
    			
    		WebElement wait6 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[12]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[contains(text(),"+date1+")]"));
    		JavascriptExecutor executor7 = (JavascriptExecutor)driver;
    	    executor7.executeScript("arguments[0].click();", wait6);
           
        
            
    /*        
                        
            
            
            
            
          //  scenarioInformation=loginPage.login(username,password); 
            /*String filepath="";
		   ExcalFileReader excel=new ExcalFileReader();
		   excel.setExcelFile(filepath, "LoginData");
		    String username= excel.getCellData(1, 1);
		   String password= excel.getCellData(2, 1);*/
          
	
	
	
	/*
	@Test(priority=2)
	
	public void PageTitel() throws InterruptedException{
		logger.info("valid page titel");
		String Titel=loginPage.validationpagetite();
		logger.info("valid page titel");
		Thread.sleep(1000);
		Assert.assertEquals(Titel,"CapacityPlanner");
				
	}	
				
	 @Test(priority=4)
		public void energyprofilelink() throws InterruptedException {
		 Thread.sleep(1000);
		 loginPage.clickEnergyProfilesLink();
		
	  }
	 @Test(priority=5)
    public void Loadprofile() throws InterruptedException {
    	logger.info("valid page titel");
    	Thread.sleep(1000);
    	logger.info("valid page titel");
	    loginPage.clickLoadProfilesLink();
      } {
*/
	

