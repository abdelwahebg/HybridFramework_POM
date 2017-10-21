package com.afsar.framework.actions;

import com.afsar.framework.pageobjects.MercuryRegisterPage;
import com.afsar.framework.pageobjects.MercuryToursHomePage;

public class MercuryHomePage_Action {
	private static MercuryToursHomePage hm=new MercuryToursHomePage();
	private static MercuryRegisterPage register = new MercuryRegisterPage();

	public static  void Login_Action(){
		System.out.println("**** Executing Logine Action *********");
		hm.sendURL("http://www.newtours.demoaut.com/");
		hm.clickRegister();
		hm.login();
	}

	public static void Register_Action() throws Exception{

		System.out.println("****** Executing Register Action *********");
		register.signOFF();
		Thread.sleep(5000);
		hm.Click_reogister();
		register.userInfo();
	}


}
