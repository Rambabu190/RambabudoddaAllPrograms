package com.TitleOfHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdentifyTitleOfBingHomePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./Fold1/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://bing.com");
			String expected_bingTitle="bing";
		//identify the title of bing home page
				String	actual_bingTitle=driver.getTitle();
				System.out.println("the actual title is :"+actual_bingTitle);
				
				if(actual_bingTitle.equalsIgnoreCase(expected_bingTitle))
				{
				System.out.println("the page name matched - PASS");
				}
				else
				{
					System.out.println("the page name not matched - FAIL");
				}
				driver.quit(); 
		
	/*	if(str.equals(str1))
		{
			System.out.println("the two strings are equal");
			+
		}
		else
		{
			System.out.println("the two strings are not equals");
		} */
				
	}

} 
