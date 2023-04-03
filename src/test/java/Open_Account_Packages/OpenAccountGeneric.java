package Open_Account_Packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtilities;
import com.GenericUtilities.FileUtilities;
import com.GenericUtilities.JavaUtilities;
import com.GenericUtilities.WebdriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenAccountGeneric {
	public static void main(String[] args) throws Throwable {
		WebdriverUtilities wlib=new WebdriverUtilities();
		ExcelUtilities elib=new ExcelUtilities();
		JavaUtilities jlib=new JavaUtilities();
		FileUtilities flib=new FileUtilities();
		
		String url = flib.getPropertyFileData("url");
		String sid = flib.getPropertyFileData("staffID");
		String pwd = flib.getPropertyFileData("pwd");
		
		wlib.handleNotification();
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 wlib.maximixeWindow(driver);
		 driver.get(url);
		 wlib.waitForPageLoad(driver);
		 driver.findElement(By.linkText("Open Account")).click();
		 elib.readMultipleDataFromExcel(driver, "CustomerData");
		driver.findElement(By.name("gender")).click();
        driver.findElement(By.xpath("//option[@value='Male']")).click();
        driver.findElement(By.name("dob")).click();
        String dob="01-05-2002";
        driver.findElement(By.name("dob")).sendKeys(dob);
        driver.findElement(By.name("state")).click();
	    driver.findElement(By.xpath("//option[@value='California']")).click();
	    driver.findElement(By.name("city")).click();
	    driver.findElement(By.xpath("//option[@value='Los Angeles']")).click();
	    driver.findElement(By.name("acctype")).click();
	    driver.findElement(By.xpath("//option[@value='Saving']")).click();
	    driver.findElement(By.name("submit")).click();
	    driver.findElement(By.name("cnfrm-submit")).click();
	   String text = wlib.getTextFromAlertPopup(driver);
	  String apno = jlib.getPopupDigits(text);
	  System.out.println("your application number is  "+apno);
	  wlib.alertPopupAccept(driver);
	  driver.findElement(By.linkText("Staff Login")).click();
	  driver.findElement(By.name("staff_id")).sendKeys(sid);
	  driver.findElement(By.name("password")).sendKeys(pwd);
	  driver.findElement(By.name("staff_login-btn")).click();
	  driver.findElement(By.name("apprvac")).click();
	  driver.findElement(By.name("application_no")).sendKeys(apno);
	  driver.findElement(By.name("search_application")).click();
	  driver.findElement(By.name("approve_cust")).click();
	   String text2 = wlib.getTextFromAlertPopup(driver);
	   String acno=jlib.getPopupDigits(text2);
	   System.out.println("your account number is  "+acno);
	   System.out.println("Account Approved");
	   wlib.alertPopupAccept(driver);
	   System.out.println("THANKS CUSTOMER");
		  System.out.println("now you are elligible to apply debit card");
		  driver.close();
	}
}
	    
	


