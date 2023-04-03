package Apply_Debit_Card__package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtilities;
import com.GenericUtilities.FileUtilities;
import com.GenericUtilities.JavaUtilities;
import com.GenericUtilities.WebdriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyDebitCardgeneric {
	public static void main(String[] args) throws Throwable {
		
		JavaUtilities jlib=new JavaUtilities();
		WebdriverUtilities wlib=new WebdriverUtilities();
		ExcelUtilities elib=new ExcelUtilities();
		FileUtilities flib=new FileUtilities();
		
		String url = flib.getPropertyFileData("url");
		wlib.handleNotification();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wlib.maximixeWindow(driver);
		driver.get(url);
		wlib.waitForPageLoad(driver);
		driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
		elib.readMultipleDataFromExcel(driver,"ApplyDebit");
		driver.findElement(By.name("dob")).click();
		String dob="01-05-2002";
		driver.findElement(By.name("dob")).sendKeys(dob);
        driver.findElement(By.name("dbt_crd_submit")).click();
       // Thread.sleep(10000);
        String dcardno = wlib.getTextFromAlertPopup(driver);
      String cardno = jlib.getPopupDigits(dcardno);
      System.out.println("you have Successfully Applied your debit card");
      System.out.println("your card no is  :"+cardno);
      System.out.println("your debit card pin is:  "+"8281");
		wlib.alertPopupAccept(driver);
		driver.close();
	}

}
