package com.rsr.qa.pages;


	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

	import com.rsr.qa.base.TestBase;

	public class SignUpPage extends TestBase{
		
		@FindBy(xpath="//*[@id=\"headermenu\"]/ul/li[4]/a")
		@CacheLookup
		private WebElement signupebut;
		
		
		//pageFactory
		
		@FindBy(name="fName")
		@CacheLookup
		private WebElement First_Name;
		
		
		@FindBy(name="lname")
		@CacheLookup
		private WebElement Last_Name;
		
		@FindBy(name="orgName")
	    @CacheLookup
	    private
	     WebElement OrgName;
		
		@FindBy(name="phNo")
	    @CacheLookup
		static
	     WebElement PhoneNum;
		

		@FindBy(name="email")
	    @CacheLookup
		static
	     WebElement Email;
		
		@FindBy(name="pass")
	    @CacheLookup
		static
	     WebElement password;
		
		@FindBy(name="cnfrmPass")
	    @CacheLookup
		static
	     WebElement Confirm_Password;
		
		@FindBy(name="cnfrncName")
	    @CacheLookup
		static
	     WebElement ConferenceName;
		
		
		@FindBy(id="exampleFormControlSelect1")
		
		private WebElement conferencedropDown;
		
		@FindBy(name="cnfrncURL")
		@CacheLookup
		static
		WebElement ConferenceURL;
		
		@FindBy(name="cnfrncRole")
		@CacheLookup
		static
		WebElement ConferenceRole;
		
		
		
		@FindBy(name="startDate")
		@CacheLookup
		static
		WebElement StartDate;
		
		@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div/div/a")
		@CacheLookup
		private WebElement Homepage;
		
		@FindBy(name="endDate")
		@CacheLookup
		static
		WebElement EndDate;
		
		
		
		@FindBy(name="SubmitionSys")
	    @CacheLookup
		private WebElement SelectSubmissionSystem;
		
		
		@FindBy(xpath="//*[@class=\"checkmark\"]")
		//@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/div/form/div[14]/div/label/span")
	    @CacheLookup
		private WebElement RadioBtn;
		
		//*[@id="recaptcha-anchor"]/div[1]
		
		@FindBy(xpath="//*[@id=\"recaptcha-anchor\"]/div[1]")
	    @CacheLookup
		static
	     WebElement ReCaptcha;
		
		@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[16]/button")
	    @CacheLookup
		private WebElement SignUpBtn;
		
		
		@FindBy(xpath="//*[@id=\"showFormError\"]/div")
		@CacheLookup
		private WebElement emailreistered;
		
		
		@FindBy(xpath ="//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[11]/div[1]/div/input" )	
		static WebElement Start_Date_Click ;

		@FindBy(xpath ="//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[11]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]")	
		static WebElement Start_MonthYear ;

		@FindBy(xpath ="//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[11]/div[2]/div[2]/div/div/button[2]")	
		static WebElement ClickForwardButton ;

		@FindBy(xpath ="//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[11]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[contains(text())]")	
		static WebElement SelectDate;

	
		
		
		//create methods
		
		//Initiation
		
		public SignUpPage() throws IOException{
			PageFactory.initElements(driver, this);
				
		}
		
		
		//actions
		
		
		public void SignupBut() {
			
			signupebut.click();	
		}
		public String validationpagetite() {
			
			return driver.getTitle();
		}
		
		public void FirstName(String FName) {
			
			First_Name.sendKeys(FName);
		}
		
        public void LastName(String LName) {
			
			Last_Name.sendKeys(LName);
		}
        
        public void OrganizationName(String Org_Name) {
        	OrgName.sendKeys(Org_Name);
        }
        
        public void Phone(String phone) {
        	PhoneNum.sendKeys(phone);
        }
        
        public void EmailAddress(String emailAddress) {
        	Email.sendKeys(emailAddress);
        }
        
        public void Password(String passwordfield) {
        	password.sendKeys(passwordfield);
        }
        
        public void CPassword(String cpassword) {
        	Confirm_Password.sendKeys(cpassword);
        }
        
        public void CName(String cname) {
        	ConferenceName.sendKeys(cname);
        }
        
        public void CUrl(String curl) {
        	ConferenceURL.sendKeys(curl);
        }
        
        public void RoleInConference() throws IOException, InterruptedException {
	    	String userDir = System.getProperty("user.dir");
		    String sep = System.getProperty("file.separator");
	    	Select Sel =new Select(conferencedropDown);	    	
	    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	String filepath= System.getProperty("user.dir")+sep+"DownloadFiles"+sep+"RSRExcel.xlsx";
	    	FileInputStream iFile = new FileInputStream(filepath);
	        XSSFWorkbook wb = new XSSFWorkbook(iFile);
	        XSSFSheet sheet = wb.getSheet("SignUp");
	        int rowCount = sheet.getLastRowNum();
	    	String RoleinConf = sheet.getRow(10).getCell(1).getStringCellValue();
	        Sel.selectByVisibleText(RoleinConf);
	            	           
        }
   
        
       public void StartDate(String month,String date) throws InterruptedException {
        	
        	Thread.sleep(5000);
        	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);                                   
    		WebElement wait =Start_Date_Click; 
    	    JavascriptExecutor executor2 = (JavascriptExecutor)driver;
    	    executor2.executeScript("arguments[0].click();", wait);
    	    
    		while(true)
    		{
    		//	String text=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[11]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]")).getText();
    			WebElement Month = Start_MonthYear;
    			String monthtext = Month.getText();
    			
    			if(monthtext.equals(month) )
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
    		
    		// WebElement wait3 = SelectDate"+date+")];
    		
    		WebElement wait3 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[11]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[contains(text(),"+date+")]"));
    		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
    	    executor4.executeScript("arguments[0].click();", wait3);
    		
    	    

        	
        } 
        
        
         public void EDate(String edate) {
        	EndDate.sendKeys(edate);
        } 
        
        public void SSS() throws IOException {       	
        	String userDir = System.getProperty("user.dir");
		    String sep = System.getProperty("file.separator");
	    	Select Sel =new Select(SelectSubmissionSystem);	    	
	    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	String filepath= System.getProperty("user.dir")+sep+"DownloadFiles"+sep+"RSRExcel.xlsx";
	    	FileInputStream iFile = new FileInputStream(filepath);
	        XSSFWorkbook wb = new XSSFWorkbook(iFile);
	        XSSFSheet sheet = wb.getSheet("SignUp");
	        int rowCount = sheet.getLastRowNum();
	    	String sss1 = sheet.getRow(13).getCell(1).getStringCellValue();
	        Sel.selectByVisibleText(sss1);
        	        	
        }
        
        public void RadioButton(){              	
   
        	
        	JavascriptExecutor executor = (JavascriptExecutor)driver;
        	executor.executeScript("arguments[0].click();", RadioBtn);
       /// RadioBtn.click();	
      
		}
        
        public void HomePage() {
        	Homepage.click();
        }
        
        public void rC() {
        	WebElement btnElement = driver.findElement(By.cssSelector("button.btn-loader"));
        	((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled')", btnElement);
    		driver.findElement(By.cssSelector("button.btn-loader")).click();
		}
        
        public void SignUp() throws InterruptedException, IOException {
        	String handle=driver.getWindowHandle();
        	System.out.println("wind handle:"+handle);
        	  	String gt=driver.getTitle();
        	  SignUpBtn.click();
        	  Thread.sleep(5000);
        	  String handle1=driver.getWindowHandle();
        	  System.out.println("new wind handle:"+handle1);
        	Thread.sleep(1000);
        	String gt1=driver.getTitle();
        	System.out.println(gt+" "+gt1);
        
           if(!handle.equals(handle1)) {
			String acttext=driver.findElement(By.xpath("//*[@id=\"showFormError\"]/div")).getText();
			 String exptext= "This email id is already registered";
			 System.out.println("act data :"+acttext);
			 System.out.println("exp data :"+exptext);
			 Assert.assertEquals(acttext,exptext);
			   driver.navigate().refresh();
         }        	
		else{        	
		   String acttext1=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/h3")).getText();           	  	
		  	String exptext1= "Thanks for the registration!";
		   	Assert.assertEquals(acttext1,exptext1);
		   	
         }
         
		}


		public void StartDateFinal() throws IOException, InterruptedException {
        String month ="December 2021";
    	String date ="30";    	    
    	String userDir = System.getProperty("user.dir");
   	    String sep = System.getProperty("file.separator");	   	      
   	    File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
        FileInputStream iFile = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(iFile);
        XSSFSheet sheet = wb.getSheet("SignUp");
        int rowCount = sheet.getLastRowNum();                
        String month1 = sheet.getRow(11).getCell(1).getStringCellValue();
        System.out.println("Excel Month" +month1);
        String date1 = sheet.getRow(11).getCell(2).getStringCellValue();
          // int date =Integer.parseInt(date);  
           System.out.println("Excel Date" +date);
         //*[@id="root"]/div/div/div[2]/div/div/form/div[11]/div[1]/div/input
            WebElement wait = driver.findElement(By.xpath("//input[@name=\"startDate\"]"));
    	  JavascriptExecutor executor2 = (JavascriptExecutor)driver;
    	   executor2.executeScript("arguments[0].click();", wait);
          
          // driver.findElement(By.xpath("//input[@name=\"startDate\"]"));
    	    Thread.sleep(10000);
    	    System.out.println("mahesh");
    	while(true)    		{
    			String text=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[11]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]")).getText();
    		  System.out.println("text date :"+text);
    			if(text.equals(month1))
    			{
    				break;
    			}
    			else
    			{
    				WebElement wait2 = driver.findElement(By.xpath("react-datepicker__navigation react-datepicker__navigation--next"));
    				JavascriptExecutor executor3 = (JavascriptExecutor)driver;
    			    executor3.executeScript("arguments[0].click();", wait2);
    			}
    			  			
    		}
     		WebElement wait3 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[11]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[contains(text()"+date+")]"));
    		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
    	    executor4.executeScript("arguments[0].click();", wait3);
            }
        
        
        
        
        public void EndDateFinal() throws IOException {
        	String month1 ="December 2022";
    		String date1 ="20";
    		 String userDir = System.getProperty("user.dir");
      	      String sep = System.getProperty("file.separator");	   	      
      	      File file = new File(userDir +sep+ "DownloadFiles" +sep+ "RSRExcel.xlsx");
             FileInputStream iFile = new FileInputStream(file);
           XSSFWorkbook wb = new XSSFWorkbook(iFile);
           XSSFSheet sheet = wb.getSheet("SignUp");
           int rowCount = sheet.getLastRowNum();                
             //String month1 = sheet.getRow(11).getCell(1).getStringCellValue();
                System.out.println("Excel Month: " +month1);
            //   String date1 = sheet.getRow(11).getCell(2).getStringCellValue();
             //  String date1 =Integer.parseInt(date1);  
              System.out.println("Excel Date : " +date1);    //getStringCellValue();
    	    
    		WebElement wait4 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[12]/div[1]/div/input"));
    		JavascriptExecutor executor5 = (JavascriptExecutor)driver;
    		executor5.executeScript("arguments[0].click();", wait4);
           
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
        }
        
        
        
     
        
        
}
