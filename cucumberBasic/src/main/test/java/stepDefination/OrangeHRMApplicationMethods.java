package stepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMApplicationMethods
{
	public WebDriver driver;
	public String applicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard\\\"";
	
	//DOUBT CALLING FROM WHERE.........??????????????????/

	public OrangeHRMApplicationMethods(Hooks hook)
	{
			driver=hook.driver;
	}
	
	
@Given("^User Should Launch the Chrome Browser$")
public void user_Should_Launch_the_Chrome_Browser() throws Throwable 
{
//	System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
//	driver=new ChromeDriver();
	
}

@When("^User Enters OrangeHRM Application URL Address$")
public void user_Enters_OrangeHRM_Application_URL_Address() throws Throwable 
{
	
	driver.get(applicationUrl);
	System.out.println("Orange hrm application launched Successfully");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    
	
String	expected_UrlAddress="http://127.0.0.1/orangehrm-4.2.0.1";
String	actual_UrlAddress=driver.getCurrentUrl(); 
Assert.assertTrue(actual_UrlAddress.contains(expected_UrlAddress));
System.out.println("enters application Url Sucessfully");
Thread.sleep(2000);
}

@Then("^User Should be at the LogIn Page$")
public void user_Should_be_at_the_LogIn_Page() throws Throwable
{
String	currentPageTitle=driver.getTitle();
System.out.println(currentPageTitle);
Thread.sleep(2000);
	}

@Then("^User should Close the Application$")
public void user_should_Close_the_Application() throws Throwable 
{
//	driver.quit();
	System.out.println("Application close Successfully");
	Thread.sleep(2000);
	
  
}

@When("^User enters UserName and Password and click on LogIn button$")
public void user_enters_UserName_and_Password_and_click_on_LogIn_button() throws Throwable
{
	WebElement userName=driver.findElement(By.id("txtUsername"));
	userName.clear();
	userName.sendKeys("Rambabu");

	//System.out.println(" Entered UserName Successfully ");
	//log.info("Entered UserName Successfully");

	WebElement password=driver.findElement(By.name("txtPassword"));
	password.clear();
	password.sendKeys("Oran$970");

	//System.out.println(" Entered Password Successfully ");
	//log.info("Entered Password Successfully");

	WebElement logInButton=driver.findElement(By.className("button"));
	logInButton.click();
	System.out.println("credentioals clicking Successfully");

}

@Then("^User should be navigated to HomePage of OrangeHRM Application$")
public void user_should_be_navigated_to_HomePage_of_OrangeHRM_Application() throws Throwable 
{
	WebElement welComeAdminElement=driver.findElement(By.id("welcome"));

	String	actual_Text=welComeAdminElement.getText();
	String	expected_Text="Welcome Admin";
	Assert.assertTrue(actual_Text.equals(expected_Text));
	System.out.println("User navigate to OrangeHRM home page Successfullu");
	
}
@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and click on LogIn button$")
public void user_enters_and_and_click_on_LogIn_button(String UserName, String Password) throws Throwable
{
	
	System.out.println("enter multiple Credetial data Sucessfully");
	WebElement	userName=driver.findElement(By.id("txtUsername"));
	userName.sendKeys(UserName);
	
	
		     WebElement password=driver.findElement(By.id("txtPassword"));
		     password.sendKeys(Password);
	
		  WebElement submit_Button=driver.findElement(By.id("btnLogin")); 
		  submit_Button.click();
		  
		
	
	
    }

		
	
}
