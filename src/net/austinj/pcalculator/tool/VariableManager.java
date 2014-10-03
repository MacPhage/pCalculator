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

	
	public static void add(Variable v)
	{
		if(!checkForVariableById(v.getId()))
		{
			variables.add(v);
		}
		else
		{
			while(true)
			{
				String s = Interface.prompt("A variable is with the ID \'"+v.getId()+"\' already exists.\nOverwrite? y/n");
				if(s.toLowerCase().charAt(0) == 'y')
				{
					try
					{
						remove(v.getId());
						variables.add(v);
					}
					catch(Exception e)
					{
						Interface.logError(e);
					}
				}
				else if(s.toLowerCase().charAt(0) == 'n')
				{
					break;
				}
				else
				{
					Interface.alert("That wasn\'t a valid answer.");
				}
			}
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
		//
	}

}

