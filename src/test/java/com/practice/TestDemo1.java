package com.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestDemo1 {
	
	
	@BeforeSuite
	public void dbconnect() {
		Reporter.log("--connect to database",true);
	}
	@AfterSuite
	public void closedbconnect() {
		Reporter.log("--disconnect from database",true);
	}
	@BeforeClass
	public void browserluanch() {
		Reporter.log("--lunch the browser",true);
	}
	@AfterClass
	public void closebro() {
		Reporter.log("--close the browser",true);
	}
	@BeforeMethod
	public void login() {
		Reporter.log("--login to application",true);
	}
	@AfterMethod
	public void logout() {
		Reporter.log("--logout from application",true);
	}
	
	@Test(priority = -2)
	public void create() {
		Reporter.log("  create",true);
		
	}
	
	@Test (dependsOnMethods = "create" )
	public void edit() {
		Reporter.log("  edit",true);
	}
	
	@Test (priority=-1)
	public void delete() {
		Reporter.log("  delete",true);
	}

}
