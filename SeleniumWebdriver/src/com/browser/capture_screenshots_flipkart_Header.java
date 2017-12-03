package com.browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class capture_screenshots_flipkart_Header
{

	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		//WebElement Alert = driver.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form"));
	    WebElement Cancel = driver.findElement(By.xpath("html/body/div[2]/div/div/button"));
	    Cancel.click();
		WebElement Women =driver.findElement(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[4]/a"));
		Women.click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		WebElement Clothing = driver.findElement(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[4]/ul/li/ul/li[1]/ul/li[1]/a/span[1]"));
		Clothing.click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		WebElement EthnicWear = driver.findElement(By.xpath(".//*[@id='container']/div/div[1]/div/div/div[2]/div/div/div[1]/section/div[3]/div/div[2]/a[1]"));
		EthnicWear.click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.close();
		
	}

}