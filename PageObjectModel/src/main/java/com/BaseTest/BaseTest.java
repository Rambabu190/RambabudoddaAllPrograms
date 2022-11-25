package com.BaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest
{
	//public static WebDriver driver;
	public static WebDriver driver;
	String applicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard\"";
	
	@BeforeMethod
	public void tearDown()
	{
		System.setProperty("webdriver.chrome.driver", "./driverFiles/chromedriver.exe");
		driver=new ChromeDriver();
	
		driver.get(applicationUrl);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@AfterMethod()
	public void ram()
	{
		driver.quit();
	}
	
	
	
}





