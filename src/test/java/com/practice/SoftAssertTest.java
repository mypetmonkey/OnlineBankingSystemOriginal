package com.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	SoftAssert sa=new SoftAssert();
	
	@Test
	public void test1() {
		
		Reporter.log("-----TestScript_01",true);
		Reporter.log("-----TestScript_02",true);
		sa.assertEquals("tyss", "qsp");
		Reporter.log("-----TestScript_03",true);
		sa.assertAll();
	}
	
	@Test
	public void test2() {
		
		int i=10;
		Reporter.log("-----TestScript_04",true);
		Reporter.log("-----TestScript_05",true);
		sa.assertNull(i);
		Reporter.log("-----TestScript_06 ",true);
		sa.assertAll();
	}

	
}
