package com.afsar.framework;

import org.openqa.selenium.WebDriver;

import com.afsar.framework.driverFactory.DriverFactory;

public class TestBase {

public static WebDriver driver;
PageFactoryObject pagefactory;


private DriverFactory selenium=new DriverFactory();

	public TestBase() throws Exception{
	driver=selenium.OpenBrowser("Chrome");
	setDriver(driver);
	pagefactory=new PageFactoryObject(driver);
	
	}
	
	
	public static WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		TestBase.driver = driver;
	}

	public PageFactoryObject getPagefactory() {
		return pagefactory;
	}

	public void setPagefactory(PageFactoryObject pagefactory) {
		this.pagefactory = pagefactory;
	}

}
