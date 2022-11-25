package com.ExcelOpearationsOnOHRM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class multipleDataInheritanceOnhrm extends multipleDataOnHRM

{
	public void ohrmLogInWithValidData() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\OrangeHRMTestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		
		Row	row1=sheet.getRow(1);
		Cell	cell0=row1.getCell(0);
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
		
	}
	public void ohrmLogInWithInvalidData() throws IOException, InterruptedException
	{
		
		FileInputStream file=new FileInputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\OrangeHRMTestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		for(int i=1;i<=2;i++)
		{
			Row	row1=sheet.getRow(i);
			for(int j=0;j<1;j++)
			{
				
			Cell	cell0=row1.getCell(j);
			String	userNameCellValue=cell0.getStringCellValue();
				
	
			Cell	cell1=row1.getCell(j+1);
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
		Thread.sleep(3000);
		driver.navigate().back();
		username.clear();
		password.clear();
		
			}
		}
		
		
		
		
	}
	

	
	
	public static void main(String args[]) throws IOException, InterruptedException
	{
		multipleDataInheritanceOnhrm obj=new multipleDataInheritanceOnhrm();
		obj.OhrmApplicationLaunh();
		
		obj.ohrmLogInWithInvalidData();
		//obj.screenShot();
		//obj.ohrmLogInWithValidData();
		
		
		
	}
	
	
	
	

}
