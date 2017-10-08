package com.afsar.framework.driverFactory;

import org.openqa.selenium.WebDriver;

public class Driver {

	static ThreadLocal<WebDriver> CURRENT_DRIVER = new ThreadLocal<>();

	public static WebDriver getCurrentDriver() {

		return CURRENT_DRIVER.get();
	}

	public static void setCurrentDriver(WebDriver driver) {
		CURRENT_DRIVER.set(driver);
	}

	public static void clearCurrentDriver() {
		CURRENT_DRIVER.remove();
	}


}
