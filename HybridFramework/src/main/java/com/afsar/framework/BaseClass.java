package com.afsar.framework;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static Boolean bResult;
	
	public BaseClass(WebDriver driver){
		
		BaseClass.driver=driver;
		BaseClass.bResult=true;
	}

}
