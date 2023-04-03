package com.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTest {
	
	@Test(dataProvider = "data")
	public void demodataprovider(String src,String dest) {
		
		System.out.println("name  "+src+"  location  "+dest );
	}
	
	
	
	@DataProvider
	public Object[][] data() {
		Object[][] obj = new Object[3][2];
		obj[0][0]="Rajhans";
		obj[0][1]="Bengalore";
		
		obj[1][0]="sony";
		obj[1][1]="japan";
		
		obj[2][0]="hcl";
		obj[2][1]="india";
		return obj;
	}

}
