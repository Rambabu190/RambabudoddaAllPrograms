package com.OHRMTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.OhrmBasic.BaseTest;
import com.Utility.Log;

public class AddEmployee extends BaseTest
{
	Logger logg=Logger.getLogger(AddEmployee.class);
	
	
	//GLOBAL VARIABLES
	public	int j;
	public	int i;
	public int cell;
	public	String expectedFirstName;
	public	String	expectedMiddleName;
	public	String	expectedLastName;
	//	WebElement	add_Employee;
		
	@Test(priority=1)
	public void logIn() throws InterruptedException
	{
		PropertyConfigurator.configure("AddEmployeeInfo.properties");
		
		//PropertyConfigurator.configure();
		WebElement username=driver.findElement(By.id(prop.getProperty("userNameKey")));
		//username.sendKeys(prop.getProperty("validUserNameKey"));
		username.sendKeys("Rambabu");
		
		WebElement password1=driver.findElement(By.id(prop.getProperty("passwordKey")));
		password1.clear();
//		password1.sendKeys(prop.getProperty("validPasswordKey"));//key values are not working in sendKeys
		password1.sendKeys("Oran$970");
		
		WebElement submit=driver.findElement(By.id(prop.getProperty("logInButtonKey")));
		Thread.sleep(2000);
		
		submit.click();
		logg.info("Loging Home Page Successfully");
//		WebElement	welcomeAdmin=driver.findElement(By.id(prop.getProperty("welComeAdminKey")));
//		
//		Thread.sleep(2000);
//		welcomeAdmin.click();
	}
	@Test(priority=2)
	public void addEmployee() throws InterruptedException
	{
		//NAVIGATE TO PIM USING MOUSE HOVER
		WebElement identifyPIM=driver.findElement(By.id(prop.getProperty("menu_pim_viewPimModuleKey")));

		Actions action1=new Actions(driver);

		action1.moveToElement(identifyPIM).build().perform();
		
		//CLICKIN OPERATION ON ADD EMPLOYEE
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
		WebElement add_Employee=driver.findElement(By.linkText(prop.getProperty("AddEmployeeKey")));
		
		Thread.sleep(2000);
		add_Employee.click();
		logg.info("entering AddEmployee Page Successfully");
		
	}
	@Test(priority=3)
	public void sendEmployeeDetails() throws IOException, InterruptedException
	{
		file=new FileInputStream("./src/main/java/com/TestDataFiles/addEmployeeInputData.xlsx");
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet("Sheet1");
		
		int	rowSizeOfSheet=sheet.getLastRowNum();
		for(int row=1;row<=rowSizeOfSheet;row++)
		{
		Row	currentRow=sheet.getRow(row);
		//	int	currentRowOfCellSize=currentRow.getLastCellNum();
					for(int cell=0;cell<=2;cell++)
					{
					//	Thread.sleep(2000);
						Cell	currentCell=currentRow.getCell(cell);
						String	currentCellData=currentCell.getStringCellValue();
				
				
						switch(cell)
						{
						case 0://<input class="formInputText valid" maxlength="30" type="text" name="firstName" id="firstName">
							
								WebElement firstNameField=driver.findElement(By.id(prop.getProperty("firstNameKey")));
								firstNameField.sendKeys(currentCellData);
								expectedFirstName=currentCellData;
								Thread.sleep(2000);
								break;
								
						case 1:	WebElement middle_field=driver.findElement(By.id(prop.getProperty("middleNameKey")));
								middle_field.sendKeys(currentCellData);
								expectedMiddleName=currentCellData;
								Thread.sleep(2000);
								break;
								
						case 2://<input class="formInputText" maxlength="30" type="text" name="lastName" id="lastName">
							
								WebElement last_Name=driver.findElement(By.id(prop.getProperty("lastNameKey")));
								last_Name.sendKeys(currentCellData);
								expectedLastName=currentCellData;
								Thread.sleep(2000);
								break;
					
						}//Switch case close
					
						
					}//inner loop close
					
						WebElement empId=driver.findElement(By.id(prop.getProperty("employeeIdKey")));
						String	expectedEmployId=empId.getAttribute("value");
						currentRow.createCell(3).setCellValue(expectedEmployId);
						System.out.println("employee id is"+expectedEmployId);
						logg.info(row+"  -getting Employee Id in Runtime successfully");
						
				
						
						//CLICKING THE SAVE BUTTON
						//<input type="button" class="" id="btnSave" value="Save">
						WebElement employee_Submit=driver.findElement(By.id(prop.getProperty("employDetailsSaveButton")));
						employee_Submit.click();
						
						//when click on save button driver navigates to personal details page
						
						 
						
						//GETTING ACTUAL DATA FROM ADD EMPLOYEE SUCCUSS PAGE
						
						
						WebElement firstNameValue=driver.findElement(By.id("personal_txtEmpFirstName"));
						String actual_FirstName=firstNameValue.getAttribute("value");
						currentRow.createCell(4).setCellValue(actual_FirstName);
					//	logg.info("getting actual firstName successfully");

						WebElement second=driver.findElement(By.id("personal_txtEmpMiddleName"));
						String actual_middle_Name=second.getAttribute("value");
							currentRow.createCell(5).setCellValue(actual_middle_Name);
							//logg.info("getting actual middle successfully");
						
						WebElement lastName=driver.findElement(By.id("personal_txtEmpLastName"));
						String actual_LastName=lastName.getAttribute("value");
						currentRow.createCell(6).setCellValue(actual_LastName);
						//logg.info("getting actual lastName successfully");
						
						
						WebElement	employeeIdInPersonalDetailsPage=driver.findElement(By.id("personal_txtEmployeeId"));
						String	actualemployeeId=employeeIdInPersonalDetailsPage.getAttribute("value");
						currentRow.createCell(7).setCellValue(actualemployeeId);
						//logg.info("getting actual EmployeeId successfully");

							
				// WE WANT TO VALIDATE (ADD-EMPLOYEE-PAGE DETAILS) WITH (PERSONAL-DETAILS PAGE DATA)

						if(expectedFirstName.equals(actual_FirstName))
						{
							logg.info("expectedFirstName and ActualFirstName-Matched");
							if(expectedMiddleName.equals(actual_middle_Name))
							{
								logg.info("expectedMiddleName and ActualMiddleName-Matched");
	
								if(expectedLastName.equals(actual_LastName))
								{
									logg.info("expectedLastName and ActualLasrName-Matched");
		
									if(expectedEmployId.equals(actualemployeeId))
									{
										Cell	cellCreation=currentRow.createCell(8);
												cellCreation.setCellValue(row+" -Row PERSONAL DETAILS ARE MATCHED :- PASS");
									
											logg.info("Personal Details Validation Results- Matched-in"+row+"Row And send to excel Sheet Successfull");
									}
									else
									{
										
										Cell	cellCreation=currentRow.createCell(8);
										cellCreation.setCellValue(row+" -Row PERSONAL DETAILS ARE NOT MATCHED :- FAIL"); 
										
										logg.info("Personal Details Validation Results-Not Matched-in"+row+"Row And send to excel Sheet Successfull");
									
									}
								}
		
							}
						}
						
							
						//Inner for loop close

						WebElement add_Employee=driver.findElement(By.linkText("Add Employee"));
						add_Employee.click();
						logg.info(row+ "  -Row details entered successfull");
						Thread.sleep(2000);
					//	add_Employee.click();
						
			
			
			
		}//Outer for loop
		
		
		
		file1=new FileOutputStream("./src/main/java/com/TestDataResultFile/addEmployeeInputWithResultsData2.xlsx");
		workbook.write(file1);
		
		
	}
	

}
