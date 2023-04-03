package com.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TC_01 extends BaseClass {
	
	@Test(groups = "smoke",retryAnalyzer = com.GenericUtilities.RetryImplementation.class)
	public void script1() {
		Reporter.log("---Script1",true);
	}
	
	@Test(groups = "regression")
	public void script2() {
		Reporter.log("---Script2",true);
	}

}
