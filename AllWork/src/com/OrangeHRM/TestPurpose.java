package com.OrangeHRM;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPurpose {

	

WebDriver driver;
String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";

@BeforeTest
public void orangeHRMApplicationLaunch()
{
	


 System.setProperty("webdriver.chrome.driver","./Folder1/chromedriver.exe");
 
driver = new ChromeDriver();
// System.out.println(" Chrome Browser Opened Successfully");


driver.get(applicationUrlAddress);
//System.out.println(" Naviagted to OrangeHRM Application Successfully  ");



driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}


@Test(priority=1)
public void logInTest() throws InterruptedException
{
WebElement userName=driver.findElement(By.id("txtUsername"));
userName.clear();
userName.sendKeys("Rambabu");

//System.out.println(" Entered UserName Successfully ");


WebElement password=driver.findElement(By.name("txtPassword"));
password.clear();
password.sendKeys("Oran$970");

//System.out.println(" Entered Password Successfully ");

//		String	login=driver.getCurrentUrl();
//		System.out.println("The login page URL is"+login);

WebElement logInButton=driver.findElement(By.className("button"));
logInButton.click();

Thread.sleep(2000);
WebElement	invalid=driver.findElement(By.id("spanMessage"));///11111111111111111111111
//WebElement welComeAdminElement=driver.findElement(By.id("welcome"));

if(invalid.isDisplayed())
{
	System.out.println("invalid credentials");
}

else
	//if(welComeAdminElement.isDisplayed())
{
	System.out.println("login Susccessfull");
}



//
//String	homePage=driver.getCurrentUrl();
//System.out.println("homePage Url is"+homePage);

//<span id="spanMessage">Invalid credentials</span>
//WebElement	invalid=driver.findElement(By.id("spanMessage"));
//String	data=invalid.getText();
//System.out.println(data);



//System.out.println(" Clicked on LogIn Button Successfully ");


}
//
//@Test(priority=2)
//public void welComeAdminTest() throws InterruptedException
//{
//WebElement welComeAdminElement=driver.findElement(By.id("welcome"));
//welComeAdminElement.click();
//
//System.out.println(" Clicked on WelCome Addmin link ");
//
//// Thread.sleep(10000);
//
//}
//
//@Test(priority=3)
//public void logOutTest() throws InterruptedException
//{
//
//WebElement logOut=driver.findElement(By.linkText("Logout"));
//logOut.click();
//
//System.out.println(" Successfully LogOut from the Application ");
//
//}
//
//@AfterTest
//public void OrangeHRMApplicationClose()
//{
//driver.close();
//
//System.out.println(" OrangeHRM Application Closed Successfully ");
//
//}

}


