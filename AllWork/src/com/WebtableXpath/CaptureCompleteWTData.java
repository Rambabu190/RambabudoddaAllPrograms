package com.WebtableXpath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureCompleteWTData {
	
	//Static WebTable Data from world clock time page to console

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String	applicationUrl="https://www.timeanddate.com/worldclock";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./Folder1/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get(applicationUrl);
		driver.manage().window().maximize();
		
		FileInputStream file=new FileInputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\allWebTableData1.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");	
		
		
		////html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]/a
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]
		String part1="html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
		
		String part2="]/td[";
		
		String part3="]";
		
		for(int i=1;i<=36;i++)
		{
			//Row	row=sheet.createRow(i);
//			
			for(int j=1;j<=8;j++)
			{
				
				WebElement	webtableElement=driver.findElement(By.xpath(part1+i+part2+j+part3));
			String	data=webtableElement.getText();
			
			String	cityName=webtableElement.getText();	
			
		
			//Cell	cell=sheet.createCell(j);
			//Row	row1=sheet.getRow(i);
			//Cell cell=row.createCell(j);
		//	cell.setCellValue(cityName);
			
			//FileOutputStream file1=new FileOutputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\allWebTableData1.xlsx");			
			//workbook.write(file1);
			//workbook.close();
			
			
			System.out.print(cityName+"    ");			
			}//inner for loop close
			
			FileOutputStream file1=new FileOutputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\allWebTableData1.xlsx");			
			workbook.write(file1);
			System.out.println();
		}
		//FileOutputStream file1=new FileOutputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\allWebTableData.xlsx");			
		//workbook.write(file1);
	
	
	
	}

}
