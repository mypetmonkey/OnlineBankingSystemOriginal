 package com.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkFinder {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
			driver.get("https://flipkart.com/");
			List<WebElement> links = driver.findElements(By.tagName("a"));
			int count=links.size();
			System.out.println(count);
			for(WebElement link:links) {
				String url=link.getAttribute("href");
				if(url==null||url.isEmpty()) {
					System.out.println("empty url");
					continue;
				}
				try {
					HttpURLConnection huc = (HttpURLConnection)(new URL(url).openConnection());
					huc.connect();
					if(huc.getResponseCode()>=400) {
						System.out.println(url+" is broken");
					}
					else {
						System.out.println(url+" is VALID");
					}
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				
			}
		}
		driver.close();
		
	}

}
