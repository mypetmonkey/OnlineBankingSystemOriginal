package Fund_Transfer_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtilities;
import com.GenericUtilities.FileUtilities;
import com.GenericUtilities.WebdriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InternetBankingForgetPasswordAndChangePass {
	public static void main(String[] args) throws Throwable {
		WebdriverUtilities wlib=new WebdriverUtilities();
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
		driver.findElement(By.xpath("//li[text()='Login ']")).click();
		driver.findElement(By.xpath("//label[text()='FORGET PASSWORD ?']")).click();
		elib.readMultipleDataFromExcel(driver,"ForgetPassword");
		driver.findElement(By.name("sendotp")).click();
		
		
	}

}
