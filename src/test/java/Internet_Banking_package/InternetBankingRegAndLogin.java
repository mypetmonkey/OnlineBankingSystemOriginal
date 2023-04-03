package Internet_Banking_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtilities;
import com.GenericUtilities.FileUtilities;
import com.GenericUtilities.JavaUtilities;
import com.GenericUtilities.WebdriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InternetBankingRegAndLogin {
	public static void main(String[] args) throws Throwable {
		WebdriverUtilities wlib=new WebdriverUtilities();
		JavaUtilities jlib=new JavaUtilities();
		FileUtilities flib=new FileUtilities();
		ExcelUtilities elib=new ExcelUtilities();
		
		String url=flib.getPropertyFileData("url");
		
		wlib.handleNotification();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wlib.maximixeWindow(driver);
		driver.get(url);
		wlib.waitForPageLoad(driver);
		WebElement target = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		wlib.scrollBarAction(driver, target);
		wlib.mouseHover(driver, target);
		driver.findElement(By.xpath("//li[text()='Register']")).click();
		elib.readMultipleDataFromExcel(driver, "internetRegister");
		driver.findElement(By.name("dob")).click();
		String dob="01-05-2002";
		driver.findElement(By.name("dob")).sendKeys(dob);
		driver.findElement(By.name("submit")).click();
		//Thread.sleep(10000);
		String pp = wlib.getTextFromAlertPopup(driver);
		String cid = jlib.getPopupDigits(pp);
		System.out.println("  Customer Id  :"+cid);
		System.out.println("                  1011440");
		wlib.alertPopupAccept(driver);
        driver.findElement(By.linkText("Home")).click();
        
        WebElement targetlogin = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		wlib.scrollBarAction(driver, targetlogin);
		wlib.mouseHover(driver, targetlogin);
		driver.findElement(By.xpath("//li[text()='Login ']")).click();
        driver.findElement(By.name("customer_id")).sendKeys("1011440");	
        driver.findElement(By.name("password")).sendKeys("Rajhans");
        driver.findElement(By.name("login-btn")).click();
		//driver.close();
	}

}
