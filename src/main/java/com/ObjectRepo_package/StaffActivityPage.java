package com.ObjectRepo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffActivityPage {
	@FindBy(name="viewdet")
	private WebElement viewactcustbtn;
	@FindBy(name="view_cust_by_ac")
	private WebElement viewcustbyac;
	@FindBy(name="apprvac")
	private WebElement approvebtn;
	@FindBy(name="del_cust")
	private WebElement delcustbtn;
	@FindBy(name="credit_cust_ac")
    private WebElement creditcustbtn;
	@FindBy(name="home")
	private WebElement bomebtn;
	@FindBy(name="logout_btn")
	private WebElement stafflogoutbtn;
	
	public StaffActivityPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getViewactcustbtn() {
		return viewactcustbtn;
	}

	public WebElement getViewcustbyac() {
		return viewcustbyac;
	}

	public WebElement getApprovebtn() {
		return approvebtn;
	}

	public WebElement getDelcustbtn() {
		return delcustbtn;
	}

	public WebElement getCreditcustbtn() {
		return creditcustbtn;
	}

	public WebElement getBomebtn() {
		return bomebtn;
	}

	public WebElement getStafflogoutbtn() {
		return stafflogoutbtn;
	}
	
	
	
}
