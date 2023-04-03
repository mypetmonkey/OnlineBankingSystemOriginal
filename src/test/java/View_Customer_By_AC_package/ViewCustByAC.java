package View_Customer_By_AC_package;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewCustByAC {
	public static void main(String[] args) throws IOException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notification");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Staff Login")).click();
		driver.findElement(By.name("staff_id")).sendKeys("210001");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("staff_login-btn")).click();
		driver.findElement(By.name("view_cust_by_ac")).click();
		driver.findElement(By.name("account_no")).sendKeys("1011901011502");
		driver.findElement(By.name("submit_view")).click();
//		List<WebElement> all = driver.findElements(By.xpath("//span[text()='Customer Details']"));
//		for(int i=0;i<all.size();i++) {
//			String text=all.get(i).getText();
//			System.out.println(text);
//		}
		JavascriptExecutor j=(JavascriptExecutor) driver;
		 WebElement ele = driver.findElement(By.xpath("//span[text()='Customer Details']"));
		int y = ele.getLocation().getY();
		j.executeScript("window.scrollTo(0,"+y+")");
		
		TakesScreenshot t=(TakesScreenshot) driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/ss.png");
		FileUtils.copyFile(src, dest);
		
		driver.close();
	}

}
