package com.ObjectRepo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.JavaUtilities;
import com.GenericUtilities.WebdriverUtilities;

public class Approve_AC_page {
	JavaUtilities jlib=new JavaUtilities();
	WebdriverUtilities wlib=new WebdriverUtilities();
	
	@FindBy(name="application_no")
    private WebElement apnotbx;
	@FindBy(name="search_application")
	private WebElement searchapbtn;
	@FindBy(name="approve_cust")
	private WebElement approvebtn;
	
	public Approve_AC_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public JavaUtilities getJlib() {
		return jlib;
	}

	public WebdriverUtilities getWlib() {
		return wlib;
	}

	public WebElement getApnotbx() {
		return apnotbx;
	}

	public WebElement getSearchapbtn() {
		return searchapbtn;
	}

	public WebElement getApprovebtn() {
		return approvebtn;
	}

	public void setApproveAccount(WebDriver driver,String apno) throws InterruptedException {
		
		apnotbx.sendKeys(apno);	
		searchapbtn.click();
		approvebtn.click();
		String text2 = wlib.getTextFromAlertPopup(driver);
	    String acno=jlib.getPopupDigits(text2);
	    System.out.println("your account number is  :"+acno);
	    Thread.sleep(1000);
	    wlib.alertPopupAccept(driver);
	}
}
