package Delete_Customer_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCustomerbyAC {
	public static void main(String[] args) {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notification");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Staff Login")).click();
		driver.findElement(By.name("staff_id")).sendKeys("210001");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("staff_login-btn")).click();
	    JavascriptExecutor j=(JavascriptExecutor) driver;
	   WebElement del = driver.findElement(By.name("del_cust"));
	   int y=del.getLocation().getY();
	   j.executeScript("window.scrollTo(0,"+y+")");
	   driver.findElement(By.name("del_cust")).click();
	   driver.findElement(By.name("Cust_ac_no")).sendKeys("1011901011502");
	   driver.findElement(By.name("Cust_ac_Id")).sendKeys("1011502");
	   driver.findElement(By.name("reason")).sendKeys("dead account");
	   driver.findElement(By.name("delete")).click();
	 String msg = driver.switchTo().alert().getText();
	 System.out.println(msg);
	 driver.switchTo().alert().accept();
	   driver.close();
	   
}
}