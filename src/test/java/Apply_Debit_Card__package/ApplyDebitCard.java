
package Apply_Debit_Card__package;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyDebitCard {
	public static void main(String[] args) throws AWTException, InterruptedException, Throwable {
		
		
	

	
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		//p.getProperty("")
		 
	WebDriverManager.chromedriver().setup();
	ChromeOptions option = new ChromeOptions();
    option.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
	
	FileInputStream fi=new FileInputStream("./data/getdatafile.xlsx");
	Workbook wb=WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet("ApplyDebit");
	HashMap<String, String> hm=new HashMap<String, String>();
	for(int i=0;i<sh.getLastRowNum();i++) {
		String key=sh.getRow(i).getCell(0).toString();
		String value=sh.getRow(i).getCell(1).toString();
		hm.put(key, value);
		
	}
	for(Entry<String, String> set:hm.entrySet()) {
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	}
	
	
	//driver.findElement(By.name("holder_name")).sendKeys("Rajhans");
	driver.findElement(By.name("dob")).click();
	Robot rb=new Robot();
	  rb.keyPress(KeyEvent.VK_1);
      //rb.keyRelease(KeyEvent.vk)
      rb.keyPress(KeyEvent.VK_4);
     rb.keyPress(KeyEvent.VK_0);
      rb.keyPress(KeyEvent.VK_3);
      rb.keyPress(KeyEvent.VK_2);
     rb.keyPress(KeyEvent.VK_0);
      rb.keyPress(KeyEvent.VK_2);
      rb.keyPress(KeyEvent.VK_3);
    //  driver.findElement(By.name("pan")).sendKeys("DWEPM4655Q");
    //  driver.findElement(By.name("mob")).sendKeys("8409820806");
    //  driver.findElement(By.name("acc_no")).sendKeys("1011161011862");
      driver.findElement(By.name("dbt_crd_submit")).click();
     // Thread.sleep(10000);
      String debno = driver.switchTo().alert().getText();
      String debData="";
      for(int i=0;i<debno.length();i++) {
    	  if(Character.isDigit(debno.charAt(i)))
    		  debData=debData+debno.charAt(i);
      }
      System.out.println("your debit  card num is:  "+debData);
      System.out.println("your debit card pin is:  "+" 6096");
      driver.switchTo().alert().accept();
      
driver.close();
   }
}