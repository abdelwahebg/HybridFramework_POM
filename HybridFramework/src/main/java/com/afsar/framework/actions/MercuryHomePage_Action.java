package com.afsar.framework.actions;

import org.openqa.selenium.WebDriver;

import com.afsar.framework.pageobjects.MercuryRegisterPage;
import com.afsar.framework.pageobjects.MercuryToursHomePage;

public class MercuryHomePage_Action {
	
	private static MercuryToursHomePage hm;
	
	public MercuryHomePage_Action(WebDriver driver){
		hm=new MercuryToursHomePage(driver);
		
	}
	
	//private static MercuryRegisterPage register = new MercuryRegisterPage();

	public void Login_Action(){
		System.out.println("**** Executing Logine Action *********");
		hm.getDriver().get("http://www.newtours.demoaut.com/");
		hm.getSign_on().click();
		hm.getUserName().sendKeys("askmail29");
		hm.getPassword().sendKeys("askmail29");
		hm.getSignin().click();
	}

	


}
