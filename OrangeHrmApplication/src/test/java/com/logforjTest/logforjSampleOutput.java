package com.logforjTest;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import com.Utility.Log;



public class logforjSampleOutput 
{
	//Logger log=Logger.getLogger(logforjSampleOutput.class);
	@Test(priority=1)
	public void add()
	{
		Log.info("hello World");
		//PropertyConfigurator.configure("Log4jOrange.properties");
	}
	@Test(priority=2)
	public void sub()
	{
		Log.info("Rambabu");
	//	Log.in
	}

}
