package view_Active_customer_package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewActiveCustomer {

	public static void main(String[] args)throws Throwable {
		ChromeOptions option = new ChromeOptions();
	    option.addArguments("--disable-notification");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Staff Login")).click();
		driver.findElement(By.name("staff_id")).sendKeys("210001");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("staff_login-btn")).click();
		driver.findElement(By.name("viewdet")).click();
		List<WebElement> sln = driver.findElements(By.xpath("//th[text()='#']"));
		 for(int i=0;i<sln.size();i++) {
			 String data=sln.get(i).getText();
			 System.out.println(data);
		 }
		driver.close();
	}

}
