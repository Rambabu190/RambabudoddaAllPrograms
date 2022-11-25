package com.MrsLogin;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MrsPage {

	public static void main(String args[])
	{
		String application_Url="https://demo.openmrs.org/openmrs/login.htm";
		System.setProperty("webdriver.chrome.driver","./Fold1/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get(application_Url);
		//<input class="form-control form-control-sm form-control-lg form-control-md" id="username" type="text" name="username" placeholder="Enter your username">
		 
		driver.findElement(By.id("username")).sendKeys("Admin");
		//<input class="form-control form-control-sm form-control-lg form-control-md" id="password" type="password" name="password" placeholder="Enter your password">
	driver.findElement(By.id("password")).sendKeys("Admin123");
	
	//<li id="Inpatient Ward" tabindex="0" value="6" data-key="1" class="selected">Inpatient Ward</li>
	
	driver.findElement(By.id("Inpatient Ward")).click();
	//<input id="loginButton" class="btn confirm" type="submit" value="Log In">


	driver.findElement(By.id("loginButton")).click();
	//<span class="location-error" id="sessionLocationError" style="">You must choose a location!</span>
	//driver.findElement(By.id("sessionLocationError")).click();
	}

}
