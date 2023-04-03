package com.practice;

import org.testng.annotations.Test;

public class DataProExecute {
	@Test(dataProviderClass = DataPro.class,dataProvider = "data")
	public void getData(String src,String dest) {
		
		System.out.println("name  "+src+"  location  "+dest );
	}

}
