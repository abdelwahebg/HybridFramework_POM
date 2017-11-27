package com.afsar.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.afsar.framework.BaseClass;
import com.afsar.framework.driverFactory.Driver;

public class MercuryRegisterPage {
	
	//WebDriver driver;
	@FindBy(id="email")
	private WebElement email;
	@FindBy(css="input[name='password'][type='password']")
	private WebElement password;
	@FindBy(css="input[name^='confirm']")
	private WebElement confirmPassword;
	@FindBy(name="register")
	private WebElement register;
	@FindBy(linkText="SIGN-OFF")
	private WebElement signoff;
	
	
	public MercuryRegisterPage(WebDriver driver) {
		
	PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getConfirmPassword() {
		return confirmPassword;
	}
	public WebElement getRegister() {
		return register;
	}
	public WebElement getSignoff() {
		return signoff;
	}
	
	/*public void signOFF()
	{
		signoff.click();
	}
	public void userInfo()
	{
		email.sendKeys("askmail29");
		password.sendKeys("askmail29");
		confirmPassword.sendKeys(" ");
		register.click();
		
		
	}
*/
}
