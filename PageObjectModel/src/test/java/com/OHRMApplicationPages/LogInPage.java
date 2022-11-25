package com.OHRMApplicationPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.BaseTest.BaseTest;

public class LogInPage extends BaseTest
{

	public LogInPage()//1.We are Using Constructor
	{
		PageFactory.initElements(driver,this);
	}
	//Object Repository//Here Objects are nothing but web Elements
	
	//FindBy  coming from PageFactory//PageFactory coming from selenium.support
	//here no TestNG
	
	//<div id="logInPanelHeading">LOGIN Panel</div>
//		WebElement	logInTxt=driver.findElement(By.id("logInPanelHeading"));
//		logInTxt.
//	DDDDDDDDDDDDDDDDDDOOOOOOOOOOOUUUUUUUUUUUUUUUUBBBBBBBBBBBBBBTTTTTTTTTTTTTTT////////
	
	
	@FindBy(id="logInPanelHeading")
	WebElement logInPanelTextE;
	
	
	//HERE WE WANT FO FIND  PAGE LOGO THEN WE WANT XPATH
	///html/body/div[1]/div/div[2]/div/img
	
	@FindBy(xpath="html/body/div[1]/div/div[2]/div/img")
	WebElement ohrmLogInPageLogoE;
	
	
	//<input name="txtUsername" id="txtUsername" type="text">
	@FindBy(id="txtUsername")
	WebElement userNameE;
	
	//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
	@FindBy(name="txtPassword")
	WebElement passwordE;
	
	
	//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	@FindBy(id="btnLogin")
	WebElement logInButtonE;
	
	
	//BUISINES LOGICS /USER DEFINE METHODS
	//	WE ARE USING TestNG in Buisines Logics Only
	
	public void logInPanelTextValidation()
	{
		
		String logInPage_expectedText="LOGIN Panel";
		String logInPage_actualText=logInPanelTextE.getText();
		
		//					String actual,		String expected			, String Message
		Assert.assertEquals(logInPage_actualText, logInPage_expectedText," Text not Matched - Fail");
		
	}
	
	
	public void logInPageLogoValidation()
	{
		
		boolean flag=ohrmLogInPageLogoE.isDisplayed();
		Assert.assertTrue(flag, "OrangeHRM LogIn Page Logo Not Found");
	}
	
	public void logIn(String userName,String password)
	{
		userNameE.sendKeys(userName);
		passwordE.sendKeys(password);
		logInButtonE.click();
		
		
	}
	
	
	// here
	public void logInPageTitleValidation()
	{
		String expected_logInPageTitle="OrangeHRM";
		String actual_logInPageTitle=driver.getTitle();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(actual_logInPageTitle, expected_logInPageTitle, "OHRMApplication Login Page Title Not Matched");
		
	}
	
	public void logInPageUrlAddressValidation()
	{
		String expected_OhrmlogInPageUrlAddress="orangehrm";
		
		String actual_OhrmlogInPageUrlAddress=driver.getCurrentUrl();
		//System.out.println("the actual url is"+actual_OhrmlogInPageUrlAddress);
		
		Assert.assertTrue(actual_OhrmlogInPageUrlAddress.contains(expected_OhrmlogInPageUrlAddress));
		//Assert.assertFalse(actual_OhrmlogInPageUrlAddress.contains(actual_OhrmlogInPageUrlAddress));
		
		
	}
	
	
	
}
