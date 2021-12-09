package com.rsr.qa.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rsr.qa.base.TestBase;

public class ApplicationConfiguration extends TestBase{
	
	@FindBy(xpath="//*[@id=\"navbarToggleExternalContent\"]/div/ul/li[2]/a")  //xpath of App config button

	@CacheLookup
	private WebElement appconfig;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[1]/input")
	@CacheLookup
	private WebElement ListofDomain;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[2]/input")
	@CacheLookup
	private WebElement SMTPHost;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[3]/input")
	@CacheLookup
	private WebElement SMTPport;
	
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[4]/input")
	@CacheLookup
	private WebElement RSR_MailerId;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[5]/input")
	@CacheLookup
	private WebElement RSR_MailerPassword;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[6]/input")
	@CacheLookup
	private WebElement Adminuser;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[7]/input")
	@CacheLookup
	private WebElement Questionparams;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[8]/input")
	@CacheLookup
	private WebElement FileUpload;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[9]/input")
	@CacheLookup
	private WebElement Outputfiles;
	
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[10]/button")
	//@FindBy(xpath="//*[@class=\"btn\"]/parent::div")
	@CacheLookup
	private WebElement submit;
	
	// /html/body/div[4]/div/div/button
	
	@FindBy(xpath="/html/body/div[4]/div/div/button")
	@CacheLookup
	private WebElement closepopup;
	
	
    //methods
	
	public ApplicationConfiguration() throws IOException{
		PageFactory.initElements(driver, this);
			
	}
	
	public void AppConfig() {
		
		appconfig.click();	
	}
		
	public void ListofDomainNames(String DomainName) {
		ListofDomain.clear();
		ListofDomain.sendKeys(DomainName);
		
	}
	public void SMTPServerHost(String Host) {
		SMTPHost.clear();
		SMTPHost.sendKeys(Host);
		
	}
	public void SMTPServerPort(String Port) {
		SMTPport.clear();
		SMTPport.sendKeys(Port);
	}
	
	public void RSMailerId(String Mailid) {
		RSR_MailerId.clear();
	    RSR_MailerId.sendKeys(Mailid);
			
		}
	
	public void RSMailerpassword(String Password) {
		RSR_MailerPassword.clear();
		RSR_MailerPassword.sendKeys(Password);
	}
	
	public void AdminMail(String Email) {
		Adminuser.clear();
		Adminuser.sendKeys(Email);
	}
	public void QuestionsQueryParams(String params) {
		Questionparams.clear();
		Questionparams.sendKeys(params);
	}
	
	public void FileuploadQueryParams(String Fileparams) {
		FileUpload.clear();
		FileUpload.sendKeys(Fileparams);
	}
	
	public void OutputFiles(String outputFilesList) {
		Outputfiles.clear();
		Outputfiles.sendKeys(outputFilesList);
		}
    
	public void Submit(){
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
	    executor2.executeScript("arguments[0].click();", submit);
					
	}
	public void SavedData() {
		closepopup.click();	
	}
}
