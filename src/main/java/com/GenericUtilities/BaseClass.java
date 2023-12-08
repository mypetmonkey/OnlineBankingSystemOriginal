package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	
	WebdriverUtilities wlib=new WebdriverUtilities();
	JavaUtilities jlib=new JavaUtilities();
	FileUtilities flib=new FileUtilities();
	DatabaseUtilities dlib=new DatabaseUtilities();
	
	
public	 WebDriver driver;
public static WebDriver sdriver;
	
//	@BeforeSuite(alwaysRun = true)
//	public void connectdb() throws Throwable {
//		
//		dlib.connectTodb();
//		
//	}
//	
	
    @Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void openBrowser(@Optional ("chrome") String browser) throws Throwable {
		
		//String browser=flib.getPropertyFileData("browser");
		
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			 WebDriverManager.edgedriver().setup();
			    driver=new EdgeDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		
		sdriver = driver;
		wlib.maximixeWindow(driver);
		String url=flib.getPropertyFileData("url");
		driver.get(url);
		wlib.waitForPageLoad(driver);
	}
	//@BeforeMethod
	//@AfterMethod
	 
	
	@AfterClass(alwaysRun = true)
	public void closebrowser() {
		driver.quit();
	}
	
	
//	@AfterSuite(alwaysRun = true)
//	public void closedb() throws Throwable {
//		dlib.closedb();
//	}


}
