package com.LinksFinding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinksInOsmania {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	String link="https://www.osmania.ac.in/";
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver","./File1/chromedriver.exe");
	driver=new ChromeDriver();
	Thread.sleep(3000);
	 driver.get(link);
	 
	 //<select onchange="doGTranslate(this);" class="notranslate" id="gtranslate_selector" aria-label="Website Language Selector" align="right" style="position:relative; z-index:1000"><option value="">Select Language</option><option value="en|hi">Hindi</option><option value="en|fr">French</option><option value="en|de">German</option><option value="en|es">Spanish</option><option value="en|el">Greek</option><option value="en|en">English</option><option value="en|te">Telugu</option><option value="en|ml">Malayalam</option><option value="en|ur">Urdu</option><option value="en|nl">Dutch</option><option value="en|ar">Arabic</option><option value="en|zh-Hans">Chinese (Simplified)</option><option value="en|ru">Russian</option><option value="en|ta">Tamil</option><option value="en|sa">Sanskrit</option><option value="en|fa">Persian (Farsi)</option><option value="en|ne">Nepali</option><option value="en|mr">Marathi</option><option value="en|mn">Mangolian	</option><option value="en|la">Latin</option><option value="en|kn">Kannada</option><option value="en|ja">Japanese</option><option value="en|it">Italian	</option><option value="en|gu">Gujarati	</option><option value="en|hu">Hungarian</option><option value="en|id ,in">Indonesian</option><option value="en|ga">Irish	</option><option value="en|th">Thai</option></select>
	 
	 	//=driver.findElement(By.id("gtranslate_selector"));
	
	}

}
