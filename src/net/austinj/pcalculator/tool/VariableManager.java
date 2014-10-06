package net.austinj.pcalculator.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class VariableManager 
{
	
	private static String variableFileName = "pcalculator-variables.properties";
	
	public static List<Variable> constants = new ArrayList<Variable>();
	public static List<Variable> variables = new ArrayList<Variable>();

	
	public static void set(Variable v) throws Exception //Replaces variables with the name
	{
		if(!checkForVariableById(v.getId())) //If a previous variable isn't found
		{
			variables.add(v);
		}
		else
		{
			remove(v.getId());
			variables.add(v);
		}
	}
	public static void add(Variable v) throws Exception //Attempts to add variable with a name
	{
		if(!checkForVariableById(v.getId())) //If a previous variable isn't found
		{
			variables.add(v);
		}
		else
		{
			throw new Exception("A variable was already found with that ID.");
		}
	}
	
	public static void remove(String id) throws Exception
	{
		int index = -1;
		
		for(int i = 0; i < variables.size(); i++)
		{
			if(variables.get(i).getId().equals(id))
			{
				index = i;
			}
		}
		
		if(index == -1)
		{
			throw new Exception("A variable could not be found with the given ID: "+id);
		}
		
		variables.remove(index);
		
	}
	
	public static String getValueById(String id) throws Exception
	{
		for(int i = 0; i < variables.size(); i++)
		{
			if(variables.get(i).getId().equals(id))
			{
				return variables.get(i).getValue();
			}
		}
		throw new Exception("A variable could not be found with the given ID: "+id);
	}
	
	public static int getVariableIndexById(String id) throws Exception
	{
		for(int i = 0; i < variables.size(); i++)
		{
			if(variables.get(i).getId().equals(id))
			{
				return i;
			}
		}
		throw new Exception("A variable could not be found with the given ID: "+id);
	}
	
	public static boolean checkForVariableById(String id)
	{
		for(int i = 0; i < variables.size(); i++)
		{
			if(variables.get(i).getId().equals(id))
			{
				return true;
			}
		}
		return false;
	}
	
	public static void writeVariablesToFile()
	{
		writeVariablesToFile(variableFileName);
	}
	
	public static void writeVariablesToFile(String filename)
	{
		Properties document = new Properties();
		
		for(int i = 0; i < variables.size(); i++)
		{
			document.setProperty(variables.get(i).getId(), variables.get(i).getValue());
		}
		
		try
		{
			File file = new File(filename);
			FileOutputStream fileOut = new FileOutputStream(file);
			document.store(fileOut, "pCalculator Variables");
			fileOut.close();
		}
		catch(Exception e)
		{
			System.out.println("An error occured while writing the variables to file.");
			Interface.logError(e);
		}
		
	}
	
	public static void menu(String[] c)
	{
		boolean hasArgs;
		try
		{
			String k = c[0];
			if(k.toLowerCase().equals("add") || k.toLowerCase().equals("set") || k.toLowerCase().equals("remove") || k.toLowerCase().equals("write") || k.toLowerCase().equals("read") || k.toLowerCase().equals("get"))
			{
				hasArgs = true;
			}
			else
			{
				hasArgs = false;
			}
		}
		catch(Exception e)
		{
			hasArgs = false;
		}
		
		//Provide do stuff based on args, or provide a menu for doing so.
		
		if(hasArgs)
		{
			if(c[0].equals("help"))
			{
				//
			}
			else if(c[0].equals("set"))
			{
				//
			}
		}
	}

}

