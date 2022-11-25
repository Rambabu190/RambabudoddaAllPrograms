package com.TestNG;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RadioButtonInheritance extends Basic
{
	@Test(priority=1)
	public void radioButtonTesting() throws InterruptedException
	{
		//finding Radio Button blick
		///html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td
	WebElement	radioButtonsBlock=driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));
	
	//RadioButton Outer HTML
	//<input type="radio" name="group1" value="Milk">
	//<input type="radio" name="group1" value="Butter" checked="">
	//<input type="radio" name="group1" value="Cheese">
	
	//<input type="radio" name="group2" value="Water">
	
	//ARRAY CREATION FOR GROUP1 WEBELEMENTS
	
					List<WebElement>radioButtons=radioButtonsBlock.findElements(By.name("group1"));
				int	radioLength=radioButtons.size();
				
	//ARRAY  CREATION FOR GROUP2 WEBELEMENTS
				
						List<WebElement>radioButtonsGroup2=radioButtonsBlock.findElements(By.name("group2"));
							
					//	int	group2Length=radioButtonsGroup2.size();
				
				
				System.out.println("the radio buttons length is :"+radioLength);
				for(int i=0;i<radioLength;i++)
				{
					radioButtons.get(i).click();//Radio Button checked
					
					radioButtonsGroup2.get(i).click();
					Thread.sleep(2000);
					
					for(int j=0;j<radioLength;j++)
					{
						System.out.println(radioButtons.get(j).getAttribute("value")+" "+radioButtons.get(j).getAttribute("checked")+"  ");
					
						System.out.println(radioButtonsGroup2.get(j).getAttribute("value")+" "+radioButtons.get(j).getAttribute("checked")+"  ");
					
					}
					System.out.println(" ");
				}
	
	
	///html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td/input[1]
	
	
	
	}
	

}
