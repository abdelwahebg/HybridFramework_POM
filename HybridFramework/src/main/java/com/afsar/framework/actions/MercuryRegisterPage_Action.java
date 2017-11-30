package com.afsar.framework.actions;

import org.openqa.selenium.WebDriver;

import com.afsar.framework.pageobjects.MercuryRegisterPage;
import com.afsar.framework.pageobjects.MercuryToursHomePage;

public class MercuryRegisterPage_Action {
	
	private static MercuryRegisterPage register;
	private static  MercuryToursHomePage hm;
	
	public MercuryRegisterPage_Action(WebDriver driver){
		
		register=new MercuryRegisterPage(driver);
		hm=new MercuryToursHomePage(driver);	
	}
	
	
	public void Register_Action() throws InterruptedException {

		System.out.println("****** Executing Register Action *********");
		register.getSignoff().click();
		Thread.sleep(5000);
		hm.getLink_register().click();
		register.getEmail().sendKeys("askmail29");
		register.getPassword().sendKeys("askmail29");
		register.getConfirmPassword().sendKeys("afsar");
	}

}
