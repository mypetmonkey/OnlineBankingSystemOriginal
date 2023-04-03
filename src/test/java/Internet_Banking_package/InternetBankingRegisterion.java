package Internet_Banking_package;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InternetBankingRegisterion {
	public static void main(String[] args) throws Throwable  {
		
		//fetch commondata
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		
		ChromeOptions option = new ChromeOptions();
	    option.addArguments("--disable-notification");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
				//fetch testdata
				FileInputStream fi=new FileInputStream("./data/getdatafile.xlsx");
				Workbook wb = WorkbookFactory.create(fi);
				Sheet sh = wb.getSheet("internetRegister");
				HashMap<String,String> hm=new HashMap<String, String>();
				for(int i=0;i<sh.getLastRowNum();i++) {
					String key=sh.getRow(i).getCell(0).toString();
					String value=sh.getRow(i).getCell(1).toString();
					hm.put(key, value);
				}
				for(Entry<String, String> set:hm.entrySet()) {
					driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
				}
		
		JavascriptExecutor j=(JavascriptExecutor)driver;
		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
		int y=ele.getLocation().getY();
	    j.executeScript("window.scrollTo(0,"+y+")");
		
	//	ele.click();
	    Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(By.linkText("Register")).click();
//		driver.findElement(By.name("holder_name")).sendKeys("Rajhans");
//		driver.findElement(By.name("accnum")).sendKeys("1011161011862");
//		driver.findElement(By.name("dbtcard")).sendKeys("421372522033");
//		driver.findElement(By.name("dbtpin")).sendKeys("6096");
//		driver.findElement(By.name("mobile")).sendKeys("8409820806");
//		driver.findElement(By.name("pan_no")).sendKeys("DWEPM4655Q");
		driver.findElement(By.name("dob")).click();
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_1);
		rb.keyPress(KeyEvent.VK_4);
		rb.keyPress(KeyEvent.VK_0);
		rb.keyPress(KeyEvent.VK_3);
		rb.keyPress(KeyEvent.VK_2);
		rb.keyPress(KeyEvent.VK_0);
		rb.keyPress(KeyEvent.VK_2);
		rb.keyPress(KeyEvent.VK_3);
//		driver.findElement(By.name("last_trans")).sendKeys("0");
//		driver.findElement(By.name("password")).sendKeys("Rajhans");
//		driver.findElement(By.name("cnfrm_password")).sendKeys("Rajhans");
		driver.findElement(By.name("submit")).click();
		//Thread.sleep(10000);
		String id = driver.switchTo().alert().getText();
		String custId="";
		for(int i=0;i<id.length();i++) {
			if(Character.isDigit(id.charAt(i)))
				custId=custId+id.charAt(i);
		}
		System.out.println(" Customer Id is:   "+custId);
		System.out.println("1011502");
		driver.switchTo().alert().accept();
		driver.close();
	}

}
