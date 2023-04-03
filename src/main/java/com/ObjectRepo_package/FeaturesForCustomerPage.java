package com.ObjectRepo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeaturesForCustomerPage {
	@FindBy(xpath="//li[text()='My Account']")
	private WebElement myaclink;
	@FindBy(xpath="//li[text()='My Profile']")
    private WebElement myprofilelink;
	@FindBy(xpath="//li[text()='Change Password']")
	private WebElement changepwdlink;
	@FindBy(xpath="//li[text()='Fund Transfer']")
	private WebElement ftlink;
	@FindBy(xpath="//li[text()='Statement']")
	private WebElement statementlink;
	
	
	

	
	public FeaturesForCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getMyaclink() {
		return myaclink;
	}

	public WebElement getMyprofilelink() {
		return myprofilelink;
	}

	public WebElement getChangepwdlink() {
		return changepwdlink;
	}

	public WebElement getFtlink() {
		return ftlink;
	}

	public WebElement getStatementlink() {
		return statementlink;
	}
	
	
}
