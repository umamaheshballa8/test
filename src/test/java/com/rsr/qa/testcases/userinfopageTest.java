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
import com.rsr.qa.pages.SigninPage;
import com.rsr.qa.pages.userinfoPage;
import com.rsr.qa.utlities.ExcalFileReader;

 public class userinfopageTest extends TestBase{
   userinfoPage userinfopage;
   SigninPage signinpage;
   ExcalFileReader ExcalFileReader;
   SignUpPage signupPage;
 public userinfopageTest() throws IOException {
		super();
		
	}
@Test(priority=1)
	public void setup() throws Exception{		
	userinfopage=new userinfoPage();
	signupPage =new SignUpPage();
		signinpage =new SigninPage();
		}

     // @Test(priority = 1)
     public void UserInfoBaseTest() throws Exception {
	userinfopage.userInfoLinkClick();
       }

    @Test(priority = 2)
    public void UserInfoBaseTest1() throws Exception {
	 userinfopage.addNewUserLinkClick();
      }

    @Test(priority = 3)
     public void UserInfoBaseTest11() throws Exception {
	userinfopage.adminUserLinkClick();
      }

      @Test(priority = 4)
      public void AdminUserLogin() throws Exception{	
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   String userDir = System.getProperty("user.dir");
	   String sep = System.getProperty("file.separator");	
	   File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
       FileInputStream iFile = new FileInputStream(file);
       XSSFWorkbook wb = new XSSFWorkbook(iFile);
       XSSFSheet sheet = wb.getSheet("admin");
       int rowCount = sheet.getLastRowNum();          
        boolean adduser = sheet.getRow(3).getCell(1).getBooleanCellValue();
        if(adduser) {
        	userinfopage.adminradiobut();
        	
       String fristname =sheet.getRow(4).getCell(1).getStringCellValue();
       System.out.println(fristname);
       
       String lastname =sheet.getRow(5).getCell(1).getStringCellValue();
       System.out.println(lastname);
       String email =sheet.getRow(6).getCell(1).getStringCellValue();
       System.out.println(email);
       
       userinfopage.adminlogin(fristname, lastname, email);
            } 
      else {
	   System.out.println("user selected conference User Data");
          }
     }

@Test(priority=5)
public void confirencruser() throws Exception {		
	  String userDir = System.getProperty("user.dir");
    String sep = System.getProperty("file.separator");	
    File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
    FileInputStream iFile = new FileInputStream(file);
    XSSFWorkbook wb = new XSSFWorkbook(iFile);
    XSSFSheet sheet = wb.getSheet("admin");
    int rowCount = sheet.getLastRowNum();
    boolean adduser = sheet.getRow(3).getCell(1).getBooleanCellValue();
    if(!adduser) {    	
    	userinfopage.conferenceuserradiobtn();
    	Thread.sleep(5000);
    File file1 = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
    	    FileInputStream iFile1 = new FileInputStream(file1);
    	    XSSFWorkbook wb1 = new XSSFWorkbook(iFile1);
    	    XSSFSheet sheet1 = wb1.getSheet("SignUp");
    	    int rowCount1 = sheet1.getLastRowNum();
    	    String firstname = sheet1.getRow(1).getCell(1).getStringCellValue();
    	    System.out.println("f name: "+firstname);
            signupPage.FirstName(firstname);

            String lastname = sheet1.getRow(2).getCell(1).getStringCellValue();
            System.out.println("last name : "+lastname);
            signupPage.LastName(lastname);
              
  	   
            String organizationname = sheet1.getRow(3).getCell(1).getStringCellValue();
            System.out.println("Oranization name : "+organizationname);
            signupPage.OrganizationName(organizationname);

  	//phone
            XSSFCell phoneNo =sheet.getRow(4).getCell(1);	
            if(!phoneNo.getStringCellValue().equals("")){
            String phoneNo1= phoneNo.getStringCellValue();
  	        System.out.println("phone number :"+phoneNo1);
        	      //String FarmSize = String.valueOf(phoneNo1);
                signupPage.Phone(phoneNo1);
                  }else {
    	         logger.info("User Not ginen Phone Number");
                        }
         //email
            
  	      String eaddress = sheet1.getRow(5).getCell(1).getStringCellValue();
            signupPage.EmailAddress(eaddress);
  	
  	
  	//conferencename
  	
  	      String conferencename = sheet1.getRow(8).getCell(1).getStringCellValue();
           signupPage.CName(conferencename);
  	
  	//conferencenameurl
  		 
           XSSFCell curl =sheet1.getRow(9).getCell(1);	
           if(!curl.getStringCellValue().equals("")){
  	        String curl1= curl.getStringCellValue();
  	        System.out.println("phone number :"+curl1);
       	     // String FarmSize = String.valueOf(phoneNo1);
               signupPage.Phone(curl1);
               
                }else {
   	         logger.info("Conference URL Not Available");
           } 
    
    //RoleInConference       
      
  			  signupPage.RoleInConference();
  	
    //startdate
  	
  	         //signupPage.StartDateFinal();
  	
  	//enddate
  		//signupPage.EndDateFinal();

  	
  	//selectsubmissionsystem
  				
  	        signupPage.SSS();
  		
  		//signup
  		
  	      userinfopage.signinbutton();
    }
}
}

