package com.DragAndDrop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DragAndDropOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String	applicationUrl="https://jqueryui.com/droppable";
	
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver","./Folder1/chromedriver.exe");
	
	driver=new ChromeDriver();
	
	driver.get(applicationUrl);
	
	
	

	}

}
