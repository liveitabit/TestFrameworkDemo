package com.parabank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.parabank.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// Page Factory or Object Repository of Login Page
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@title='ParaBank']")
	WebElement parabankLogo;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement registerBtn;
	
	
	// Initializing Page objects of LoginPage
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	// Action Methods for Login Page
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateBankLogo() {
		return parabankLogo.isDisplayed();
	}
	
	public HomePage login(String usr, String pwd) {
		username.sendKeys(usr);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
	
}
