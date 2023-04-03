package Open_Account_Packages;

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

public class Account_Opening {
	public static void main(String[] args) throws Throwable {
		//fetch commondata
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String sid=p.getProperty("staffID");//210001
		String pwd = p.getProperty("pwd");//password
		
		//fetch test data
		FileInputStream fi=new FileInputStream("./data/getdatafile.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("CustomerData");
		
		ChromeOptions option = new ChromeOptions(); 
	    option.addArguments("--disable-notification");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Open Account")).click();
		
		HashMap<String,String> hm=new HashMap<String, String>();  //create empty hashmap
		for(int i=0;i<sh.getLastRowNum();i++) {
			String key = sh.getRow(i).getCell(0).toString();
			String value=sh.getRow(i).getCell(1).toString();
			hm.put(key, value);
		}
		for(Entry<String, String> set:hm.entrySet()) {
			
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		//driver.findElement(By.name("name")).sendKeys("Rajhans");
		driver.findElement(By.name("gender")).click();
        driver.findElement(By.xpath("//option[@value='Male']")).click();
//		 Actions a=new Actions(driver);
//		 a.moveToElement(st).perform();
       // driver.findElement(By.name("mobile")).sendKeys("8409820806");
      //  driver.findElement(By.name("email")).sendKeys("rajhans@gmail.com");
       // driver.findElement(By.name("landline")).sendKeys("54321");
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
       // driver.findElement(By.name("pan_no")).sendKeys("DWEPM4655Q");
      //  driver.findElement(By.name("citizenship")).sendKeys("001");
       // driver.findElement(By.name("homeaddrs")).sendKeys("vill+post-Bengalore,karnatka,india");
      // findElement(By.name("officeaddrs")).sendKeys("califonia,America");
	    driver.findElement(By.name("state")).click();
	    driver.findElement(By.xpath("//option[@value='California']")).click();
	    driver.findElement(By.name("city")).click();
	    driver.findElement(By.xpath("//option[@value='Los Angeles']")).click();
	   // driver.findElement(By.name("pin")).sendKeys("802203");
	   // driver.findElement(By.name("arealoc")).sendKeys("Durga temple");
	   // driver.findElement(By.name("nominee_name")).sendKeys("sunil");
	   // driver.findElement(By.name("nominee_ac_no")).sendKeys("9876543210");
	    driver.findElement(By.name("acctype")).click();
	    driver.findElement(By.xpath("//option[@value='Saving']")).click();
	    driver.findElement(By.name("submit")).click();
	   // driver.switchTo().alert().dismiss();
	   // Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@value='Go back']")).click();
	   // Thread.sleep(2000);
	    driver.findElement(By.name("submit")).click();
	    driver.findElement(By.name("cnfrm-submit")).click();
	    Thread.sleep(1000);
	 String cData = driver.switchTo().alert().getText();
	    String apno="";
	    for(int i=0;i<cData.length();i++) {
	    	if(Character.isDigit(cData.charAt(i)))
	    		apno=apno+cData.charAt(i);
	    }
	    System.out.println("your application number is  "+apno);
	 // System.out.println(apno);
	  driver.switchTo().alert().accept();
	  driver.findElement(By.linkText("Staff Login")).click();
	  driver.findElement(By.name("staff_id")).sendKeys(sid);
	  driver.findElement(By.name("password")).sendKeys(pwd);
	  driver.findElement(By.name("staff_login-btn")).click();
	  driver.findElement(By.name("apprvac")).click();
	  driver.findElement(By.name("application_no")).sendKeys(apno);
	  driver.findElement(By.name("search_application")).click();
	  driver.findElement(By.name("approve_cust")).click();
	  String acData = driver.switchTo().alert().getText();
	    String acno="";
	    for(int i=0;i<acData.length();i++) {
	    	if(Character.isDigit(acData.charAt(i)))
	    		acno=acno+acData.charAt(i);
	    }
	    System.out.println("your account number is  "+acno);
	  
	  System.out.println("Account Approved");
	  driver.switchTo().alert().accept();
	  System.out.println("THANKS CUSTOMER");
	  System.out.println("now you are elligible to apply debit card");
	  driver.close();
	  
	    
		
	}

}
