package com.Exame;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) {
		String a="https://www.google.com/";
	System.setProperty("webdriver.chrome.driver","./Library/chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.get(a);
	
	
	
	}

}
