package com.afsar.framework;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	
	protected static  WebDriver driver;
	
	public static Boolean bResult;
	
	public BaseClass(WebDriver driver){
		
		this.driver=driver;
		BaseClass.bResult=true;
	}

}
