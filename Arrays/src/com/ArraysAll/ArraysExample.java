package com.ArraysAll;

public class ArraysExample {
	public static void main(String args[])
	{
		/* int array1[]=new int[5];
		
		 array1[0]=10;
		 array1[2]=30;
		 array1[3]=40;
		array1[4]=50;
		 for(int i=0;i<array1.length;i++)
		 {
			 System.out.println("the array value is :"+array1[i]);
		 }  */
		
		 String twoD[][]=new String[2][3];
		 
		// twoD[0][0]="Hello";
		 //twoD[0][1]="Rams";	
		// twoD[0][2]="Good";
		 twoD[1][0]="java";
		 twoD[1][1]="Selenium";
		 twoD[0][0]="Hello";
		 
		 twoD[0][2]="babu";
		 System.out.println(twoD.length);
		 
	for(int i=0;i<2;i++)
		 {
			 for(int j=0;j<3;j++)
			 {
				 System.out.print(twoD[i][j]+"       ");
			 }
			 System.out.println();
		 } 
		 
		 
	}

}
