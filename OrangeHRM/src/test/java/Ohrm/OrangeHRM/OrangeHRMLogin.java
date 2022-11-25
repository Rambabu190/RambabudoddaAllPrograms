package Ohrm.OrangeHRM;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OrangeHRMLogin extends Basic
{

	
@Test
public void Login() throws IOException, InterruptedException
{
	
		file=new FileInputStream("./src/main/java/com/TestDataFiles/readData.xlsx");

	 workbook=new XSSFWorkbook(file);
	 sheet=workbook.getSheet("sheet1");
	 Row row=sheet.getRow(1);
	
		Cell	cell=row.getCell(0);
	String	userName=cell.getStringCellValue();
	
			Cell	cell2=row.getCell(1);
			 		
				String	password=cell2.getStringCellValue();
	 
	 Thread.sleep(3000);
	 
				WebElement username=driver.findElement(By.id("txtUsername"));
				username.sendKeys(userName);
				//username.sendKeys("Rambabu");

				//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">

				Thread.sleep(3000);
				
				WebElement password1=driver.findElement(By.id("txtPassword"));
				password1.sendKeys(password);
				//password1.sendKeys("Oran$970");

				//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
				WebElement submit=driver.findElement(By.id("btnLogin"));
				
				submit.click();
				
				Thread.sleep(3000);
				
				//Validation
				
				String expectedAdminText="Welcome Admin";
				
				
				WebElement	welcomeAdmin=driver.findElement(By.id("welcome"));
				String	actualAdminText=welcomeAdmin.getText();
				if(actualAdminText.equals(expectedAdminText))
				{
					Row	rowvar=sheet.getRow(1);
					Cell	cellCreation=rowvar.createCell(2);
					cellCreation.setCellValue("loginHomePage-PASS"); 
					
					
				}
				else
				{
					Row	rowvar=sheet.getRow(1);
					Cell	cellCreation=rowvar.createCell(2);
					cellCreation.setCellValue("LoginHomePage-FAIL"); 
					
					
	 
				}
	
	FileOutputStream file2=new FileOutputStream("./src/main/java/com/TestdataResultFile/laddu.xlsx");
	workbook.write(file2);
	workbook.close();
	
	
	
		}

}
