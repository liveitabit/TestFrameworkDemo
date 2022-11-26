package com.parabank.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parabank.qa.base.TestBase;
import com.parabank.qa.pages.HomePage;
import com.parabank.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization();		
		loginPage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String titleExpected = "ParaBank | Welcome | Online Banking";
		String titleActual = loginPage.validatePageTitle();
		Assert.assertEquals(titleActual, titleExpected);
	}
	
	@Test(priority=2)
	public void bankLogoTest() {
		boolean logo= loginPage.validateBankLogo();
		
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void loginTest() {
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		homePage = loginPage.login(username, password);
		
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "ParaBank | Accounts Overview");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
