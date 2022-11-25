package com.Grid;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class OrangeHRMLoginTest
{
	@Test
	public void LogInTest() throws MalformedURLException
	{
		System.out.println("Logintest Success");
		
		DesiredCapabilities cap=null;
		
		cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
	
	
	RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.85:4444/wd/hub"),cap);
	
	
	String	application_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard\"";
	driver.get(application_URL);
	}
	
	

}
