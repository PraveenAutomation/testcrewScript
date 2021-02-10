package com.tcrew.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcrew.qa.base.TestBase;

public class HomePage extends TestBase {
	
	// PageFactory - Object Repository :> Page Objects
	@FindBy(xpath="//a[@id='welcome']")
	WebElement userNameLabel;
	
	@FindBy(id="menu_admin_viewAdminModule")
	@CacheLookup
	WebElement adminLinks;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	@CacheLookup
	WebElement newContactLink;
	
	
	
	
	// Initialization of PageObjects/PageFactory:
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Actions : Methods
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	
	
	public void clickOnAdmin()
	{
		Actions action=new Actions(driver);
		action.moveToElement(adminLinks).build().perform();
		newContactLink.click();
	}
	
	

}
