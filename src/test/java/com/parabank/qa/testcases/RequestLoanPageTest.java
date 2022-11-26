package com.parabank.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.parabank.qa.base.TestBase;
import com.parabank.qa.pages.HomePage;
import com.parabank.qa.pages.LoginPage;
import com.parabank.qa.pages.RequestLoanPage;
import com.parabank.qa.util.TestUtil;

public class RequestLoanPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	RequestLoanPage requestLoanPage;
	
	String sheetName = "RequestLoan";
	
	public RequestLoanPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		requestLoanPage = homePage.clickOnRequestLoan();
	}
	
	@Test(priority=1)
	public void verifyRequestLoanLabel() {
		Assert.assertTrue(requestLoanPage.verifyRequestLoanLabel(), "Loan Request Page Label is missing on Page.");
	}
	
	@DataProvider
	public Object[][] getRequestLoanTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getRequestLoanTestData")
	public void applyLoanApplication(String loanAmount, String downPayment, String fromAccount) {
		//int fromAccountIndex = Integer.parseInt(fromAccount);
		
		//requestLoanPage.applyLoanRequest("2000", "600", 0);
		requestLoanPage.applyLoanRequest(loanAmount, downPayment, fromAccount);
		Assert.assertTrue(requestLoanPage.verifyLoanProcessingLabel());
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
