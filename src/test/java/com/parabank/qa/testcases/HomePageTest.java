package com.parabank.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parabank.qa.base.TestBase;
import com.parabank.qa.pages.HomePage;
import com.parabank.qa.pages.LoginPage;
import com.parabank.qa.pages.RequestLoanPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	RequestLoanPage requestLoanPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization();		
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		String expectedHomePageTitle="ParaBank | Accounts Overview";
		
		Assert.assertEquals(homePageTitle, expectedHomePageTitle, "Home Page Title not matched.");
	}
	
	@Test(priority=2)
	public void verifyUsernameLabelTest() {
		Assert.assertTrue(homePage.verifyUsernameLabel());
	}
	
	@Test(priority=3)
	public void verifyRequestLoanLink() {
		requestLoanPage = homePage.clickOnRequestLoan();		
		Assert.assertTrue(requestLoanPage.verifyRequestLoanLabel());
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
