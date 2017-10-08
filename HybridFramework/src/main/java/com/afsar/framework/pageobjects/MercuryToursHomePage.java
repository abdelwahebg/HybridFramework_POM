package com.afsar.framework.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.afsar.framework.BaseClass;


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
	
	
	public static WebElement txt_ProductName() throws Exception{
        try{ 
        	 element = driver.findElement(By.linkText("REGISTER"));
            //Log.info("Product name is found on the Confirmation Page");
        	 System.out.println("Product name is found on the Confirmation Page");
        }catch (Exception e){
       		//Log.error("Product name is not found on the Confirmation Page");
       		throw(e);
       		}
       	return element;
    }
	
	
	public void sendURL(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	public void clickRegister()
	{
		sign_on.click();
	}
	public void login()
	{
		userName.sendKeys("askmail29");
		password.sendKeys("askmail29");
		signin.click();	
		
	}
	public void Click_reogister() throws Exception{
		
		txt_ProductName().click();
	}
	
}
