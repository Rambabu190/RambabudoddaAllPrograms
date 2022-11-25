package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ohrm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variable declaration
		String application_Url="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
		System.setProperty("webdriver.chrome.driver","./Fold1/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./Fold1/geckodriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//FirefoxDriver driver2=new FirefoxDriver();
		driver.get(application_Url);
		
	//	<input name="txtUsername" id="txtUsername" type="text">
	WebElement	userName=driver.findElement(By.id("txtUsername"));
	userName.sendKeys("Rambabu");
	
	//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		     WebElement password=driver.findElement(By.id("txtPassword"));
		     password.sendKeys("Oran$970");
	//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">	     
		     
		  WebElement submit_Button=driver.findElement(By.id("btnLogin")); 
		  submit_Button.click();
		//WebElement submint_Button1=driver.findElement(By.className("button"));
		//submint_Button1.click();
		   
		  
		     
		
		
		}

}
