package Fund_Transfer_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FundTransfer {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notification");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Fund Transfer")).click();
		driver.findElement(By.name("customer_id")).sendKeys("1011502");
		driver.findElement(By.name("password")).sendKeys("Rajhans");
		driver.findElement(By.name("login-btn")).click();
		//driver.findElement(By.linkText("Fund Transfer")).click();
		driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
		driver.findElement(By.name("add_beneficiary")).click();
		driver.findElement(By.name("beneficiary_name")).sendKeys("lakshmi");
		driver.findElement(By.name("beneficiary_acno")).sendKeys("11011161011862");
		driver.findElement(By.name("Ifsc_code")).sendKeys("1011");
		driver.findElement(By.name("beneficiary_acc_type")).click();
		driver.findElement(By.xpath("//option[@value='Saving']")).click();
		driver.findElement(By.name("add_beneficiary_btn")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
		driver.findElement(By.name("beneficiary")).click();
		driver.findElement(By.xpath("(//option[@value='1011281011710'])[1]")).click();
		driver.findElement(By.name("trnsf_amount")).sendKeys("0");
		driver.findElement(By.name("trnsf_remark")).sendKeys("conform after submit");
		driver.findElement(By.name("fnd_trns_btn")).click();
		driver.switchTo().alert().accept();
		System.out.println("fund successfully Transfered");
		driver.close();
		
	}

}
