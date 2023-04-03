package com.practice;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleIcc {
	public static void main(String[] args) {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
	 List<WebElement> sln = driver.findElements(By.xpath("//tbody/tr/td[1]"));
	 List<WebElement> team = driver.findElements(By.xpath("//tbody/tr/td[2]"));
	 List<WebElement> matches = driver.findElements(By.xpath("//tbody/tr/td[3]"));
	 List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[4]"));
	 List<WebElement> ratings = driver.findElements(By.xpath("//tbody/tr/td[5]"));
	 System.out.println("sln"+"  team"+"  matches"+"  points"+"  ratings");
	 for(int i=0;i<sln.size();i++) {
		 System.out.println(sln.get(i).getText()+" =>"+team.get(i).getText()+"  ,   "+matches.get(i).getText()+"  ,   "
	 +points.get(i).getText()+"  ,   "+ratings.get(i).getText());
	 }
	 
	 driver.close();
	}
	

}
