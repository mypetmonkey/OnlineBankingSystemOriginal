package com.ObjectRepo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtilities;

public class InternetBankingRegistrationPage {
	ExcelUtilities elib=new ExcelUtilities();
	
	@FindBy(name="holder_name")
	private WebElement holdernametbx;
	@FindBy(name="accnum")
	private WebElement acnotbx;
	@FindBy(name="dbtcard")
	private WebElement dbtcardtbx;
	@FindBy(name="dbtpin")
	private WebElement dbtpintbx;
	@FindBy(name="mobile")
	private WebElement mobiletbx;
	@FindBy(name="pan_no")
	private WebElement pannotbx;
	@FindBy(name="dob")
	private WebElement dobtbx;
	@FindBy(name="last_trans")
	private WebElement lasttranstbx;
	@FindBy(name="password")
	private WebElement passwordtbx;
	@FindBy(name="cnfrm_password")
	private WebElement cnfrmpasswordtbx;
	@FindBy(name="submit")
	private WebElement subbtn;

	public InternetBankingRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	
	public ExcelUtilities getElib() {
		return elib;
	}



	public WebElement getHoldernametbx() {
		return holdernametbx;
	}



	public WebElement getAcnotbx() {
		return acnotbx;
	}



	public WebElement getDbtcardtbx() {
		return dbtcardtbx;
	}



	public WebElement getDbtpintbx() {
		return dbtpintbx;
	}



	public WebElement getMobiletbx() {
		return mobiletbx;
	}



	public WebElement getPannotbx() {
		return pannotbx;
	}



	public WebElement getDobtbx() {
		return dobtbx;
	}



	public WebElement getLasttranstbx() {
		return lasttranstbx;
	}



	public WebElement getPasswordtbx() {
		return passwordtbx;
	}



	public WebElement getCnfrmpasswordtbx() {
		return cnfrmpasswordtbx;
	}



	public WebElement getSubbtn() {
		return subbtn;
	}


//business liberary
	public void setibRegistration() throws Throwable {
		holdernametbx.sendKeys(elib.readExcelData("internetRegister", 0, 1));
		acnotbx.sendKeys(elib.readExcelData("internetRegister", 1, 1));
		dbtcardtbx.sendKeys(elib.readExcelData("internetRegister", 2, 1));
		dbtpintbx.sendKeys(elib.readExcelData("internetRegister", 3, 1));
		mobiletbx.sendKeys(elib.readExcelData("internetRegister", 4, 1));
		pannotbx.sendKeys(elib.readExcelData("internetRegister", 5, 1));
		dobtbx.click();
		dobtbx.sendKeys("01-05-2002");
		lasttranstbx.sendKeys(elib.readExcelData("internetRegister", 6, 1));
		passwordtbx.sendKeys(elib.readExcelData("internetRegister", 7, 1));
		cnfrmpasswordtbx.sendKeys(elib.readExcelData("internetRegister", 8, 1));
		subbtn.click();
	}
	
	
}
