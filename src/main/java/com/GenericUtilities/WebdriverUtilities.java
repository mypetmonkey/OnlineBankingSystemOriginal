package com.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebdriverUtilities {
	/**
	 * this method is used to maximize window
	 * @param driver
	 * @author rajhans
	 */
	public void maximixeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	/**
	 * This method is used to implicit wait
	 * @param driver
	 * @author rajhans
	 */
   public void waitForPageLoad(WebDriver driver) {
	   driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
   }
   /**
    * this method is used to wait till visible
    * @param driver
    * @param ele
    * @author rajhans
    */
   public void elementTobeVisible(WebDriver driver,WebElement ele) {
	   WebDriverWait wait=new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.visibilityOf(ele));
   }
   /**
    * this method is used to select element by indexwise
    * @param ele
    * @param index
    * @author rajhans
    */
   public void select(WebElement ele,int index) {
	   Select s=new Select(ele);
	   s.selectByIndex(index);
	   }
   /**
    * this method is used to select element by value
    * @param ele
    * @param value
    * @author rajhans
    */
   public void selec(WebElement ele,String value) {
	   Select s=new Select(ele);
	   s.selectByValue(value);
   }
   /**
    * this method is used to select all options
    * @param ele
    * @author rajhans
    */
   public void selectAllOptions(WebElement ele) {
	   Select s=new Select(ele);
	   s.getOptions();
   }
   /**
    * this method will select the data from dropdown using visible text
    * @param visibleText
    * @param ele
    */
   public void select(String visibleText,WebElement ele) {
	   Select s=new Select(ele);
	   s.selectByVisibleText(visibleText);
   }
  
   /*
    * This method is used to click on ok on popup
    * @param driver
    * @Author:Rajhans
    */
   public void alertPopupAccept(WebDriver driver) {
	 driver.switchTo().alert().accept();  
   }
   /**
    * this method is used to click on cancel on popup
    * @param driver
    */
   
   public void alertPopupDismiss(WebDriver driver) {
		 driver.switchTo().alert().dismiss();  
	   }
   /**
    * This method is used to print text on alert popup
    * @param driver
    * @return alert popup text
    * @author rajhans
    */
   public String getTextFromAlertPopup(WebDriver driver) {
	  String alertmsg = driver.switchTo().alert().getText();
	  return alertmsg;
   }
   /**
    * This method is used to double click on element
    * @param driver
    * @param ele
    * @author rajhans
    */
   public void doubleClick(WebDriver driver,WebElement ele) {
	   Actions a=new Actions(driver);
	   a.doubleClick(ele).perform();
   }
   /**
    * This method is used to drag and drop
    * @param driver
    * @param ele1
    * @param ele2
    * @author rajhans
    */
   public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest) {
	   Actions a=new Actions(driver);
	   a.dragAndDrop(src, dest).perform();
   }
   /**
    * This method will perform mousehover
    * @param driver
    * @param ele
    * @author rajhans
    */
   public void mouseHover(WebDriver driver,WebElement ele) {
	   Actions a=new Actions(driver);
	   a.moveToElement(ele).perform();
	   
   }
   /**
    * This method will click right button
    * @param ele
    * @param driver
    * @author rajha
    */
   public void rightClick(WebElement ele,WebDriver driver) {
	   Actions a=new Actions(driver);
	  a.contextClick().perform();
	  
   }
   /**
    * this method will press enter(Action)
    * @param driver
    * @author rajha
    */
   public void enterKeyPress(WebDriver driver) {
	   Actions a=new Actions(driver);
	   a.sendKeys(Keys.ENTER).perform();
	   
   }
   /**
    * this method will press enter(robot)
    * @param driver
 * @throws AWTException
 * @author rajha 
    */
   public void enterKey(WebDriver driver) throws AWTException {
	   Robot r=new Robot();
	   r.keyPress(KeyEvent.VK_ENTER);
   }
   /**
    * this method will release enter key
    * @param driver
    * @throws AWTException
    * @author rajha
    */
   public void enterRelease(WebDriver driver) throws AWTException {
	   Robot r=new Robot();
	   r.keyRelease(KeyEvent.VK_ENTER);
   }
   /**
    * this method will switch to frame by index
    * @param driver
    * @param index
    * @author rajha
    */
   public void switchToFrame(WebDriver driver,int index) {
	   driver.switchTo().frame(index);
   }
   /**
    * this method will switch frame by name Or Id
    * @param driver
    * @param nameOrId
    * @author rajha
    */
   public void switchToFrame(WebDriver driver,String nameOrId) {
	   driver.switchTo().frame(nameOrId);
   }
   /**
    * this method is used to switch frame by element adress
    * @param driver
    * @param adress
    * @author rajha
    */
   public void switchToFrame(WebDriver driver,WebElement adress) {
	   driver.switchTo().frame(adress);
   }
   /**
    * this method is used to switch window
    * @param driver
    * @param partialTitle
    * @author rajha
    */
   public void switchToWindow(WebDriver driver,String partialTitle) {
	   //use getwindowhandles to capture all window id's
	  Set<String> windows = driver.getWindowHandles();
	  //iterate through window
	  Iterator<String> it = windows.iterator();
	  //check weather there is anext window
	  while(it.hasNext()) {
		  //capture current window id
		  String winId=it.next();
		  //switch to current window and capture title
		 String currentWindTitle = driver.switchTo().window(winId).getTitle();
		 //check weather current window is expected
		 if(currentWindTitle.contains(partialTitle)) 
			 break;
	  }
	  
   }
   /**
    * This method will takes Screenshot
    * @param driver
    * @param ssName
    * @return
    * @throws IOException
    */
   public static String getScreenshot(WebDriver driver,String ssName) throws IOException {
	  
	   TakesScreenshot t=(TakesScreenshot) driver;
	   File src=t.getScreenshotAs(OutputType.FILE);
	   String path="./screenshot/"+ssName+".png";
	   File dest=new File(path);
	   FileUtils.copyFile(src, dest);
	   return path;
   }
   /** 
    * this method will perform random scroll
    * @param driver
    */
   
   public void scrollBarAction(WebDriver driver) {
	   JavascriptExecutor j=(JavascriptExecutor) driver;
	   j.executeScript("window.scrollBY(0,800)","");
   }
   
   /**
    * this method will scroll until specified element is found
    * @param ele
    * @author rajhans
    */

public void scrollBarAction( WebDriver driver,WebElement ele) {
	  
	   JavascriptExecutor j=(JavascriptExecutor) driver;
	   int y=ele.getLocation().getY();
	   j.executeScript("window.scrollTo(0,"+y+")");
   }
/**
 * 
 */
  public void handleNotification() {
	  ChromeOptions option = new ChromeOptions(); 
	    option.addArguments("--disable-notification");
  }
  
}
