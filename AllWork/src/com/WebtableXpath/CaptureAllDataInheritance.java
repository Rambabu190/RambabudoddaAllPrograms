package com.WebtableXpath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureAllDataInheritance {
	
	String	applicationUrl="https://www.timeanddate.com/worldclock";
	WebDriver driver;
	
	public void applicationLaunch()
	{
		
		System.setProperty("webdriver.chrome.driver","./Folder1/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get(applicationUrl);
		driver.manage().window().maximize();
	
		
	}

	public void close()
	{
		driver.quit();
		
	}
}