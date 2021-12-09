package com.rsr.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rsr.qa.base.TestBase;

public class userinfoPage  extends TestBase {
	
	@FindBy(xpath ="//*[@id=\"navbarToggleExternalContent\"]/div/ul/li[1]/a")
	@CacheLookup
	private WebElement userInfoElement;
	
	@FindBy(xpath="//*[@id=\"navbarToggleExternalContent\"]/div/ul/li[2]/a")
	@CacheLookup
	private WebElement applicationlink;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/div[1]/div/div/button[1]")
	@CacheLookup
	private WebElement addNewUserElement;

	@FindBy(id = "adminuser")
	@CacheLookup
	private WebElement adminUserElement;

	@FindBy(id = "conferenceuser")
	@CacheLookup
	private WebElement ConferenceUserElement;
	
	@FindBy(name ="fName")
	@CacheLookup
	private WebElement FirstName;
	

	@FindBy(name = "lName")
	@CacheLookup
	private WebElement LastName;
	
	@FindBy(name = "email")
	@CacheLookup
	private WebElement email;
	
	@FindBy(xpath = "/html/body/div[4]/div/div/div/form/div[4]/button")
	@CacheLookup
	private WebElement submitButtonElement;

	
	@FindBy(id="adminuser")
	@CacheLookup
	private WebElement adminradiobtn;
	
	@FindBy(xpath="//*[@id=\"conferenceuser\"]")
	@CacheLookup
	private WebElement conferenceuser;
	
	
	@FindBy(xpath="//button[@class=\"btn btn-submit btn-loader\"]")
	private WebElement confsigninbtn;
	
	@FindBy(xpath="class=\"closeBtn\"")
	private WebElement closeconfuser;
	
	
     // Initiation
	public userinfoPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	
	// action click add new user

	public void addNewUserPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	
		public void userInfoLinkClick() throws InterruptedException {
			System.out.println("click on user info icon");
			Thread.sleep(5000);
			applicationlink.click();
			Thread.sleep(5000);
			System.out.println("click on user info icon");
			userInfoElement.click();
		}

	public void addNewUserLinkClick() {
		addNewUserElement.click();
	}

	
	public void adminUserLinkClick() {
		adminUserElement.click();
	}

	
	//action fill data to create new user
	public void adminlogin(String fName, String lName, String emailAddress) throws IOException, InterruptedException {

	     FirstName.sendKeys(fName);
		 LastName.sendKeys(lName);
		 email.sendKeys(emailAddress);
		 submitButtonElement.click();
        
	}
	
	public void adminradiobut() {
		boolean radio=adminradiobtn.isSelected();
		
		if(radio) {
		
		System.out.println("admin radio button is status :"+radio);
		
		}else {
			adminradiobtn.click();
		}
	}
	
	public void conferenceuserradiobtn() {
		boolean radio=conferenceuser.isSelected();
		
		if(radio) {
		
		System.out.println("conferenceuser radio button is status :"+radio);
		
		}else {
			conferenceuser.click();
		}
	}
	
	
	public void signinbutton() {
		confsigninbtn.click();
		closeconfuser.click();
		
	}
	// action click add admin user
}
