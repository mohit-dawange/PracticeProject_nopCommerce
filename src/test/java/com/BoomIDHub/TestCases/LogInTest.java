package com.BoomIDHub.TestCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;


public class LogInTest  {

	@Test
	public void loginTest() throws InterruptedException
	{
		//Launch chrome browser
		System.setProperty("webdriver.chrome.driver","C:\\eclips-workspace\\BoomIDHub\\Drivers\\chromedriver2.exe");
		WebDriver driver=new ChromeDriver();
		
		//Maximize your window
		driver.manage().window().maximize();
		
		//Launch url
		driver.get("https://www.ipsy.com/");
		
		driver.findElement(By.xpath("//*[@id=\"login-splash-button\"]/div")).click();
		
		Thread.sleep(2);
		
		//Store  web element in variable
		WebElement username=driver.findElement(By.id("id-username"));
		username.sendKeys("admin@mailinator.com");
		
		//Use element directly
		driver.findElement(By.id("id-password")).sendKeys("ipsytest");
		
		//Click method
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		//
		String act_title=driver.getTitle();
		String exp_title="Glam Bag|IPSY";
		
		
		Thread.sleep(3);
		if(act_title.equals(exp_title))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		driver.close();
	}
	
}
