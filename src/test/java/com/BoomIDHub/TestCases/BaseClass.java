package com.BoomIDHub.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.BoomIDHub.Utilities.ReadConfig;

public class BaseClass {

	    ReadConfig readconfig=new ReadConfig();
	    String baseUrl=readconfig.getApplicationURL();
	    String username=readconfig.getUseremail();
		String password=readconfig.getPassword();
		
		
		public static WebDriver driver;
		
	 public static Logger logger;
		
		@BeforeClass
		@Parameters("browser")
		public void setup(String br)
		{
			logger=Logger.getLogger("BoomIDHub");
			 PropertyConfigurator.configure("log4j.properties");
			
			 if(br.equals("chrome"))
			 {
				 System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
				 driver=new ChromeDriver();
				 driver.manage().window().maximize();			
			 }
			 else
			 {
				 System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
				 driver=new FirefoxDriver();
				 driver.manage().window().maximize();
				
			 }
		}
		
		
		@AfterClass
		public void tearDown()
		{
			driver.close();
		}
		
		public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
		
	
}
