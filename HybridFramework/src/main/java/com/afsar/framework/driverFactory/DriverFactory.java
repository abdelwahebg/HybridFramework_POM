package com.afsar.framework.driverFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.afsar.framework.utility.Log;

public class DriverFactory {

	//private static WebDriver driver;

	//@Parameters("BROWSER")
	public static WebDriver OpenBrowser(String BROWSER) throws Exception{
		 WebDriver driver=null;
		try{
			if(BROWSER.equals("Mozilla")){
				driver = new FirefoxDriver();
				Log.info("New driver instantiated");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Log.info("Implicit wait applied on the driver for 10 seconds");
				//driver.get(Constant.URL);
				Log.info("Web application launched successfully");
			}else if(BROWSER.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Afsar\\git\\HybridFramework_POM\\HybridFramework\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
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


}
