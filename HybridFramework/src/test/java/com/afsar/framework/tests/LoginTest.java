package com.afsar.framework.tests;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.afsar.framework.TestBase;
import com.afsar.framework.TestBase2;

public class LoginTest extends TestBase2{

	/*public LoginTest() throws Exception {
		super();
	}
*/
	/*private  WebDriver driver;
	@BeforeMethod
	@Parameters("BROWSER")
	public void init(@Optional("Chrome")String BROWSER) throws Exception{
		System.out.println("****** In Before Method init method *********");
		System.out.println("Driver instanceis created and  set current local thread");
		//Opening desired Browser driver instance
		getDriver().get("https://www.google.com");
		//Setting Current driver with threadLocal
	
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//This is Baseclass constructor (Initializaton)
	}*/

	@Test(description="This is first test same as first ")
	public void LoginFunctionality() throws Exception{

		System.out.println("*********Running first Test Case *********");
		
		getPagefactory().getHomepage().Login_Action();
		getPagefactory().getRegisterPage().Register_Action();
		
		System.out.println("PASSED : First test case : Login Successful..");

	}

	@Test(description="This is second test same as first ")
	public void LoginFunctionality1() throws Exception{

		System.out.println("*********Running second Test Case *********");
		getPagefactory().getHomepage().Login_Action();
		getPagefactory().getRegisterPage().Register_Action();

		System.out.println("PASSED : second test case : Login Successful..");

	}

	@Test(description="This is third test same as first ")
	public void LoginFunctionality2() throws Exception{

		System.out.println("*********Running third  Test Case *********");
		getPagefactory().getHomepage().Login_Action();
		getPagefactory().getRegisterPage().Register_Action();

		System.out.println("PASSED : third test case : Login Successful..");
	}

	@AfterMethod
	public void teardown(){

		System.out.println("****** In After Method tear down *********");
		System.out.println("Removing driver instance from current thread and closing all sesions");
		clearCurrentDriver();

		//getDriver().close();
	}

	@AfterTest
	public void aftertest(){

		System.out.println("*******Executing AfterTest *******");
		//clearCurrentDriver();
	}
}
