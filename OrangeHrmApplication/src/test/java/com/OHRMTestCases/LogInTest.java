package com.OHRMTestCases;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.OhrmBasic.BaseTest;

public class LogInTest extends BaseTest
{
	Logger log2=Logger.getLogger(LogInTest.class);
int j;  //i, j are used for Screenshot name creation
int i;
@Test
public void Login() throws IOException, InterruptedException
{
	PropertyConfigurator.configure("OhrmLoginInfo.properties");
	
	file=new FileInputStream("./src/main/java/com/TestDataFiles/readMultipleData.xlsx");
 
  
	 workbook=new XSSFWorkbook(file);
	 sheet=workbook.getSheet("sheet1");
	 //Row row=sheet.getRow(1);
	
	 int	rowSize=sheet.getLastRowNum();
	 System.out.println("the row size is"+rowSize);
	 for(int i=1;i<=rowSize;i++)//when we are use Dynamic excel size then we treat as arrays in for loops Size=n-1
	 {
		Row row=sheet.getRow(i);
		int	rowOfCellSize=row.getLastCellNum();
		System.out.println("Current Row Of Row Of Cells Num"+rowOfCellSize);
		
		Thread.sleep(2000);
		for(int j=0;j<rowOfCellSize;j++)//if we use j<=rowOfCellSize Then Null Pointer Exception Occure
		{
			
			
		Cell	currentCell=row.getCell(j);
			String	cellData=currentCell.getStringCellValue();
			System.out.println(cellData);
			
			switch(j)
			{
			case 0: WebElement username=driver.findElement(By.id(prop.getProperty("userNameKey")));
					username.clear();
					username.sendKeys(cellData);
					Thread.sleep(2000);
					break;
			
			case 1: WebElement password1=driver.findElement(By.id(prop.getProperty("passwordKey")));
					password1.clear();
					password1.sendKeys(cellData);
					Thread.sleep(2000);
					break;	
				
			}
			
		}//INNER FOR LOOP CLOSE
	
			WebElement submit=driver.findElement(By.id(prop.getProperty("logInButtonKey")));
			Thread.sleep(2000);
			
			submit.click();
			Thread.sleep(3000);
		
			try
			{

			WebElement invalid=driver.findElement(By.id(prop.getProperty("spanMessageKey")));
			String	data=invalid.getText();
			System.out.println(data);
			
			Row	rowvar1=sheet.getRow(i);
			Cell	cellCreation1=rowvar1.createCell(3);
			cellCreation1.setCellValue("LoginHomePage-FAIL");
			//Write ScreenShot Program here
			
		File invalidScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(invalidScreenshot,new File("./ScreenshotsOfOhrmInvalidDataLogIn/"+sheet.getRow(i).getCell(0).getStringCellValue()+sheet.getRow(i).getCell(1).getStringCellValue()+".png"));   			
			 
			
			}
			catch(Exception e)
			{
				WebElement	welcomeAdmin=driver.findElement(By.id(prop.getProperty("welComeAdminKey")));
				
				
				String	actualAdminText=welcomeAdmin.getText();
				System.out.println(actualAdminText);
				
				Row	rowvar=sheet.getRow(i);
				Cell	cellCreation=rowvar.createCell(3);
				cellCreation.setCellValue("loginHomePage-PASS");
				
				welcomeAdmin.click();
				
				Thread.sleep(2000);
				
				

				WebElement logOut=driver.findElement(By.linkText(prop.getProperty("LogOutKey")));
				logOut.click();
			}
		
		}//Outer For Loop Closed
		Thread.sleep(2000);
	 FileOutputStream file1=new FileOutputStream("./src/main/java/com/TestDataResultFile/MultipleDataLoginOhrmResultsFile.xlsx");
	 workbook.write(file1);
	 
		
		
	 }
}

		
	


