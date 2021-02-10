package com.tcrew.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcrew.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// PageFactory - Object Repository :> Page Objects
	@FindBy(name="txtUsername")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(xpath="//input[@name='Submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"divLogo\"]/img")
	WebElement hrmLogo;
	
	// Initialization of Page Objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Actions : Methods
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidateHrmImage()
	{
		return hrmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}

}
