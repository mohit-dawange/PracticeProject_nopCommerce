package com.BoomIDHub.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class QuizFlowNavigation {
	
	@Test
	public void loginTeest() throws InterruptedException
	{
		//Launch chrome browser
		System.setProperty("webdriver.chrome.driver","C:\\eclips-workspace\\BoomIDHub\\Drivers\\chromedriver2.exe");
		WebDriver driver=new ChromeDriver();
		
		//Maximize your window
		driver.manage().window().maximize();
		
		//Launch url
		driver.get("https://www.ipsy.com/");
		
		driver.findElement(By.xpath("//*[@id=\"get-started-splash-button\"]/div")).click();
		
		Thread.sleep(2);
	
			
		//
		String act_title=driver.getTitle();
		String exp_title="Take our Beauty Quiz to personalize your first box!";
		
		
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
