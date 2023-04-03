package com.ObjectRepo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage {
	
	@FindBy(name="add_beneficiary")
	private WebElement addbenflink;
	@FindBy(name="delete_beneficiary")
	private WebElement delbenfbtn;
	@FindBy(name="view_beneficiary")
	private WebElement viewbenfbtn;
	@FindBy(name="beneficiary")
	private WebElement benfbtn;
	@FindBy(xpath="(//option[@value='1011281011710'])[1]")
	private WebElement selectbenfbtn;
	@FindBy(name="trnsf_amount")
	private WebElement amounttbx;
	@FindBy(name="trnsf_remark")
	private WebElement remarktbx;
	@FindBy(name="fnd_trns_btn")
	private WebElement transferbtn;
	
	public FundTransferPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddbenflink() {
		return addbenflink;
	}

	public WebElement getDelbenfbtn() {
		return delbenfbtn;
	}

	public WebElement getViewbenfbtn() {
		return viewbenfbtn;
	}

	public WebElement getBenfbtn() {
		return benfbtn;
	}

	public WebElement getSelectbenfbtn() {
		return selectbenfbtn;
	}

	public WebElement getAmounttbx() {
		return amounttbx;
	}

	public WebElement getRemarktbx() {
		return remarktbx;
	}

	public WebElement getTransferbtn() {
		return transferbtn;
	}
	
	public void setBeneficiaryToSend() {
		benfbtn.click();
		selectbenfbtn.click();
		amounttbx.sendKeys("50000");
		remarktbx.sendKeys("just to check");
		transferbtn.click();
		
	}
	

}
