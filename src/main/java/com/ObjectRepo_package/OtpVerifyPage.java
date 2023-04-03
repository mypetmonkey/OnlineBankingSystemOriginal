package com.ObjectRepo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtpVerifyPage {
	@FindBy(name="otpcode")
	private WebElement otptbx;
	@FindBy(name="verify-btn")
	private WebElement verifybtn;
	
	public OtpVerifyPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setverifyotp(String otp) {
		otptbx.sendKeys(otp);
		verifybtn.click();
	}
}
