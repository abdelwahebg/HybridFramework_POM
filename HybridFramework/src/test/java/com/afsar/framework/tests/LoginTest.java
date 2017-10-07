package com.afsar.framework.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest{
	public  WebDriver driver;
	@BeforeClass
	public void init(){
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\md.afsar.ali\\workspace\\HybridFramework\\Drivers\\IEDriverServer.exe");
		driver= new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void LoginFunctionality(){
		
		driver.get("http://www.newtours.demoaut.com/");
		//driver.navigate().to("https://www.google.com");
		
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		
		System.out.println("PASSED : Login Successful..");
		
	}
	
	@AfterClass
	public void teardown(){
		
		driver.quit();
	}
}
