package com.ObjectRepo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtilities;

public class DebitCardFormPage {
	
	ExcelUtilities elib=new ExcelUtilities();
	
	@FindBy(name="holder_name")
	private WebElement nametbx;
	@FindBy(name="dob")
	private WebElement dobbtn;
	@FindBy(name="pan")
	private WebElement pantbx;
	@FindBy(name="mob")
	private WebElement mobtbx;
	@FindBy(name="acc_no")
	private WebElement acnotbx;
	@FindBy(name="dbt_crd_submit")
	private WebElement dbtcrdsubmitbtn;
	
	public DebitCardFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getNametbx() {
		return nametbx;
	}

	public WebElement getDobbtn() {
		return dobbtn;
	}

	public WebElement getPantbx() {
		return pantbx;
	}

	public WebElement getMobtbx() {
		return mobtbx;
	}

	public WebElement getAcnotbx() {
		return acnotbx;
	}

	public WebElement getDbtcrdsubmitbtn() {
		return dbtcrdsubmitbtn;
	}
	//business liberary
	
	public void debitCardForm() throws Throwable {
		nametbx.sendKeys(elib.readExcelData("ApplyDebit", 0, 1));
		dobbtn.click();
		dobbtn.sendKeys("01-05-2002");
		pantbx.sendKeys(elib.readExcelData("ApplyDebit", 1, 1));
		mobtbx.sendKeys(elib.readExcelData("ApplyDebit", 2, 1));
		acnotbx.sendKeys(elib.readExcelData("ApplyDebit", 3, 1));
		dbtcrdsubmitbtn.click();
	}

}
