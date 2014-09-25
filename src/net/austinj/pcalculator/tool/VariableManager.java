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

	
	public static void set(Variable v)
	{
		variables.add(v);
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

}

