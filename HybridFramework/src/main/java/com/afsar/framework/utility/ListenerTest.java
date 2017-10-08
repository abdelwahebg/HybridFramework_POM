package com.afsar.framework.utility;
import com.relevantcodes.extentreports.*;
import com.selenium.everestweb.framework.base.common.SeleniumDriverUtil;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by andrey.smirnov on 14.06.2016.
 */
public class ListenerTest extends SeleniumDriverUtil implements IResultListener {
	// private ExtentReports reporter =  new ExtentReports("build/SimpleReport.html", true, DisplayOrder.NEWEST_FIRST, NetworkMode.ONLINE, Locale.ENGLISH);
	    private ExtentTest testReporter;
    @Override
    public void onTestStart(ITestResult result) {
    	if (className == "report") {
			on(result.getTestClass().getName());
		}
        testReporter = reporter.startTest(result.getMethod().getMethodName(), "Description");
        testReporter.log(LogStatus.INFO, "Starting test " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	reporter.endTest(testReporter);
        testReporter.log(LogStatus.PASS, "Test PASSED");
        String screenShotPath;
        try {
			screenShotPath = takescreenshot(driver, "screenShotName");
//			screenShotPath = takescreenshot1(driver);
	        testReporter.log(LogStatus.PASS, "Snapshot below: " + testReporter.addScreenCapture(screenShotPath));
	        System.out.println(result.getMethod().getMethodName()+"Passed");
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public void onTestFailure(ITestResult result) {
		testReporter.log(LogStatus.FAIL, "Test FAILED");
		// TODO Auto-generated method stub
		reporter.endTest(testReporter);
		  String screenShotPath;
	        try {
				screenShotPath = takescreenshot(driver, "screenShotName");
//				screenShotPath = takescreenshot1(driver);
		        testReporter.log(LogStatus.FAIL, "Snapshot below: " + testReporter.addScreenCapture(screenShotPath));
		        System.out.println(result.getMethod().getMethodName()+"Failed");
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}
	@Override
    public void onFinish(ITestContext context) {
		  reporter.flush();
        //
    	//reporter.close();
		
    }
	public static String takescreenshot(RemoteWebDriver driver, String screenShot) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		System.out.println(ts);
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/SuccessScreenShot/"+screenShot + System.currentTimeMillis() + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;
	}
   // Other interface methods
}