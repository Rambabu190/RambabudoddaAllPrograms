package com.Patterns;

public class ExampleAdd5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=3;i++)
		{
			for(int j=i;j<=3;j++)
			{
				System.out.print(" ");
				
			}
			for(int j=1;j<i;j++)
			{
				System.out.print("*");
			}
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			
			
		System.out.println();
		}
		

	}

}
