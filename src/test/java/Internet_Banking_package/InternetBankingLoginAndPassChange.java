package Internet_Banking_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InternetBankingLoginAndPassChange {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		int y=ele.getLocation().getY();
	    j.executeScript("window.scrollTo(0,"+y+")");
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(By.linkText("Login")).click();
		
	  driver.findElement(By.name("customer_id")).sendKeys("1011862");
	  driver.findElement(By.name("password")).sendKeys("Rajhans");
	  driver.findElement(By.name("login-btn")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//li[text()='Change Password']")).click();
	  driver.findElement(By.name("oldpass")).sendKeys("Rajhans");
	  driver.findElement(By.name("cnfrm")).sendKeys("Rajhans");
	  driver.findElement(By.name("newpass")).sendKeys("Rajhans");
	  driver.findElement(By.name("change_pass")).click();
	  String pass = driver.switchTo().alert().getText();
	  System.out.println(pass);
	  driver.switchTo().alert().accept();
	  
	}

}
