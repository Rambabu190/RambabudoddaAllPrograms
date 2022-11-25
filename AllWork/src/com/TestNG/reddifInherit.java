package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class reddifInherit extends reddiff{
	
	@Test(priority=1)
	public void fullNameText() throws InterruptedException
	{
		
		//<input type="text" name="login2ef6259e" value="" style="width:185px;" maxlength="30" onclick="javascript:UncheckAllOptions();" onfocus="javascript:checkFullName(document.forms[0].name2ef6259e.value);" onblur="fieldTrack(this);">
		
		//<input type="text" onblur="fieldTrack(this);" name="name2ef6259e" value="" style="width:185px;" maxlength="61">
		
		//			ABSOLUTE X-PATHB
		
		//  /html/body/center/form/div/table[2]/tbody/tr[3]/td[3]/input
		//											//attribute	=	value
		//<input type="text" onblur="fieldTrack(this);" name="name2ef6259e" value="" style="width:185px;" maxlength="61">
		//<input type="text" onblur="fieldTrack(this);" name="namec1049f2d" value="" style="width:185px;" maxlength="61">
		///html/body/center/form/div/table[2]/tbody/tr[3]/td[3]/input
		
		//	WebElement	fullNameTextBox=driver.findElement(By.name("namec1049f2d"));
		//		
		//	fullNameTextBox.sendKeys("Rambabu");
		
		//inspect by x-path
		//	Thread.sleep(3000);
		///html/body/center/form/div/table[2]/tbody/tr[3]/td[3]/input
		
						//RELATIVE	- XPATH
		
			WebElement	fullNameTextBox=driver.findElement(By.xpath("//*[starts-with(@name,'name')]"));
	
			fullNameTextBox.sendKeys("Rambabu");
		
	//}
		
	//YOU TUBE
//		@Test(priority=1)
//		public void searchTest() throws InterruptedException
//		{
//			//id="search"
//			//name="search_query"
//			Thread.sleep(2000);
//		WebElement	search1=driver.findElement(By.name("search_query"));
//		search1.sendKeys("National Anthem");
//		
//		//WHEN WE USE KEYS FROM KEY BOARD THEN WE CREATE A OBJECT FOR ACTIONS CLASS
//	Actions action=new Actions(driver);
//	
//	action.sendKeys(Keys.ENTER).build().perform();
//			
//			
//			
		}
//	
	
	
}
