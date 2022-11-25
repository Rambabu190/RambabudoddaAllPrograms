package com.WebtableXpath;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String	applicationUrl="https://www.timeanddate.com/worldclock";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./Folder1/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get(applicationUrl);
		driver.manage().window().maximize();
		
		//Find entire table webElelement
		// /html/body/div[5]/section[1]/div
		
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]/a
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[2]/td[1]/a
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[3]/a
	WebElement	webTable=driver.findElement(By.xpath("/html/body/div[5]/section[1]/div"));
		List<WebElement>tableRows=webTable.findElements(By.tagName("tr"));
		
		for(int i=0;i<tableRows.size();i++)
		{
			List<WebElement>tableRowOfcells=tableRows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<tableRowOfcells.size();j++)
			{
			String	tableData=tableRowOfcells.get(j).getText();	
			System.out.print(tableData+"        ");
			
			}
			System.out.println();
		}
		
	//

	}

}
