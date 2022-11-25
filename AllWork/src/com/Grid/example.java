package com.Grid;

import org.testng.annotations.Test;

public class example {
	 int a=10;
	@Test(priority=1)
	public void man()
	{
	int	b=3;
	int c=2;
		if(c<b)
		{
			a=40;
		}
		System.out.println(a);
	int	a=3;
	System.out.println(a);
		
	}
	@Test(priority=2)
	public void woman()
	{
		System.out.println(a);
		a=60;
		System.out.println(a);
		
	}
	
	

}
