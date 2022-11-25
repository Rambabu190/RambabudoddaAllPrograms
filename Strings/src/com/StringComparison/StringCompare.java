package com.StringComparison;

public class StringCompare {
	public static void main (String args[])
	{
		String str = "LiveTech12=+";
		String str2 = "LIvetech1323=+";
		
		//int characterAt=str.charAt(1);
		//System.out.println(characterAt);
		//WebDriver
		
		int count = str.length();
		System.out.println("the str length is: "+count);
		int count1 = str2.length();
		System.out.println("the str1 lenth is : "+count1);
		
		
		if(str2.equalsIgnoreCase(str))
		{
			System.out.println("Both strings are equal");
		}
		else
		{
			System.out.println("Both strings are not equal");
		}
	}

}
