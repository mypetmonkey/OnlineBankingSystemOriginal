package com.ObjectRepo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiveCustomerPage {
	@FindBy(xpath="//table[@border='1px']")
	private WebElement activetable;
	
	public ActiveCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getActivetable() {
		return activetable;
	}
   
}
