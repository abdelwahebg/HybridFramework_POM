package com.afsar.framework.driverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class WebDriverListener implements IInvokedMethodListener {
	 
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("BROWSER");
            WebDriver driver = null;
			try {
				driver = DriverFactory.OpenBrowser(browserName);
			} catch (Exception e) {
				e.printStackTrace();
			}
            Driver.setCurrentDriver(driver);
        }
    }
 
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = Driver.getCurrentDriver();
            if (driver != null) {
                driver.quit();
            }
        }
    }
}