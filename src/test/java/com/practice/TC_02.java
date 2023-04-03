package com.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TC_02 extends BaseClass{
	@Test(groups = "smoke")
	public void script3() {
		Reporter.log("---Script3",true);
		
	}
	
	@Test(groups = "regression")
	public void script4() {
		Reporter.log("---Script4",true);
	}
}
