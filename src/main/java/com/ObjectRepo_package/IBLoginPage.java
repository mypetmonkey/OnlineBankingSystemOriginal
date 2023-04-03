package com.ObjectRepo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtilities;

public class IBLoginPage {
	
	ExcelUtilities elib=new ExcelUtilities();
	@FindBy(name="customer_id")
	private WebElement custidtbx;
	@FindBy(name="password")
	private WebElement pwdtbx;
	@FindBy(name="login-btn")
	private WebElement lgbtn;
	
	public IBLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCustidtbx() {
		return custidtbx;
	}
	public WebElement getPwdtbx() {
		return pwdtbx;
	}
	public WebElement getLgbtn() {
		return lgbtn;
	}
	
	public void setIBLogin() throws Throwable {
		custidtbx.sendKeys(elib.readExcelData("ibLoginDetail", 0, 1));
		pwdtbx.sendKeys(elib.readExcelData("ibLoginDetail", 1, 1));
		lgbtn.click();
	}
	

}
