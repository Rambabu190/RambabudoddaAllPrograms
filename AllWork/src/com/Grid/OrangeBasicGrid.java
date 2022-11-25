package com.Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class OrangeBasicGrid {
	
	WebDriver driver;
	String	application_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard\"";
	
	@Test(priority=1)
	public void setUp() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		Thread.sleep(2000);
		
		System.setProperty("webdriver.chrome.driver","./Folder1/chromedriver.exe");
		driver=new RemoteWebDriver(new URL("http://192.168.104.135:4444/wd/hub"),cap);
	}

	@Test(priority=2)
	public void login() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.get(application_URL);
		WebElement userName=driver.findElement(By.xpath("//*[@id='txtUsername']"));
		userName.clear();
		userName.sendKeys("Rambabu");

		WebElement password=driver.findElement(By.name("txtPassword"));
		password.clear();
		password.sendKeys("Oran$970");

		WebElement logInButton=driver.findElement(By.className("button"));
		logInButton.click();
		
		System.out.println("Successfully login completed");
	}
}
