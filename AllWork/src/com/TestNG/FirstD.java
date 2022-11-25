	package com.TestNG;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class FirstD
	{
		WebDriver driver;
		
		String applicationUrladdress="https://www.youtube.com/";
		
		//String applicationUrladdress="http://register.rediff.com/register/register.php?FormName=user_details";
		
	@BeforeTest
	public void setUp()
	{

		System.setProperty("webdriver.chrome.driver","./Folder1/chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get(applicationUrladdress);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	@Test(priority=1)
	public void searchTest() throws InterruptedException
	{
		//id="search"
		//name="search_query"
		Thread.sleep(2000);
	WebElement	search1=driver.findElement(By.id("search"));
	search1.sendKeys("National Anthem");

	//WHEN WE USE KEYS FROM KEY BOARD THEN WE CREATE A OBJECT FOR ACTIONS CLASS
	Actions action=new Actions(driver);

	action.sendKeys(Keys.ENTER).build().perform();
		
		
		
	}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

