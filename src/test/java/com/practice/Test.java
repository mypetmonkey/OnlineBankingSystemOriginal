package com.practice;

import com.GenericUtilities.ExcelUtilities;

public class Test {
	public static void main(String[] args) throws Throwable {
		ExcelUtilities e=new ExcelUtilities();
	String d = e.readExcelData("CustomerData", 0, 1);
	System.out.println(d);
	}

}
