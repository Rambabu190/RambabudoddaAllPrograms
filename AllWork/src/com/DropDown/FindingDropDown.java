package com.DropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FindingDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	String	applicationUrl="https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html?m=1";
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver","./Folder1/chromedriver.exe");
	
	driver=new ChromeDriver();
	
	driver.get(applicationUrl);
	//<select id="course"> <option value="select">Select</option> <option value="java">Java</option> <option value="net">Dot Net</option> <option value="python">Python</option> <option value="js">Javascript</option> </select>

	WebElement	dropDown=driver.findElement(By.id("course"));
 
	Select options=new Select(dropDown); 

/*	//options.selectByIndex(1);
	//Thread.sleep(3000);
	//options.selectByIndex(3);
	//Thread.sleep(3000);
	//options.selectByValue("js");
	//Thread.sleep(300);
	//options.selectByVisibleText("Dot Net");
	//Thread.sleep(3000);
//String	selectedValue=options.deselectByVisibleText("Dot Net"); */
	
	List<WebElement>abc=options.getOptions();
	
int	length=abc.size();

for(int i=0;i<length;i++)
{
	System.out.println(i+" "+abc.get(i).getText());
}


 
	
	
	}

}
