package com.practice;

import java.io.FileInputStream;
import java.util.Properties;



public class ReadDataFromProperties {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String brow = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String sid = pobj.getProperty("staffID");
	    String pwd = pobj.getProperty("pwd");
	    System.out.println(brow+"   "+url+"   "+sid+"   "+pwd);
	    
//	    WebDriverManager.chromedriver().setup();
//	    WebDriver driver=new ChromeDriver();
	    
	}

}
