package Credit_Customer_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtilities;
import com.GenericUtilities.FileUtilities;
import com.GenericUtilities.WebdriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreditCustomergeneric {
	public static void main(String[] args) throws Throwable {
		
		FileUtilities flib=new FileUtilities();
		ExcelUtilities elib=new ExcelUtilities();
		WebdriverUtilities wlib=new WebdriverUtilities();
		
		String url = flib.getPropertyFileData("url");
		
		wlib.handleNotification();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wlib.maximixeWindow(driver);
		driver.get(url);
		wlib.waitForPageLoad(driver);
		
		driver.findElement(By.linkText("Staff Login")).click();
		elib.readMultipleDataFromExcel(driver, "StaffLogin");
		driver.findElement(By.name("staff_login-btn")).click();
		//driver.findElement(By.name("credit_cust_ac")).click();
		driver.findElement(By.name("customer_account_no")).sendKeys("1011161011862");
		driver.findElement(By.name("credit_amount")).sendKeys("500");
		driver.findElement(By.name("credit_btn")).click();
		String note = wlib.getTextFromAlertPopup(driver);
		wlib.alertPopupAccept(driver);
		System.out.println(note);
		driver.close();
		
	}
	
}
