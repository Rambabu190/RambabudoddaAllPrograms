package com.OHRM.TestCases;

import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.OHRMApplicationPages.LogInPage;

public class LogInPageTest extends BaseTest 
{
	LogInPage lip;	//create an variable it should be of  ObjectRepository class name type
	
	@Test(priority=1)
	public void logInPanelTextValidationTest()
	{
		lip=new LogInPage();
		lip.logInPanelTextValidation();
		
	}
	
	@Test(priority=2)
	public void logInPageLogoValidationTest()
	{
		lip=new LogInPage();
		lip.logInPageLogoValidation();
	}
	
	@Test(priority=3)
	public void logInTest()
	{
		lip=new LogInPage();
		lip.logIn("Rambabu", "Oran$970");
	}
	
	
	@Test(priority=4)
	public void logInPageTitleValidationTest()
	{
		lip=new LogInPage();
		lip.logInPageTitleValidation();
	}
	
	@Test(priority=5)
	public void logInPageUrlAddressValidationTest()
	{
		lip=new LogInPage();
		lip.logInPageUrlAddressValidation();
		System.out.println("LogInpage Url validation is Successfully completed");
		
	}
	
	
	
}
