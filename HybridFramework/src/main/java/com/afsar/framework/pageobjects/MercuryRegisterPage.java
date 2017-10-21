package com.afsar.framework.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.afsar.framework.BaseClass;
import com.afsar.framework.driverFactory.Driver;

public class MercuryRegisterPage extends BaseClass{
	
	//WebDriver driver;
	@FindBy(id="email")
	WebElement email;
	@FindBy(css="input[name='password'][type='password']")
	WebElement password;
	@FindBy(css="input[name^='confirm']")
	WebElement confirmPassword;
	@FindBy(name="register")
	WebElement register;
	@FindBy(linkText="SIGN-OFF")
	WebElement signoff;
	public MercuryRegisterPage() {
		super(Driver.getCurrentDriver());
	PageFactory.initElements(Driver.getCurrentDriver(), this);
	}
	
	public void signOFF()
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

}
