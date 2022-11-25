package com.WebtableXpath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Child extends CaptureAllDataInheritance
{
	public void capturingAlldata() throws IOException
	{
FileInputStream file=new FileInputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\allWebTableData1.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		///html/body/div[5]/section[1]/div/section/div[1]
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
		
		
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[7]
	WebElement	entireTableElement=driver.findElement(By.xpath("html/body/div[5]/section[1]/div/section/div[1]"));
		
				List<WebElement>tableRows=entireTableElement.findElements(By.tagName("tr"));
			int	rowsLength=tableRows.size();
		for(int i=0;i<rowsLength;i++)
		{
			
		Row	row=sheet.createRow(i);
			
			//String	data=tableRows.get(i).getText();
		List<WebElement>tableRowOfCell=tableRows.get(i).findElements(By.tagName("td"));
		int	tableRowOfCellLength=tableRowOfCell.size();
		for(int j=0;j<tableRowOfCellLength;j++)
		{
		String	data=tableRowOfCell.get(j).getText();
		System.out.print(data+"     ");
		
	Cell	cell=row.createCell(j);
	cell.setCellValue(data);
	
	FileOutputStream fos=new FileOutputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\allWebTableData1.xlsx");
		workbook.write(fos);
		}
		System.out.println();
			
		}
			
	}

	public static void main(String args[]) throws IOException
	{
		Child object1=new Child();
		object1.applicationLaunch();
		object1.capturingAlldata();
		
	}
	
	
}
