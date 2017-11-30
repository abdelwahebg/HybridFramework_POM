package com.afsar.framework;

import org.openqa.selenium.WebDriver;

import com.afsar.framework.actions.MercuryHomePage_Action;
import com.afsar.framework.actions.MercuryRegisterPage_Action;

public class PageFactoryObject {
	
	private static  MercuryRegisterPage_Action reg;
	private static  MercuryHomePage_Action homepage;
	
	public PageFactoryObject(WebDriver driver){
		
		reg=new MercuryRegisterPage_Action(driver);
		homepage=new MercuryHomePage_Action(driver);
	}

	public MercuryRegisterPage_Action getRegisterPage() {
		return reg;
	}

	public MercuryHomePage_Action getHomepage() {
		return homepage;
	}
	
	

}
