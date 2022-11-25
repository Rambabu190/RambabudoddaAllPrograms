package com.TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample1 {
	
	@BeforeTest		//before not test case thats why not give status as PASS OR FAIL
	
	public void add()
	{
		System.out.println("BeforeTest mehtod successfull");
	}
	@Test(priority=1)
	public void sub()//sub is test case name
	{
		System.out.println("sub method successfull");
	}
	@Test(enabled=false)
	public void multi()
	{
		System.out.println("multi method successfull");
		
	}
	@Test(priority=2)
	public void lastBefore()
	{
		System.out.println("lastBefore successfull");
	}
	
	@Test(priority=3)
	public void lastBeforenEW()
	{
		System.out.println("lastBeforenEW successfull");
	}
	
	@AfterTest				//AfterTest is not Test case thats why not give status as PASS OR FAIL
	public void last()
	{
		System.out.println("After Test method successfull");
		
	}
	
	@Test(priority=4)
	public void Last1()
	{
		System.out.println("Last1 method is passed");
	}
	
	

}
