package com.ExcelOpearationsOnOHRM;





import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipleDataOnHRM

{
	WebDriver driver;
	String applicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard\"";
	 
	public void OhrmApplicationLaunh()	
	{
		
		System.setProperty("webdriver.chrome.driver","./Folder1/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(applicationUrl);
		driver.manage().window().maximize();		
	}
		
	public void screenShot() throws IOException
	{
	String	title=driver.getTitle();
		File googleScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(googleScreenShot,new File("./OrangmeHRMScreenshots/"+title+".png"));
		

		//File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//	FileUtils.copyFile(screenshot,new File("./OrangmeHRMScreenshots/OrangeHrm.png"));
	
	System.out.println("screenshot successfull");
	
	
	}
	
	public void applicationClose()
	{
		driver.quit();
	}
		
		
		
		

	

}
