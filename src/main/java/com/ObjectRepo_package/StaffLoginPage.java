package com.ObjectRepo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {
	//declaration
	@FindBy(name="staff_id")
	private WebElement sid;
	
    @FindBy(name="password")
    private WebElement pwd;
    
    @FindBy(name="staff_login-btn")
    private WebElement stafflgbtn;
    
    public StaffLoginPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    
	public WebElement getSid() {
		return sid;
	}
	public WebElement getPwd() {
		return pwd;
	}
	public WebElement getStafflgbtn() {
		return stafflgbtn;
	}
	
	  public void setSidLogin() {
	    	sid.sendKeys("210001");
	    	pwd.sendKeys("password");
	    	stafflgbtn.click();
	    }
    
    
}
