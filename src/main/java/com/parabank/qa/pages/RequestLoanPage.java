package com.parabank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.parabank.qa.base.TestBase;

public class RequestLoanPage extends TestBase {
	
	@FindBy(xpath="//h1[contains(text(),'Apply for a Loan')]")
	WebElement requestLoanLabel;
	
	@FindBy(xpath="//input[@id='amount']")
	WebElement loanAmountInput;
	
	@FindBy(xpath="//input[@id='downPayment']")
	WebElement downPaymentInput;
	
	@FindBy(xpath="//select[@id='fromAccountId']")
	WebElement fromAccountSelect;
	
	@FindBy(xpath="//input[@value='Apply Now']")
	WebElement applyLoanBtn;
	
	@FindBy(xpath="//h1[contains(text(),'Loan Request Processed')]")
	WebElement loanRequestProcessedLabel;
	
	// Initializing Request Loan Page objects
	public RequestLoanPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyRequestLoanLabel() {
		return requestLoanLabel.isDisplayed();
	}
	
	public void applyLoanRequest(String loanAmt, String downPayment, String fromAccountIndex ) {
		loanAmountInput.sendKeys(loanAmt);
		downPaymentInput.sendKeys(downPayment);
		
		Select fromAccountDropdown = new Select(fromAccountSelect);
		//fromAccountDropdown.selectByIndex(fromAccountIndex);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		applyLoanBtn.click();
	
	}
	
	public boolean verifyLoanProcessingLabel() {
		return loanRequestProcessedLabel.isDisplayed();
	}

}
