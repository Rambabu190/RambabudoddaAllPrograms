package com.TitleOfHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ram1 {
	public static void main(String args[])
	{
		String application_Url="https://google.com";
		System.setProperty("webdriver.chrome.driver","./Fold1/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get(application_Url);
	//	<a class="gb_1 gb_2 gb_8d gb_8c" href="https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;continue=https://www.google.com/&amp;ec=GAZAmgQ" target="_top">Sign in</a>

	WebElement signin_link=driver.findElement(By.partialLinkText("Sign in"));
	
	signin_link.click();
	//<input type="email" class="whsOnd zHQkBf" jsname="YPqjbf" autocomplete="username" spellcheck="false" tabindex="0" aria-label="Email or phone" name="identifier" value="" autocapitalize="none" id="identifierId" dir="ltr" data-initial-dir="ltr" data-initial-value="">
		   
	//  WebElement	login_EmailField=driver.findElement(By.className("whsOnd zHQkBf"));

//	login_EmailField.sendKeys("rambabudoddamca190@gmail.com");
	  
WebElement	login_EmailField1=driver.findElement(By.id("identifierId"));
 login_EmailField1.sendKeys("rambabudoddamca190@gmail.com");

	  
	  
	}

}
