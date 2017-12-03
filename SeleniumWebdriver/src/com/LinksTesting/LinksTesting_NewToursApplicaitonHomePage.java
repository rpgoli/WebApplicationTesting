package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinksTesting_NewToursApplicaitonHomePage {

	public static void main(String[] args) 
	{
	
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		List<WebElement>links= driver.findElements(By.tagName("a"));

		for(int i=0;i<links.size();i++)
		{
			String linkName= links.get(i).getText();
			System.out.println(linkName);
			
			links.get(i).click();
			
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println();
			
			driver.navigate().back();
			links= driver.findElements(By.tagName("a"));
			
		}
		
		driver.close();
	}

}
