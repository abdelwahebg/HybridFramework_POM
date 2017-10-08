package com.afsar.framework.driverFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.afsar.framework.utility.Log;

public class Driver {

	static ThreadLocal<WebDriver> CURRENT_DRIVER = new ThreadLocal<>();
	
	public static WebDriver getCurrentDriver() {
		
        return CURRENT_DRIVER.get();
    }
	
	
public static WebDriver driver;
	
	@Parameters("BROWSER")
	public static WebDriver OpenBrowser(@Optional("BROWSER") String BrowserName,int iTestCaseRow) throws Exception{
	String sBrowserName;
	try{
	sBrowserName = "Mozilla";
	if(sBrowserName.equals("Mozilla")){
		driver = new FirefoxDriver();
		Log.info("New driver instantiated");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Log.info("Implicit wait applied on the driver for 10 seconds");
	    //driver.get(Constant.URL);
	    Log.info("Web application launched successfully");
		}
	}catch (Exception e){
		Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
	}
	return driver;
}

    public static void setCurrentDriver(WebDriver driver) {
        CURRENT_DRIVER.set(driver);
    }

    public static void clearCurrentDriver() {
        CURRENT_DRIVER.remove();
    }
	
	
}
