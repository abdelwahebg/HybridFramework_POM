package com.afsar.framework.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.afsar.framework.BaseClass;
import com.afsar.framework.driverFactory.Driver;

public class MercuryToursHomePage extends BaseClass{

	
	private static WebElement element = null;
	@FindBy(linkText="SIGN-ON")
	WebElement sign_on;
	@FindBy(name="userName")
	WebElement userName;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="login")
	WebElement signin;
	/*@FindBy(linkText="REGISTER")
	WebElement link_register;*/


	public MercuryToursHomePage() {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static WebElement link_Register() throws Exception{
		try{ 
			element = Driver.getCurrentDriver().findElement(By.linkText("REGISTER"));

			System.out.println("Register button is found ");
		}catch (Exception e){
			System.out.println("Register button is not  found ");
			throw(e);
		}
		return element;
	}


	public void sendURL(String url)
	{
		driver.get(url);
		System.out.println("URL is sent succesfully..");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	public void clickRegister()
	{
		sign_on.click();
		System.out.println("Clicked on the Sign -on button ");
	}
	public void login()
	{
		userName.sendKeys("askmail29");
		System.out.println("User name Entered ");
		password.sendKeys("askmail29");
		System.out.println("Password entered ");
		signin.click();	
		
		System.out.println("Sign -in clicked ");

	}
	public void Click_reogister() throws Exception{

		link_Register().click();
	}

}
