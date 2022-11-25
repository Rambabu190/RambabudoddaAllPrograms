package com.OhrmBasic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest 
{
	public WebDriver driver;
	 // String	application_URL=prop.getProperty("applicationUrlAddressKey");
	 
	public FileInputStream file;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public FileOutputStream file1;
	public FileInputStream elementsPropertiesFile;// This variable is used for WebElements PROPERTIES FILES
	public	Properties	prop;
	 
	 
	@BeforeTest
	 public void setUp() throws InterruptedException, IOException
	 {
		elementsPropertiesFile=new FileInputStream("./src/main/java/com/Ohrm/config/OHRM_Login.properties");
		prop=new Properties();
		
		prop.load(elementsPropertiesFile);
		
		if(prop.getProperty("browserNameKey").equals("chrome"))
		{
			
		System.setProperty("webdriver.chrome.driver","./DriverFiles/chromedriver.exe");
		
		 driver=new ChromeDriver();
		 
		}
		else if(prop.getProperty("browserNameKey").equals("firefox"))
		{
		
			System.setProperty("webdriver.gecko.driver","./DriverFiles/geckodriver.exe");
			
			driver=new FirefoxDriver();
		}
		 driver.get(prop.getProperty("applicationUrlAddressKey"));
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		 
		 Thread.sleep(3000);
		 
	 }

	@AfterTest
	public void tearDown()
	{	
		driver.quit();
	}
	}
	



