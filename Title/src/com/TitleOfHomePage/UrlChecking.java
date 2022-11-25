package com.TitleOfHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UrlChecking{
	public static void main(String args[])
	{
		String applicationurlAddress="http://google.com";
		System.setProperty("webdriver.chrome.driver","./Fold1/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://google.com");
		String expected_applicationUrl="google.com";
		System.out.println("the expected_application url is :"+expected_applicationUrl);
		
			String actual_applicationUrl=driver.getCurrentUrl();
			System.out.println("the actual application url is :"+ actual_applicationUrl);
		if(actual_applicationUrl.contains(expected_applicationUrl))	
		{
			System.out.println("the page url is matched:-PASS");
			
		}
		else
		{
			System.out.println("the page url is not matched -FAIL");
		}
						
					
		
	
}

}
