package Orange.ReadMultipleData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ReadMultipleDataFromExcel extends ReadMultipleData
{
	
	
@Test
public void Login() throws IOException, InterruptedException
{
	
		file=new FileInputStream("./src/main/java/com/MultipleData/readMultipleData.xlsx");
 
  
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
			case 0: WebElement username=driver.findElement(By.id("txtUsername"));
					username.clear();
					username.sendKeys(cellData);
					Thread.sleep(2000);
					break;
			
			case 1: WebElement password1=driver.findElement(By.id("txtPassword"));
					password1.clear();
					password1.sendKeys(cellData);
					Thread.sleep(2000);
					break;	
				
			}
			
		}//INNER FOR LOOP CLOSE
		
		
		
			WebElement submit=driver.findElement(By.id("btnLogin"));
			Thread.sleep(2000);
			
			submit.click();
			Thread.sleep(3000);
			
			
			try
			{
				
			
			
			WebElement invalid=driver.findElement(By.id("spanMessage"));
			String	data=invalid.getText();
			System.out.println(data);
			
			Row	rowvar1=sheet.getRow(i);
			Cell	cellCreation1=rowvar1.createCell(2);
			cellCreation1.setCellValue("LoginHomePage-FAIL"); 
			
			}
			catch(Exception e)
			{
				WebElement	welcomeAdmin=driver.findElement(By.id("welcome"));
			//	String	actualAdminText=welcomeAdmin.getText();
				
				Row	rowvar=sheet.getRow(i);
				Cell	cellCreation=rowvar.createCell(2);
				cellCreation.setCellValue("loginHomePage-PASS"); 
			}
			
						
			
//FileOutputStream file1=new FileOutputStream("./src/main/java/com/MultipleData/readMultipleData1.xlsx");
//workbook.write(file1);
			

		}//Outer For Loop Closed
		
	 FileOutputStream file1=new FileOutputStream("./src/main/java/com/MultipleData/readMultipleData2.xlsx");
	workbook.write(file1);
		
		
	 }
}

		
	 
	 

