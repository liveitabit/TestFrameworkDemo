package com.parabank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parabank.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	
	@FindBy(xpath="//*[contains(text(), 'John Smith')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(text(), 'Accounts Overview')]")
	WebElement accountsOverviewLink;
	
	@FindBy(xpath="//a[contains(text(), 'Request Loan')]")
	WebElement requestLoanLink;
	
	@FindBy(xpath="//a[contains(text(), 'Update Contact Info')]")
	WebElement updateContactLink;
	
	
	// Initializing Home page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUsernameLabel() {
		return usernameLabel.isDisplayed();
	}
	
	public RequestLoanPage clickOnRequestLoan() {
		requestLoanLink.click();
		return new RequestLoanPage();
	}
	
	public AccountOverviewPage clickOnAccountOverview() {
		accountsOverviewLink.click();
		return new AccountOverviewPage();
	}
	
	public UpdateContactPage clickOnUpdateContactLink() {
		updateContactLink.click();
		return new UpdateContactPage();
	}

}
