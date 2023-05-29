package com.BoomIDHub.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	//Create one constructor with public access modifier
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
	}
	
	//Identify elements and store them into variables
	@FindBy(id="email")
	@CacheLookup
	WebElement txtusername;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="//*[@type=\"submit\"]")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(linkText="logout")
	@CacheLookup
	WebElement btnlogout;
	
	//Create action methods
	public void SetUsername(String uname)
	{
		txtusername.sendKeys(uname);
	}
	
	public void SetPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void ClickLogin()
	{
		btnlogin.click();
	}
	
	public void ClickLogout()
	{
		btnlogout.click();
	}
	
	
}
