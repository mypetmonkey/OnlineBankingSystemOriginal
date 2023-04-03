package com.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TC_04 extends BaseClass{
	
	@Test(groups = "smoke")
	public void script7() {
		Reporter.log("---Script7",true);
	}
	@Test(groups = "regression")
	public void script8() {
		Reporter.log("---Script8",true);
	}

}
