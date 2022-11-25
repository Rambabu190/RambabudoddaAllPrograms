package com.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class reddiff
{
	WebDriver driver;
	
	//String applicationUrladdress="https://www.youtube.com/";
	
	String applicationUrladdress="http://register.rediff.com/register/register.php?FormName=user_details";
	
@BeforeTest
public void setUp()
{

	System.setProperty("webdriver.chrome.driver","./Folder1/chromedriver.exe");
	 driver=new ChromeDriver();
	driver.get(applicationUrladdress);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
}
}
