package com.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TC_03 extends BaseClass {
	
	@Test(groups = "smoke")
	public void script5() {
		Reporter.log("---Script5",true);
	}
	@Test(groups="regression")
	public void script6() {
		Reporter.log("---Script6",true);
	}

}
