package com.DropDown;


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
import org.openqa.selenium.support.ui.Select;

public class OsmaniaDropDown {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		
		String link="https://www.osmania.ac.in/";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./Folder1/chromedriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(3000);
		 driver.get(link);
		 
		 
		 
		 //<select onchange="doGTranslate(this);" class="notranslate" id="gtranslate_selector" aria-label="Website Language Selector" align="right" style="position:relative; z-index:1000"><option value="">Select Language</option><option value="en|hi">Hindi</option><option value="en|fr">French</option><option value="en|de">German</option><option value="en|es">Spanish</option><option value="en|el">Greek</option><option value="en|en">English</option><option value="en|te">Telugu</option><option value="en|ml">Malayalam</option><option value="en|ur">Urdu</option><option value="en|nl">Dutch</option><option value="en|ar">Arabic</option><option value="en|zh-Hans">Chinese (Simplified)</option><option value="en|ru">Russian</option><option value="en|ta">Tamil</option><option value="en|sa">Sanskrit</option><option value="en|fa">Persian (Farsi)</option><option value="en|ne">Nepali</option><option value="en|mr">Marathi</option><option value="en|mn">Mangolian	</option><option value="en|la">Latin</option><option value="en|kn">Kannada</option><option value="en|ja">Japanese</option><option value="en|it">Italian	</option><option value="en|gu">Gujarati	</option><option value="en|hu">Hungarian</option><option value="en|id ,in">Indonesian</option><option value="en|ga">Irish	</option><option value="en|th">Thai</option></select>
		 
		 WebElement	dropdown=driver.findElement(By.id("gtranslate_selector"));
		 
		// Select select=new Select(dropdown);
		
		 
		 List<WebElement>dropdownOptions=dropdown.findElements(By.tagName("option"));
		 
		 
		 
		 Select select=new Select(dropdown);
		 
		int length=dropdownOptions.size();
		for(int i=0;i<length;i++)
		{
		String	optionName=dropdownOptions.get(i).getText();
			//System.out.println(i+" "+dropdownOptions.get(i).getText());
			select.selectByIndex(i);
			Thread.sleep(2000);
			File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot,new File("./ScreenShots/"+optionName+".png"));
		
		}
		
		
		
	}

}
