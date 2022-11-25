package com.Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;






public class OrangeSir 
{
	
		@Parameters("Browser")
		@Test
		public void LogInTest(String browserName) throws MalformedURLException, InterruptedException
		{
			Thread.sleep(2000);
			DesiredCapabilities cap=null;
			
			if(browserName.equals("chrome"))
			{
	
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			}
			else
				if(browserName.equals("firefox"))
				{
					cap=DesiredCapabilities.firefox();
					cap.setBrowserName("firefox");
					cap.setPlatform(Platform.WINDOWS);
					
					
				}	
			Thread.sleep(3000);
		
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.104.135:4444/wd/hub"),cap);
		
		Thread.sleep(3000);
		
		String	application_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard\"";
		driver.get(application_URL);
		}
		
		

	}

	//
	


