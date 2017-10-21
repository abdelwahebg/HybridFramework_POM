package com.afsar.framework.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.afsar.framework.BaseClass;
import com.afsar.framework.actions.MercuryHomePage_Action;
import com.afsar.framework.driverFactory.Driver;
import com.afsar.framework.driverFactory.DriverFactory;

public class LoginTest{

	private  WebDriver driver;
	@BeforeMethod
	@Parameters("BROWSER")
	public void init(@Optional("Chrome")String BROWSER) throws Exception{
		System.out.println("****** In Before Method init method *********");
		System.out.println("Driver instanceis created and  set current local thread");
		//Opening desired Browser driver instance
		driver=DriverFactory.OpenBrowser(BROWSER);
		//Setting Current driver with threadLocal
		Driver.setCurrentDriver(driver);
		Driver.getCurrentDriver().manage().window().maximize();
		Driver.getCurrentDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//This is Baseclass constructor (Initializaton)
		new BaseClass(Driver.getCurrentDriver());
	}
	
	@Test(description="This is first test same as first ")
	public void LoginFunctionality() throws Exception{
		
		System.out.println("*********Running first Test Case *********");
		MercuryHomePage_Action.Login_Action();
		MercuryHomePage_Action.Register_Action();
		
		System.out.println("PASSED : First test case : Login Successful..");
		
	}
	
	@Test(description="This is second test same as first ")
	public void LoginFunctionality1() throws Exception{
		
		System.out.println("*********Running second Test Case *********");
		MercuryHomePage_Action.Login_Action();
		MercuryHomePage_Action.Register_Action();
		
		System.out.println("PASSED : second test case : Login Successful..");
		
	}
	
	@Test(description="This is third test same as first ")
	public void LoginFunctionality2() throws Exception{
		
		System.out.println("*********Running third  Test Case *********");
		MercuryHomePage_Action.Login_Action();
		MercuryHomePage_Action.Register_Action();
		
		System.out.println("PASSED : third test case : Login Successful..");
	}
	
	@AfterMethod
	public void teardown(){
		
		System.out.println("****** In After Method tear down *********");
		System.out.println("Removing driver instance from current thread and closing all sesions");
		//Driver.getCurrentDriver().quit();
		Driver.QuitDriver();
	}
	
	@AfterTest
	public void aftertest(){
		Driver.clearCurrentDriver();
	}
}
