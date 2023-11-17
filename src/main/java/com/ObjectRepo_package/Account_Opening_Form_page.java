package com.ObjectRepo_package;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtilities;
import com.GenericUtilities.JavaUtilities;
import com.GenericUtilities.WebdriverUtilities;

public class Account_Opening_Form_page {
	ExcelUtilities elib= new ExcelUtilities();
	WebdriverUtilities wlib= new WebdriverUtilities();
	JavaUtilities jlib=new JavaUtilities();
	//declaration
	
	@FindBy(name="name")
	private WebElement nametbx;
	@FindBy(name="gender")
	private WebElement genderbtn;
	@FindBy(xpath="//option[@value='Male']")
	private WebElement maleopt;
	@FindBy(xpath="//option[@value='Female']")
	private WebElement Femaleopt;
	@FindBy(name="mobile")
	private WebElement mobtbx;
	@FindBy(name="email")
	private WebElement emailtbx;
	@FindBy(name="landline")
	private WebElement landlinetbx;
	@FindBy(name="dob")
	private WebElement dobtbx;
	@FindBy(name="pan_no")
	private WebElement pantbx;
	@FindBy(name="citizenship")
	private WebElement citizentbx;
	@FindBy(name="homeaddrs")
	private WebElement homeaddrestbx;
	@FindBy(name="officeaddrs")
	private WebElement officeadresstbx;
	@FindBy(name="state")
	private WebElement statetbx;
	@FindBy(xpath="//option[@value='California']")
	private WebElement selstatetbx;
	@FindBy(name="city")
	private WebElement citytbx;
	@FindBy(xpath="//option[@value='Los Angeles']")
	private WebElement selcitytbx;
	@FindBy(name="pin")
	private WebElement pintbx;
	@FindBy(name="arealoc")
	private WebElement arealoctbx;
	@FindBy(name="nominee_name")
	private WebElement nomininametbx;
	@FindBy(name="nominee_ac_no")
	private WebElement nominiactbx;
	@FindBy(name="acctype")
	private WebElement acctypebtn;
	@FindBy(xpath="//option[@value='Saving']")
	private WebElement savingopt;
	@FindBy(name="submit")
	private WebElement submitbtn;
	@FindBy(name="cnfrm-submit")
	private WebElement confsubmitbtn;
	
	//initilization
	
	public Account_Opening_Form_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//getter and setter methods

	public void setConfsubmitbtn(WebElement confsubmitbtn) {
		this.confsubmitbtn = confsubmitbtn;
	}


	public ExcelUtilities getElib() {
		return elib;
	}


	public WebdriverUtilities getWlib() {
		return wlib;
	}


	public JavaUtilities getJlib() {
		return jlib;
	}


	public WebElement getNametbx() {
		return nametbx;
	}
	public WebElement getGenderbtn() {
		return genderbtn;
	}
	public WebElement getMaleopt() {
		return maleopt;
	}
	public WebElement getFemaleopt() {
		return Femaleopt;
	}
	public WebElement getMobtbx() {
		return mobtbx;
	}
	public WebElement getEmailtbx() {
		return emailtbx;
	}
	public WebElement getLandlinetbx() {
		return landlinetbx;
	}
	public WebElement getDobtbx() {
		return dobtbx;
	}
	public WebElement getPantbx() {
		return pantbx;
	}
	public WebElement getCitizentbx() {
		return citizentbx;
	}
	public WebElement getHomeaddrestbx() {
		return homeaddrestbx;
	}
	public WebElement getOfficeadresstbx() {
		return officeadresstbx;
	}
	public WebElement getStatetbx() {
		return statetbx;
	}
	public WebElement getSelstatetbx() {
		return selstatetbx;
	}
	public WebElement getCitytbx() {
		return citytbx;
	}
	public WebElement getSelcitytbx() {
		return selcitytbx;
	}
	public WebElement getPintbx() {
		return pintbx;
	}
	public WebElement getArealoctbx() {
		return arealoctbx;
	}
	public WebElement getNomininametbx() {
		return nomininametbx;
	}
	public WebElement getNominiactbx() {
		return nominiactbx;
	}
	public WebElement getAcctypebtn() {
		return acctypebtn;
	}
	public WebElement getSavingopt() {
		return savingopt;
	}
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	public WebElement getConfsubmitbtn() {
		return confsubmitbtn;
	}
	
	
	public void setCustomerDetais(WebDriver driver) throws Throwable {
		
		nametbx.sendKeys(elib.readExcelData("CustomerData", 0, 1));
		genderbtn.click();
		 maleopt.click();
		 mobtbx.sendKeys(elib.readExcelData("CustomerData", 1, 1));
		 emailtbx.sendKeys(elib.readExcelData("CustomerData", 2, 1));
		 landlinetbx.sendKeys(elib.readExcelData("CustomerData", 3, 1));
		dobtbx.click();
		dobtbx.sendKeys("01-05-2002");
		pantbx.sendKeys(elib.readExcelData("CustomerData", 4, 1));
		citizentbx.sendKeys(elib.readExcelData("CustomerData", 5, 1));
		homeaddrestbx.sendKeys(elib.readExcelData("CustomerData", 6, 1));
		officeadresstbx.sendKeys(elib.readExcelData("CustomerData", 7, 1));
		statetbx.click();
		selstatetbx.click();
		citytbx.click();
		selcitytbx.click();
		pintbx.sendKeys(elib.readExcelData("CustomerData", 8, 1));
		arealoctbx.sendKeys(elib.readExcelData("CustomerData", 9, 1));
		nomininametbx.sendKeys(elib.readExcelData("CustomerData", 10, 1));
		nominiactbx.sendKeys(elib.readExcelData("CustomerData", 11, 1));
		acctypebtn.click();
		savingopt.click();
		submitbtn.click();
		confsubmitbtn.click();
				String text = wlib.getTextFromAlertPopup(driver);
		String apno = jlib.getPopupDigits(text);
		System.out.println("your application number is  "+apno);
	}
	 

}
