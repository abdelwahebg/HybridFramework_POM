package com.afsar.framework.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.afsar.framework.BaseClass;
import com.afsar.framework.actions.MercuryHomePage_Action;
import com.afsar.framework.driverFactory.Driver;
import com.afsar.framework.driverFactory.DriverFactory;

public class LoginTest{
	//private  WebDriver driver1;
	private  WebDriver driver;
	@BeforeClass
	@Parameters("BROWSER")
	public void init(@Optional("Chrome")String BROWSER) throws Exception{
		Driver.setCurrentDriver(DriverFactory.OpenBrowser(BROWSER));
		driver=Driver.getCurrentDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		new BaseClass(driver);
	}
	
	@Test
	public void LoginFunctionality() throws Exception{
		
		
		MercuryHomePage_Action.Login_Action();
		MercuryHomePage_Action.Register_Action();
		
		System.out.println("PASSED : Login Successful..");
		
	}
	
	@AfterClass
	public void teardown(){
		
		driver.quit();
	}
}
