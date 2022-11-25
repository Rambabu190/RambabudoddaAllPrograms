//EXCEL READ AND WRITE OPERATIONS
package com.ExcelOpearationsOnOHRM;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ExcelOnOHRM {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String	application_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard\"";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","Folder1/chromedriver.exe");
		driver=new ChromeDriver();
		
		//1. NAVIGATE TO THE ORANGE HRM 
		
		driver.get(application_URL);
		
		FileInputStream file=new FileInputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\OrangeHRMTestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
	/*	Row	row1=sheet.getRow(1);
		Cell	cell0=row1.getCell(0);
	String	userNameCellValue=cell0.getStringCellValue();
	
	Cell	cell1=row1.getCell(1);
String	passwordCellValue=cell1.getStringCellValue();		*/
	
		Row	row1=sheet.getRow(2);
		Cell	cell0=row1.getCell(1);
	String	userNameCellValue=cell0.getStringCellValue();
	
	Cell	cell1=row1.getCell(1);
String	passwordCellValue=cell1.getStringCellValue();
	
	
	
	/* 2 LOGIN ITNO VALID TEST DTA */ 

	//<input name="txtUsername" id="txtUsername" type="text">

	WebElement username=driver.findElement(By.id("txtUsername"));
	username.sendKeys(userNameCellValue);

	//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">

	WebElement password=driver.findElement(By.id("txtPassword"));
	password.sendKeys(passwordCellValue);

	//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	WebElement submit=driver.findElement(By.id("btnLogin"));
	
	submit.click();
	File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshot,new File("ScreenShots","img"+".png"));
	//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
	
	String expectedAdminText="Welcome Admin";
	
	//<span id="spanMessage">Invalid credentials</span>
						
	
	
	WebElement	welcomeAdmin=driver.findElement(By.id("welcome"));
			String	actualAdminText=welcomeAdmin.getText();
			if(actualAdminText.equals(expectedAdminText))
			{
				/*Row	rowvar=sheet.getRow(1);
				Cell	cellCreation=rowvar.createCell(2);
				cellCreation.setCellValue("loginHomePage-PASS"); */
				
				Row	rowvar=sheet.getRow(2);
				Cell	cellCreation=rowvar.createCell(2);
				cellCreation.setCellValue("loginHomePage-PASS"); 
				
			}
			else
			{
			/*	Row	rowvar=sheet.getRow(1);
				Cell	cellCreation=rowvar.createCell(2);
				cellCreation.setCellValue("LoginHomePage-FAIL"); */
				
				Row	rowvar=sheet.getRow(2);
				Cell	cellCreation=rowvar.createCell(2);
				cellCreation.setCellValue("loginHomePage-FAIL"); 
			}
			
			//NAVIGATE TO PIM USING MOUSE HOVER
			WebElement identifyPIM=driver.findElement(By.id("menu_pim_viewPimModule"));

			Actions action1=new Actions(driver);

			action1.moveToElement(identifyPIM).build().perform();
			
			//CLICKIN OPERATION ON ADD EMPLOYEE
			//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
			WebElement add_Employee=driver.findElement(By.linkText("Add Employee"));
			
			add_Employee.click();
			
			//SEND FIRSTNAME MIDDLENAME LASTNAME 
			
			//EXPECTED VALUES TAKING FROM EXCEL SHEET
			
			//EXPECTED FIRST NAME 
			Row	rowvar=sheet.getRow(1);
			Cell	cellCreation=rowvar.getCell(3);
		String	expectedFirstName=cellCreation.getStringCellValue(); 
		
		//<input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">

		WebElement firstNameField=driver.findElement(By.id("firstName"));
		firstNameField.sendKeys(expectedFirstName);
		
			//EXPECTED MIDDLE NAME
		Row	rowvar1=sheet.getRow(1);
		Cell	cellCreation1=rowvar1.getCell(4);
	String	expectedMiddleName=cellCreation1.getStringCellValue(); 
	
	//<input class="formInputText" maxlength="30" type="text" name="middleName" id="middleName">
	WebElement middle_field=driver.findElement(By.id("middleName"));
	middle_field.sendKeys(expectedMiddleName);
	
	//EXPECTED LAST NAME
		Row	rowvar2=sheet.getRow(1);
		Cell	cellCreation2=rowvar2.getCell(5);
		String	expectedLastName=cellCreation2.getStringCellValue(); 
		
		WebElement last_Name=driver.findElement(By.id("lastName"));
		last_Name.sendKeys(expectedLastName);
			
			
			//GETTING EMPLOYEE ID 
			//<input class="formInputText valid" maxlength="10" type="text" name="employeeId" value="0040" id="employeeId">
			WebElement empId=driver.findElement(By.id("employeeId"));
		String	expectedEmployId=empId.getAttribute("value");
		//System.out.println(expectedEmployId);
		
		//EMPLOY VALUE INSERTING INTO EXCEL
				Row	rowvar3=sheet.getRow(1);
				Cell	cellCreation3=rowvar1.createCell(6);
				cellCreation3.setCellValue(expectedEmployId);
		
		//CLICKING THE SAVE BUTTON
				//<input type="button" class="" id="btnSave" value="Save">
				WebElement employee_Submit=driver.findElement(By.id("btnSave"));
				employee_Submit.click();
		
		 
		
		//GETTING ACTUAL DATA FROM ADD EMPLOYEE SUCCUSS PAGE
		
		
WebElement firstNameValue=driver.findElement(By.id("personal_txtEmpFirstName"));
String actual_FirstName=firstNameValue.getAttribute("value");

Row	rowvar4=sheet.getRow(1);
Cell	cellCreation4=rowvar4.createCell(7);
cellCreation4.setCellValue(actual_FirstName); 

WebElement second=driver.findElement(By.id("personal_txtEmpMiddleName"));
String actual_middle_Name=second.getAttribute("value");


Row	rowvar5=sheet.getRow(1);
Cell	cellCreation5=rowvar5.createCell(8);
cellCreation5.setCellValue(actual_middle_Name);


///ELEMENT FINDIND
WebElement lastName=driver.findElement(By.id("personal_txtEmpLastName"));
String actual_LastName=lastName.getAttribute("value");
//CELL CREATION OF ABOVE ELEMENT
Row	rowvar6=sheet.getRow(1);
Cell	cellCreation6=rowvar6.createCell(9);
cellCreation6.setCellValue(actual_LastName); 

 // String 	actualEmployee id from personal details page
//<input value="0044" type="text" name="personal[txtEmployeeId]" maxlength="10" class="editable" id="personal_txtEmployeeId" disabled="disabled">

	WebElement	employeeIdInPersonalDetailsPage=driver.findElement(By.id("personal_txtEmployeeId"));

String	actualemployeeId=employeeIdInPersonalDetailsPage.getAttribute("value");

Row	rowvar7=sheet.getRow(1);
Cell	cellCreation7=rowvar7.createCell(10);
cellCreation7.setCellValue(actualemployeeId);

if(expectedFirstName.equals(actual_FirstName))
{
	if(expectedMiddleName.equals(actual_middle_Name))
	{
		
	
		if(expectedLastName.equals(actual_LastName))
		{
		
		
			if(expectedEmployId.equals(actualemployeeId))
			{
				Row	rowvar8=sheet.getRow(1);
				Cell	cellCreation8=rowvar8.createCell(11);
				cellCreation8.setCellValue("PERSONAL DETAILS ARE MATCHED :- PASS");
			}
			else
			{
				Row	rowvar8=sheet.getRow(1);
				Cell	cellCreation8=rowvar8.createCell(11);
				cellCreation8.setCellValue("PERSONAL DETAILS ARE NOT MATCHED :- FAIL"); 
			}
		}
		
	}
}
	
	
	
	FileOutputStream fos=new FileOutputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\OrangeHRMTestData.xlsx");
			workbook.write(fos);
			workbook.close();
	}

	
}
	
