package net.austinj.pcalculator.tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.austinj.pcalculator.MainClass;

public class Interface 
{
	
	public static void logError(Exception e)
	{
		if(MainClass.debugging)
		{
			e.printStackTrace();
		}
		else
		{
			try 
			{
				FileWriter errorlog = new FileWriter(new File("pcalculator-errors.txt"));
				errorlog.append("Hello");
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
	
	public static void prompt()
	{
		//
	}
	
	public static void alert()
	{
		//
	}

}
