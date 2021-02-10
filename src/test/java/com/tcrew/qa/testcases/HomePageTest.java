package com.tcrew.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tcrew.qa.base.TestBase;
import com.tcrew.qa.pages.HomePage;
import com.tcrew.qa.pages.LoginPage;
import com.tcrew.qa.utils.TestUtils;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initilization();
		
		testUtils=new TestUtils();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "OrangeHRM","HomePage title is not matched");
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest()
	{
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
		{
		driver.quit();
		}
	}
}
