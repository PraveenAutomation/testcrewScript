package com.tcrew.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tcrew.qa.pages.HomePage;
import com.tcrew.qa.pages.LoginPage;

public class LoginPageTest extends com.tcrew.qa.base.TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initilization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority = 2)
	public void hrmLogoImageTest()
	{
		boolean flag=loginPage.ValidateHrmImage();
		Assert.assertTrue(flag);	
	}
	
	@Test(priority = 3)
	public void loginTest()
	{
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
