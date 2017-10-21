package com.afsar.framework.driverFactory;

import org.openqa.selenium.WebDriver;

public class Driver {

	private static  ThreadLocal<WebDriver> CURRENT_DRIVER = new ThreadLocal<>();

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

	public static void clearCurrentDriver() {
		
		System.out.println("Current thread removed and clearcurrentDriver() called.. ..");
		if (CURRENT_DRIVER.get() != null) {
			CURRENT_DRIVER.get().quit();
			CURRENT_DRIVER.remove();
        }
		
		CURRENT_DRIVER.remove();
	}
	
	public static void QuitDriver() {
		
		System.out.println("driver.quite called ");
		if (CURRENT_DRIVER.get() != null) {
			CURRENT_DRIVER.get().quit();
			//CURRENT_DRIVER.remove();
        }
		
		//CURRENT_DRIVER.remove();
	}


}
