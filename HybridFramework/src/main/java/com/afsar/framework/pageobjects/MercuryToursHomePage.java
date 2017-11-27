package com.afsar.framework.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.afsar.framework.BaseClass;
import com.afsar.framework.driverFactory.Driver;

public class MercuryToursHomePage {

	
	private static WebElement element = null;
	private WebDriver driver;
	
	@FindBy(linkText="SIGN-ON")
	private WebElement sign_on;
	@FindBy(name="userName")
	private WebElement userName;
	@FindBy(name="password")
	private WebElement password;
	@FindBy(name="login")
	private WebElement signin;
	@FindBy(linkText="REGISTER")
	private WebElement link_register;
	
	
	public WebElement getLink_register() {
		return link_register;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSign_on() {
		return sign_on;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignin() {
		return signin;
	}



	public MercuryToursHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/*public  WebElement link_Register() throws Exception{
		try{ 
			element = driver.findElement(By.linkText("REGISTER"));

			System.out.println("Register button is found ");
		}catch (Exception e){
			System.out.println("Register button is not  found ");
			throw(e);
		}
		return element;
	}*/


	/*public void sendURL(String url)
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
*/
}
