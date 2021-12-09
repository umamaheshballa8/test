package com.rsr.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.rsr.qa.base.TestBase;

public class SigninPage extends TestBase{
	

	
	@FindBy(xpath="//*[@id=\"headermenu\"]/ul/li[3]/a")
	@CacheLookup
	  WebElement signinelement;
	
	//pageFactory
	
	@FindBy(name="email")
	@CacheLookup
	  WebElement username;
	
	
	@FindBy(name="password")
	@CacheLookup
	 private WebElement password;
	
	@FindBy(xpath="//*[@id=\"recaptcha-anchor-label\"]")
	@CacheLookup
	  private WebElement reCaptch;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div[4]/button[1]")
    @CacheLookup
    private WebElement loginBtn;
	
	
	
	//create methods
	
	//Initiation
	
	public SigninPage() throws IOException{
		PageFactory.initElements(driver, this);
			
	}
	
	
	
	public  void SignInBut() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 signinelement.click();	
	}
	
	//actions
	public String validationpagetite() {
		
		return driver.getTitle();
	}
	
	public void login(String un,String pwd) throws IOException, InterruptedException {
		
		username.sendKeys(un);
		password.sendKeys(pwd);				
		WebElement btnElement = driver.findElement(By.cssSelector("button.btn-submit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled')", btnElement);
		driver.findElement(By.cssSelector("button.btn-submit")).click();
		loginBtn.click();	
				
	}
	


		
}
