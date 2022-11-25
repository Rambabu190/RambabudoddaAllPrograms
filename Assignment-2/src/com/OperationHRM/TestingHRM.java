package com.OperationHRM;

import java.awt.event.ActionEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestingHRM {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	String	application_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard\"";
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver","Fold2/chromedriver.exe");
	driver=new ChromeDriver();
	
	//1. NAVIGATE TO THE ORANGE HRM 
	
	driver.get(application_URL);
	
	//TITLE VALIDATION
	
	String expected_Title="OrangeHRM";
	System.out.println("The expected title of Ohrm is :"+expected_Title);
	String actual_Title=driver.getTitle();
	System.out.println("The actual Title of Ohrm is :"+actual_Title);
	
	if(actual_Title.equals(expected_Title))
	{
		System.out.println("The OHRM page Page Title is Matched - PASS");
	}
	else
	{
		System.out.println("The OHRM Page Title is Not Matched - FAIL");
	}
	
	//URL VALIDATION
	
	String expected_Url="orangehrm-4.2.0.1";
	System.out.println("The expected Url is: "+expected_Url);
	String actual_Url=driver.getCurrentUrl();
	System.out.println("The acutal Url of Ohrm is  "+actual_Url);
	
	if(actual_Url.contains(expected_Url))
	{
		System.out.println("The Url Address is Matched :- PASS");
	}
	else
	{
		System.out.println("The Url Address is Not Matched :- FAIL");
	}
	
	//LOGIN PANEL TEXT GETTING
	//VALIDATION MISSISNG--------------------
///<div id="logInPanelHeading">LOGIN Panel</div>
	
WebElement	Loginpanel=driver.findElement(By.id("logInPanelHeading"));
String LoginpanelText=Loginpanel.getText();
System.out.println("The login panel text is: "+LoginpanelText);

/* 2 LOGIN ITNO VALID TEST DTA */ 

//<input name="txtUsername" id="txtUsername" type="text">

WebElement username=driver.findElement(By.id("txtUsername"));
username.sendKeys("Rambabu");

//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">

WebElement password=driver.findElement(By.id("txtPassword"));
password.sendKeys("Oran$970");

//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
WebElement submit=driver.findElement(By.id("btnLogin"));
submit.click();

/* 3 LADNDING PAGE VALIDATION */

String landing_page=driver.getTitle();
System.out.println("The landing page title is :"+landing_page);
if(landing_page.equals(actual_Title))
{
	System.out.println("The landing page is HomePage of Orange HRM :- PASS");
}
else
{
	System.out.println("The landing page is not HomePage of Orange HRM :- FAIL");
}

String expectedText1="Admin";

//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/admin/viewAdminModule" id="menu_admin_viewAdminModule" class="firstLevelMenu"><b>Admin</b></a>

WebElement actualText2=driver.findElement(By.linkText("Admin"));
String actualText1=actualText2.getText();
if(actualText1.equals(expectedText1))
{
	System.out.println("The Actual Text Of Admin is Matched :- PASS");
}
else
{
	System.out.println("The Actual Text Of Admin is Not Matched :- FAIL");
}
Thread.sleep(3000);


/* 4 NAVIGATE TO PIM*/

//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPimModule" id="menu_pim_viewPimModule" class="firstLevelMenu"><b>PIM</b></a>

WebElement identifyPIM=driver.findElement(By.id("menu_pim_viewPimModule"));

Actions action1=new Actions(driver);

action1.moveToElement(identifyPIM).build().perform();

/* 5 NAVIGATE TO ADD EMPLOYEE */
//NOT REQUIRE AGAIN ACTION CLASS OBJECT CREATION
// BECOUSE ADD EMPLOYEE IS VISIBIL WHEN COMPLETED ABOVE MOUSEHOVER ACTION THEN CLICK ON THE ADD EMPLOYEE

//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
WebElement add_Employee=driver.findElement(By.linkText("Add Employee"));

Actions action2=new Actions(driver);

action2.moveToElement(add_Employee).build().perform();

add_Employee.click();		//CLICK OPERATION ON ELEMENT

/* 6 LANDING PAGE SHOULD BE ADD EMPLOYEE PAGE*/
//LANDING PAGE NAME VALIDATION WITH GETTING ANY TEXT DATA FROM ANY ELEMENT TEXT-----------

//Current page name is Validating With "CurrentURL"//

//String addEmployeeTitle=driver.getTitle();
//System.out.println("The add employee Title is"+addEmployeeTitle);
String expected_Title1="addEmploye";
 String employe_PageUrl=driver.getCurrentUrl();
 if(employe_PageUrl.contains(expected_Title1))
 {
	 System.out.println("6 landing page is Add Employee :- PASS");
 }
 else
 {
	 System.out.println("6 landing page is Add Employee :- FAIL");
 }

 /* Title validation of add Employee Page*/
 //expected title variable is used from above initialization
//System.out.println(driver.getTitle());
 String actual_Title1=driver.getTitle();
 if(actual_Title1.equals(expected_Title))
	{
	 System.out.println("6 The Title of Add Employee page is :- PASS");
	}
 else
 {
	 System.out.println("6 The Title of Add Employee page is :- FAIL");
 }
 
 
Thread.sleep(3000);


//<input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">

WebElement firstNameField=driver.findElement(By.id("firstName"));
firstNameField.sendKeys("Ram");

//<input class="formInputText" maxlength="30" type="text" name="middleName" id="middleName">
WebElement middle_field=driver.findElement(By.id("middleName"));
middle_field.sendKeys("Babu");

//<input class="formInputText" maxlength="30" type="text" name="lastName" id="lastName">
WebElement last_Name=driver.findElement(By.id("lastName"));
last_Name.sendKeys("Dodda");

//Getting employee ID
//<input class="formInputText valid" maxlength="10" type="text" name="employeeId" value="0001" id="employeeId">
WebElement employ_Id=driver.findElement(By.id("employeeId"));
String employ_CurrentId=employ_Id.getAttribute("value");
System.out.println("The employee Id is:- "+employ_CurrentId);

// ID VERIFICATION FROM RUNTIME THAT MEANS GETATTRIBUTE ATTRIBUTE  VALUE FROM THAT PERTICULAR PAGE
//EXPECTED ID FROM EXISTING PAGE AND ACTUAL ID FROM NEXT PAGE

//<input type="button" class="" id="btnSave" value="Save">
WebElement employee_Submit=driver.findElement(By.id("btnSave"));
employee_Submit.click();

Thread.sleep(3000);

/* 7  LANDING PAGE VALIDATION OF PERSONAL DETAILS PAGE    */
//CURRENT PAGE NAME VALIDATING WITH CURRENT URL

String personal_DetailsPage="PersonalDetails";
//System.out.println("The personal Details page name is :"+personal_DetailsPage);

String personal_Details_Url=driver.getCurrentUrl();
//System.out.println(personal_Details_Url);
if(personal_Details_Url.contains(personal_DetailsPage))
{
	System.out.println("7Landind Page is Matched :- PASS");
}
else
{
	System.out.println("7Landing Page is Not Matched :- FAIL");
}
Thread.sleep(3000);

//VALIDATION OF FIRSTNAME AND MIDDLENAME AND LASTNAME

//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPersonalDetails/empNumber/0005">Personal Details</a>

WebElement personal_Details=driver.findElement(By.linkText("Personal Details"));
String landing_PageName=personal_Details.getText();
System.out.println("The landing Page is :"+landing_PageName);


//<input value="Ram" type="text" name="personal[txtEmpFirstName]" class="block default editable" maxlength="30" title="First Name" id="personal_txtEmpFirstName" disabled="disabled">

WebElement firstNameValue=driver.findElement(By.id("personal_txtEmpFirstName"));
String expected_FirstName = "Ram";
System.out.println("The expected First namse is: "+expected_FirstName);
String actual_FirstName=firstNameValue.getAttribute("value");
System.out.println("The Actual First namse is: "+actual_FirstName);
if(actual_FirstName.equals(expected_FirstName))
{
	System.out.println("The First namse is Matched :- PASS");
}
else
{
	System.out.println("The First namse is Not Matched :- FAIL");
}

//<input value="Babu" type="text" name="personal[txtEmpMiddleName]" class="block default editable" maxlength="30" title="Middle Name" id="personal_txtEmpMiddleName" disabled="disabled">
String expected_MiddleName="Babu";
WebElement second=driver.findElement(By.id("personal_txtEmpMiddleName"));
String actual_middle_Name=second.getAttribute("value");
System.out.println("The actual middle name is :"+actual_middle_Name);
if(actual_middle_Name.equals(expected_MiddleName))
{
	System.out.println("The Middle Name is Matched :- PASS");
	
	
}
else
{
	System.out.println("The Middle Name is Not Matched :- FAIL");
	
}

//<input value="Dodda" type="text" name="personal[txtEmpLastName]" class="block default editable" maxlength="30" title="Last Name" id="personal_txtEmpLastName" disabled="disabled">
String expectedLastName="Dodda";
System.out.println("expected Last Namse is :"+expectedLastName);
WebElement lastName=driver.findElement(By.id("personal_txtEmpLastName"));
String actual_LastName=lastName.getAttribute("value");
System.out.println("The actual last name is :"+actual_LastName);
if(actual_LastName.equals(expectedLastName))
{
System.out.println("The Last Name is Matched :- PASS");	
	
}
else
{
	System.out.println("The Last Name Not Matched :- FAIL");
	
}
Thread.sleep(3000);

/*8 AUTOMATE WELCOME ADMIN */

//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>

WebElement welcom_Admin=driver.findElement(By.linkText("Welcome Admin"));
welcom_Admin.click();

Thread.sleep(3000);

/* 9 LOGOUT */

//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
WebElement logout=driver.findElement(By.linkText("Logout"));
logout.click();

//<a href="#" data-dismiss="modal" id="aboutDisplayLink">About</a>
//WebElement about1=driver.findElement(By.linkText("About"));
//about1.click();

//Thread.sleep(3000);

/* 10 CLOSE THE APPLICATIONS */

driver.quit(); 
	}

}
