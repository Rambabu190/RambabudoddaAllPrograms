package com.ExcelOperations;


import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ReadSingleTestData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String	application_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard\"";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","Folder1/chromedriver.exe");
		driver=new ChromeDriver(); 
		
		//1. NAVIGATE TO THE ORANGE HRM 
		
		
		driver.get(application_URL);
		
	
		
		///WRITE DATA INTO EXCEL FILE IN DYNAMIC
		
	//	FileInputStream file1=new FileInputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\Test1.xlsx");
		
		XSSFWorkbook workbook1=new XSSFWorkbook();
		XSSFSheet sheet=workbook1.createSheet();	
		sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue("UserName");
		sheet.getRow(0).createCell(1).setCellValue("Password");
		sheet.getRow(0).createCell(2).setCellValue("TestResult");
		sheet.getRow(0).createCell(3).setCellValue("ExpectedFirstName");
		sheet.getRow(0).createCell(4).setCellValue("ExpectedMiddleName");
		sheet.getRow(0).createCell(5).setCellValue("ExpectedLastName");
		sheet.getRow(0).createCell(6).setCellValue("ExpectedId");
		sheet.getRow(0).createCell(7).setCellValue("ActualFirstName");
		sheet.getRow(0).createCell(8).setCellValue("ActualMiddleName");
		sheet.getRow(0).createCell(9).setCellValue("ActualLastName");
		sheet.getRow(0).createCell(10).setCellValue("ActualId");
		sheet.getRow(0).createCell(11).setCellValue("Result");
		
		//sheet.getRow(0).createCell(12).setCellValue("Rambabu Result");
		
		
		sheet.createRow(1);
		sheet.getRow(1).createCell(0).setCellValue("Rambabu");
		sheet.getRow(1).createCell(1).setCellValue("Oran$970");
		
		
		File file=new File("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\Test1.xlsx");
		
		FileOutputStream fos=new FileOutputStream(file);
		 workbook1.write(fos);
		// workbook1.close();
		 
		 
	
		 	 
		//OUTPUT OPERATIONS HERE
			
	
	/*	String	application_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard\"";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","Folder1/chromedriver.exe");
		driver=new ChromeDriver();
		
		//1. NAVIGATE TO THE ORANGE HRM 
		
		driver.get(application_URL);
	String	title=driver.getTitle(); */
		
		
	 FileInputStream file1=new FileInputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\Test1.xlsx");
	 
	 XSSFWorkbook workbook2=new XSSFWorkbook(file1);
		XSSFSheet gettingSheet=workbook2.getSheet("Sheet0");
		
		String	title=driver.getTitle();
		
				Row	row1=gettingSheet.getRow(1);
				
					Cell	cell0=row1.getCell(0);
					String	userName=cell0.getStringCellValue();
					
				Cell	cell1=row1.getCell(1);
					String	password=cell1.getStringCellValue();
					  
			/*	Cell	titleCell=row1.createCell(3);
				titleCell.setCellValue(title);
					//System.out.println(userName); */
					
					
					
			
					/* 2 LOGIN ITNO VALID TEST DTA */ 

					//<input name="txtUsername" id="txtUsername" type="text">

					WebElement username=driver.findElement(By.id("txtUsername"));
					username.sendKeys(userName);
					
					WebElement password1=driver.findElement(By.id("txtPassword"));
					password1.sendKeys(password);
		
					
					//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
					WebElement submit=driver.findElement(By.id("btnLogin"));
					submit.click();
					
				
					//Title saving
					
	//	FileOutputStream file3=new FileOutputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\Test1.xlsx");
					 
				//	 XSSFWorkbook workbook3=new XSSFWorkbook(file3);
					 
					String	title1=driver.getTitle();
					sheet.getRow(1).createCell(2).setCellValue(title);
					
					
					
					FileOutputStream fos1=new FileOutputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\Test1.xlsx");
					workbook1.write(fos1);
					workbook1.close();
					 
					
					
		// workbook1.write(fos);
		
		//workbook1.close();
		

		
	}

}
