package com.ScreenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakingScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String	tsrtc_Link="https://www.tsrtconline.in/oprs-web/";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./Folder1/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(tsrtc_Link);

//	File tsrtcScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
//	FileUtils.copyFile(tsrtcScreenShot,new File("./ScreenShots/TsrtcHomePage1.png"));
//	driver.quit();
	
	File googleScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(googleScreenShot,new File("./ScreenShots/Tsarsadss4.png"));
	

	}

}
































