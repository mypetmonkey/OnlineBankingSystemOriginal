package com.practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;


 
public class NonSelectQuaryTest {
	public static void main(String[] args) throws Throwable { 
		Connection con=null;
		 String expproj="OBS8";
		 try {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul/li/a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("online banking");
	    driver.findElement(By.name("createdBy")).sendKeys("Rajhans")	;
	     WebElement val = driver.findElement(By.name("status"));
	     Select s=new Select(val);
	     s.selectByValue("Created");
	    driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	   
	    
	   
   Driver d=new Driver();
   DriverManager.registerDriver(d);
   DriverManager.getConnection(expproj, expproj, expproj);
	   con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
	   Statement st = con.createStatement();
	  ResultSet res = st.executeQuery("SELECT * FROM PROJECT ");
	  boolean flag=false;
	  
	     while(res.next()) 
	     {
	    	String actproj = res.getString(4);
	    	System.out.println(actproj);
	    	if(expproj.equalsIgnoreCase(actproj)) 
	    	{
	    		flag=true;
	    		break;
	    	}
	     }
	     if(flag)
	    	 System.out.println(" project created");
		 
		 } catch(Exception e) {
	    	
	    }
	  finally {
		  con.close();
	  }
	}
}
