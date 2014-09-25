package net.austinj.pcalculator;

import java.util.Scanner;

public class MainClass 
{
	
	public static String inputMode = "";
	public static boolean debugging = false;
	
	private static String[] input = {"",""}; 
    private static java.util.List<String> tempList; 
    private static String[] baton = {"",""}; 
    private static String command;
	
    private static Scanner console = new Scanner(System.in);
    
	public static void main(String args[])
	{
		try
		{
			if(!args[0].isEmpty())
			{
				inputMode = "CLI";
			}
			
			if(checkForArgument(args,"--debug"))
			{
				debugging = true;
			}
		}
		catch(Exception e)
		{
			inputMode = "GUI";
		}
		
		
		
		
	}
	
	public static boolean checkForArgument(String[] args, String arg)
	{
		for(int i = 0; i < args.length; i++)
		{
			if(args[i].contains(arg))
			{
				return true;
			}
		}
		return false;
	}

}
