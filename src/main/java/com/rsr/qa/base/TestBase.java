package com.rsr.qa.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rsr.qa.utlities.ExcalFileReader;
import com.rsr.qa.utlities.TestUtil;

import io.github.bonigarcia.wdm.online.Downloader;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static  Logger logger;
	public static String userDir = System.getProperty("user.dir");
	public static String sep = System.getProperty("file.separator");
				
	
	public TestBase() throws IOException {
			
			/*	try {			
			prop =new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+sep+"Configuration"+sep+"config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
*/
	}
			
		
		@SuppressWarnings("deprecation")
		public  static void initialization() throws Exception {
					
			logger=Logger.getLogger("EIC Testing");
			PropertyConfigurator.configure("log4j.properties");
			//String browsername=prop.getProperty("browser");
		  //if(browsername.equals("chrome")) 
	   		 // {	}
	   		  
			String userDir = System.getProperty("user.dir");
			String sep = System.getProperty("file.separator");		
			 System.setProperty("webdriver.chrome.driver",userDir +sep +"Drivers"+sep+"chromedriver");
			// System.setProperty("webdriver.chrome.driver",userDir+sep+"Drivers"+sep+"chromedriver.exe");
			 
			 
			// driver=new ChromeDriver();
				ChromeOptions Options = new ChromeOptions();
          Options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
           driver = new ChromeDriver(Options);
		       
         
        String downloadFilepath = userDir +sep+ "DownloadFiles";
 		Map<String, Object> preferences = new Hashtable<String, Object>();
 		preferences.put("profile.default_content_settings.popups", 0);
 		preferences.put("download.prompt_for_download", "false");
 		preferences.put("download.default_directory", downloadFilepath);

 		// disable flash and the PDF viewer
 		//preferences.put("plugins.plugins_disabled", new String[]{
 		//    "Adobe Flash Player", "Chrome PDF Viewer"});

  		Options.setExperimentalOption("prefs", preferences);
 		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
 		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
 		capabilities.setCapability(ChromeOptions.CAPABILITY, Options);
 		Options.merge(capabilities);
 		// driver = new ChromeDriver(Options);
 		driver = new ChromeDriver(capabilities);
 				 				 
		//}*/
		
		driver.manage().window().maximize();
		//logger.info("wimdow maximized");
		driver.manage().deleteAllCookies();
	   driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
 	   driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
 	  logger.info("Waiting for URL");
  	 
 	   Thread.sleep(5000);
  	 File file = new File(userDir +sep+ "DownloadFiles"+sep+ "RSRExcel.xlsx");
     FileInputStream iFile = new FileInputStream(file);

     XSSFWorkbook wb = new XSSFWorkbook(iFile);
     XSSFSheet sheet = wb.getSheet("SignUp");
     int rowCount = sheet.getLastRowNum();
     String URL = sheet.getRow(0).getCell(1).getStringCellValue();
     
  	 /*String filepath= System.getProperty("user.dir")+sep+"DownloadFiles"+sep+"scenario_input.xlsx";
 	  ExcalFileReader excel=new ExcalFileReader();
	   excel.setExcelFile(filepath,"LoginData");
		// System.out.println(excel.getCellData(0,1));
 	    String URL= excel.getCellData(0, 1);*/
         
 	    driver.get(URL);
 	    
 	  // driver.get(prop.getProperty("url"));
         
 	   logger.info("Entered URL");
 	      	 	    	    
		}	
			
	@AfterMethod
	public void captureScreen(ITestResult result)throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File trg=new File(System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png");
				
		FileUtils.copyFile(src,trg);
			
			System.out.println("Screenshot captured...........");
		}	
	}
	
	

	}
	
