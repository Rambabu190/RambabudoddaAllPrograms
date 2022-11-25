package com.Durga;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./sri/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.youtube.com/");
		
		System.setProperty("webdriver.gecko.driver","./sri/geckodriver.exe");
		WebDriver driver1 = new FirefoxDriver();
		driver1.get("https://www.youtube.com/");

	}

}
