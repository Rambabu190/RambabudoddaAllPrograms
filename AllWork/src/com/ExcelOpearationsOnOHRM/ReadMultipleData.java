package com.ExcelOpearationsOnOHRM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadMultipleData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file=new FileInputStream("C:\\Users\\Rambabu\\OneDrive\\Desktop\\latest\\AllWork\\ExcelFiles\\OhrmLogInWithMultipleData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		
	int	rowCount=sheet.getLastRowNum();
	for(int i=0;i<rowCount;i++)
	{
		int	cellCount=sheet.getRow(i).getLastCellNum();
		
		for(int j=0;j<cellCount;j++)
		{
			Row	row=sheet.getRow(i);
			Cell	cell=row.getCell(j);
				String	data=cell.getStringCellValue();
				System.out.print(data+"             ");
		}
		
		System.out.println();
	}

	}

}
