package com.afsar.framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.afsar.framework.driverFactory.DriverFactory;

public class TestBase2 {

private WebDriver driver;
PageFactoryObject pagefactory;


private DriverFactory selenium;

private static  ThreadLocal<WebDriver> CURRENT_DRIVER = new ThreadLocal<>();

	/*public TestBase2() throws Exception{
	driver=selenium.OpenBrowser("Chrome");
	setDriver(driver);
	pagefactory=new PageFactoryObject(driver);
	
	}*/
	
	@BeforeMethod
	public void before_method() throws Exception{
		
		System.out.println("**********Before method **************");
		selenium=new DriverFactory();
		driver=selenium.OpenBrowser("Chrome");
		setCurrentDriver(driver);
		pagefactory=new PageFactoryObject(getCurrentDriver());
		
	}
	
	/*@AfterMethod
	public void after_method(){
		//getDriver().quit();
		System.out.println("**********After method **************");
	}*/
	
	
	
	

	public static WebDriver getCurrentDriver() {
		System.out.println("Get curent thread method is called ..");	
		Long callingThreadID = new Long(Thread.currentThread().getId());
		System.out.println("Current thread id :"+callingThreadID +" thread name is :"+Thread.currentThread().getName());
		return CURRENT_DRIVER.get();
	}

	public static void setCurrentDriver(WebDriver driver) {
		System.out.println("Set current thread method is called ..");
		CURRENT_DRIVER.set(driver);
	}
	
	public  void clearCurrentDriver() {
		
		System.out.println("Current thread removed and clearcurrentDriver() called.. ..");
		if (CURRENT_DRIVER.get() != null) {
			CURRENT_DRIVER.get().quit();
			CURRENT_DRIVER.remove();
        }
		
		CURRENT_DRIVER.remove();
	}
	
	
	
	
	
	
	public  WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public PageFactoryObject getPagefactory() {
		return pagefactory;
	}

	public void setPagefactory(PageFactoryObject pagefactory) {
		this.pagefactory = pagefactory;
	}

}
