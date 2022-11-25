package com.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Basic
{
	
	WebDriver driver;
	String applicationUrladdress="https://echoecho.com/htmlforms10.htm";
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./Folder1/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get(applicationUrladdress);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Thread.sleep(3000);
		
	}

//	@Test
//	public void add()
//	{
//		System.out.println("hi");
//	}
	
	
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
	}
}
