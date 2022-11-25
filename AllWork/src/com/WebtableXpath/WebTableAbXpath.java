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

public class WebTableAbXpath {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	String	applicationUrl="https://www.timeanddate.com/worldclock";
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver","./Folder1/chromedriver.exe");
	driver=new ChromeDriver();
	
	driver.get(applicationUrl);
	driver.manage().window().maximize();
	
	FileInputStream file=new FileInputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\webTableXpath.xlsx");
	
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	
	XSSFSheet sheet=workbook.getSheet("Sheet1");
	
	//FIRST ROW OF FIRST CELL ELEMENT XPATH
	///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]/a
	
	//LAST ROW OF FIRST CELL ELEMENT XPATH
	///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[1]/a
	
	String xpathPart1="html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[";
	
	String xpathPart2="]/td[1]";
	
	for(int i=1;i<=36;i++)
	{
				WebElement	tableFirstRowWebElement=driver.findElement(By.xpath(xpathPart1+i+xpathPart2));
				
			String	cityName=tableFirstRowWebElement.getText();	
							Row	row=sheet.createRow(i);
							Cell cell=row.createCell(0);
							cell.setCellValue(cityName);
							
							System.out.println(cityName);
							
				FileOutputStream file1=new FileOutputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\webTableXpath.xlsx");			
				workbook.write(file1);
				
	
	}
	
	
	
	
	
	
	}

}
