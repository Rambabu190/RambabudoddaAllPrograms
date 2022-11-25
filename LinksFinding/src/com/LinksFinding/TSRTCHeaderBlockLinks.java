package com.LinksFinding;




import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TSRTCHeaderBlockLinks {


//	private static final String FileUtils = null;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		String	tsrtc_Link="https://www.tsrtconline.in/oprs-web/";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./File1/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(tsrtc_Link);
			
			/*<div class="menu">
			<a class="selectedtabcopy" href="/oprs-web/guest/home.do?h=1" target="_top" title="Home">
					Home</a>
				<a class="tabcopy blinking" href="/oprs-web/guest/specialHire.do" target="_top" title="Bus on Contract">Bus on Contract</a>
				<a class="tabcopy" href="/oprs-web/ticket/waitlist.do" target="_top" title="Enquiry">Enquiry</a>
				<a class="tabcopy" href="/oprs-web/guest/ticket/cancel.do" target="_top" title="Cancel Tickets">Cancel Tickets</a>
				<a class="tabcopy" href="/oprs-web/services/cancel.do" target="_top" title="Cancelled Services">Cancelled Services</a>
				<a class="tabcopy" href="/oprs-web/home/aboutus.do" target="_top" title="About Us">About Us</a>
				<a class="tabcopy blinking" href="/oprs-web/services/packagetours.do" target="_top" title="Tourism">Tourism</a>
				<a class="tabcopy" href="/oprs-web/services/driverInfo.do" target="_top" title="Driver Info">Driver Info</a>
				<!-- <a class="tabcopy" href="https://forms.gle/BVVhmKJ8gnd7rWvr8" target="_blank" title="Customer Survey Form" style="float: right !important;">Customer Survey Form</a> -->
</div> */

		WebElement header_Block=driver.findElement(By.className("menu"));
		List<WebElement>header_Block_Links=header_Block.findElements(By.tagName("a"));
		int	headerBlockLinklength=header_Block_Links.size();
		Thread.sleep(3000);
		for(int i=0;i<headerBlockLinklength;i++)
			
		{
		String	headerBlockLinks=header_Block_Links.get(i).getText();
		System.out.println(i+" "+headerBlockLinks);
		
		header_Block_Links.get(i).click();// Testing the element
		
		File TsrtcScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(TsrtcScreenShot,new File("./RamScreenshots/TSRTCScreenshot1.png"));
		//org.apache.commons.io.FileUtils.copyFile(TsrtcScreenShot, new File("./RamScreenshsots/"+headerBlockLinks+"Ts.png"));
		
		
		Thread.sleep(2000);
		
		String	webPageTitle=driver.getTitle();		
		System.out.println(webPageTitle);
	
		//Getting Current Url Address
	
		String	webPageUrlAddress=driver.getCurrentUrl();
		System.out.println(webPageUrlAddress);
	
		//Coming to Previous Page
	
		driver.navigate().back(); 
		
		//identify the header Block again
		
		WebElement header_Block1=driver.findElement(By.className("menu"));
		
		//getting elements of the header Block into same array list
					
		header_Block_Links=header_Block1.findElements(By.tagName("a"));
		
		
	
		}
		
		

	


	}

}



