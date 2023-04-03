package com.ObjectRepo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtilities;

public class AddBeneficiaryPage {
	ExcelUtilities elib=new ExcelUtilities();
	
	@FindBy(name="beneficiary_name")
	private WebElement benefnametbx;
	@FindBy(name="beneficiary_acno")
	private WebElement benefacnotbx;
	@FindBy(name="Ifsc_code")
	private WebElement ifsctbx;
	@FindBy(name="beneficiary_acc_type")
	private WebElement actypetbx;
	@FindBy(xpath="//option[@value='Saving']")
	private WebElement savingopt;
	@FindBy(name="add_beneficiary_btn")
	private WebElement addbenfbtn;
	
	public AddBeneficiaryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public ExcelUtilities getElib() {
		return elib;
	}

	public WebElement getBenefnametbx() {
		return benefnametbx;
	}

	public WebElement getBenefacnotbx() {
		return benefacnotbx;
	}

	public WebElement getIfsctbx() {
		return ifsctbx;
	}

	public WebElement getActypetbx() {
		return actypetbx;
	}

	public WebElement getSavingopt() {
		return savingopt;
	}

	public WebElement getAddbenfbtn() {
		return addbenfbtn;
	}
	public void setaddBeneficiary() throws Throwable {
		benefnametbx.sendKeys(elib.readExcelData("addBenefDetail", 0, 1));
		benefacnotbx.sendKeys(elib.readExcelData("addBenefDetail", 0, 1));
		ifsctbx.sendKeys(elib.readExcelData("addBenefDetail", 0, 1));
		actypetbx.click();
		savingopt.click();
		addbenfbtn.click();
		
	}

}
