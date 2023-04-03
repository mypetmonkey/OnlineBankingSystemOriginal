package com.ObjectRepo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditDetailPage {
	@FindBy(name="customer_account_no")
	private WebElement custacnotbx;
	@FindBy(name="credit_amount")
	private WebElement credamnttbx;
	@FindBy(name="credit_btn")
	private WebElement creditsubmitbtn;
	
 public CreditDetailPage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }
 
 public void setFundTransfer() {
	
	 custacnotbx.sendKeys("1011211011440");
	 credamnttbx.sendKeys("50000");
	 creditsubmitbtn.click();
 }
}
	
