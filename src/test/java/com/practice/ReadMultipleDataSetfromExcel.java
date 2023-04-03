package com.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.ExcelUtilities;

public class ReadMultipleDataSetfromExcel {
	
	@Test(dataProvider = "readSetOfDat")
	public void testData(String src,String dest) {
		System.out.println("from >"+src +"  to "+dest);
	}
	
	
	@DataProvider
public Object[][] readSetOfDat() throws Throwable {
		ExcelUtilities elib=new ExcelUtilities();
		Object[][] value = elib.readMultipleSetofData();
		return value;
	}
}
