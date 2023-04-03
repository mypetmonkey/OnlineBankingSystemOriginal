package com.practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT_date {

	public static void main(String[] args) {
       ChromeOptions option = new ChromeOptions();
       option.addArguments("--disable-notification");
       WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.makemytrip.com/");
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
       driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
       driver.findElement(By.id("fromCity")).click();
       driver.findElement(By.xpath("//p[text()='Bengaluru International Airport']")).click();
       driver.findElement(By.id("toCity")).click();
       driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
       Date cd=new Date();
       String d[]=cd.toString().split(" ");
       String day=d[0];
       String month=d[1];
       String date=d[2];
       String year=d[3];
       String travelDate=day+" "+month+" "+date+" "+year;
       driver.findElement(By.xpath("//div[@area-label='"+travelDate+"']")).click();
       
       
		
	}

}
