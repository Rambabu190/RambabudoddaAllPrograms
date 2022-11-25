package com.OHRMTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.OhrmBasic.BaseTest;

public class ExtractingEmployeeDetails extends BaseTest 
{
	
	Logger logg1=Logger.getLogger(ExtractingEmployeeDetails.class);
	
	@Test(priority=1)
	public void login() throws InterruptedException
	{
		
	PropertyConfigurator.configure("ExtractingEmployeeDataInfo.properties");
	WebElement username=driver.findElement(By.id(prop.getProperty("userNameKey")));
	//username.sendKeys(prop.getProperty("validUserNameKey"));
	username.sendKeys("Rambabu");
	
	WebElement password1=driver.findElement(By.id(prop.getProperty("passwordKey")));
	password1.clear();
//	password1.sendKeys(prop.getProperty("validPasswordKey"));
	password1.sendKeys("Oran$970");
	
	WebElement submit=driver.findElement(By.id(prop.getProperty("logInButtonKey")));
	Thread.sleep(2000);
	
	submit.click();
	
	}
	@Test(priority=2)
	public void findingdata() throws InterruptedException, IOException
	{
		
		//NAVIGATE TO PIM USING MOUSE HOVER
				WebElement identifyPIM=driver.findElement(By.id("menu_pim_viewPimModule"));

				Actions action1=new Actions(driver);

				action1.moveToElement(identifyPIM).build().perform();
				
		
				//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewEmployeeList/reset/1" id="menu_pim_viewEmployeeList">Employee List</a>
			WebElement	employeeList=driver.findElement(By.linkText("Employee List"));
			
			employeeList.click();
				Thread.sleep(3000);
				
				
				file=new FileInputStream("./src/main/java/com/importEmployeeData/EmployeeDetailsEmpty.xlsx");
				workbook=new XSSFWorkbook(file);
				sheet=workbook.getSheet("Sheet1");
				
				///html/body/div[1]/div[3]/div[2]/div
				////*[@id="frmList_ohrmListComponent"]
				
			WebElement	employeeDataTable=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div"));
			
			///html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[2]/a
			
			///html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[50]/td[4]/a
			
			List<WebElement>tableRows=employeeDataTable.findElements(By.tagName("tr"));
			System.out.println(tableRows.size());
				
			for(int row=0;row<tableRows.size();row++)
			{
				
			Row	rowCreate=sheet.createRow(row);
			
			List<WebElement>tableColumn=tableRows.get(row).findElements(By.tagName("td"));
				for(int cell=0;cell<tableColumn.size();cell++)
				{
				String	data=tableColumn.get(cell).getText();
				System.out.print(data+"         ");
				rowCreate.createCell(cell).setCellValue(data);
					
					
				}
			
			//System.out.println(tableColumn.size());
			
			System.out.println();
			
			}
			
			
			file1=new FileOutputStream("./src/main/java/com/importEmployeeData/employeeDetails.xlsx");
			workbook.write(file1);
	}
	
	
	
	
	
	
	
	
	
	
	
}
