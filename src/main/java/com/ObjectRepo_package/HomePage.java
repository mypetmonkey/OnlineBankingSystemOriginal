package com.ObjectRepo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebdriverUtilities;

public class HomePage {
	WebdriverUtilities wlib=new WebdriverUtilities();
	
	@FindBy(linkText ="Open Account")
	private WebElement openacbtn;
	
	@FindBy(xpath="//li[text()='Apply Debit Card']")
    private WebElement applydebitbtn;
	
	@FindBy(xpath="//a[contains(text(),'Internet Banking')]")
	private WebElement ibbtn;
	
	@FindBy(xpath="//li[text()='Fund Transfer']")
	private WebElement ftbtn;
	
	@FindBy(xpath="//li[text()='Register']")
	private WebElement ibregopt;
	
	@FindBy(xpath="//li[text()='Login ']")
	private WebElement ibloginopt;
	
	@FindBy(linkText = "Staff Login")
	private WebElement staffloginbtn;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getOpenacbtn() {
		return openacbtn;
	}

	public WebElement getApplydebitbtn() {
		return applydebitbtn;
	}

	public WebElement getIbbtn() {
		return ibbtn;
	}

	public WebElement getFtbtn() {
		return ftbtn;
	}

	public WebElement getIbregopt() {
		return ibregopt;
	}

	public WebElement getIbloginopt() {
		return ibloginopt;
	}

	public WebElement getStaffloginbtn() {
		return staffloginbtn;
	}
	
	
}
