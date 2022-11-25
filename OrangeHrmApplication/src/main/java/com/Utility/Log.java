package com.Utility;

import org.apache.log4j.PropertyConfigurator;
import org.testng.log4testng.Logger;

public class Log
{
	public static Logger logg=Logger.getLogger(Log.class);
	
	public static void info(String message)
	{
		PropertyConfigurator.configure("Log4j.properties");
		logg.info(message);
	}

	
}
