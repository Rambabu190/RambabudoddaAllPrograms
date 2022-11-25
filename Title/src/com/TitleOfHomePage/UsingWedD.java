package com.TitleOfHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsingWedD {
	public static void main(String args[])
	{
		String str="http://google.com";
		WebDriver driver;
	System.setProperty("webdriver.chrome.driver","./Fold1/chromedriver.exe");
	 driver=new ChromeDriver();
	// driver=new FirefoxDriver();
	 
	 driver.get(str);
	 WebElement	bro = driver.findElement(By.id(" "));
	 
	 bro.click();

	 
			
	}

}
