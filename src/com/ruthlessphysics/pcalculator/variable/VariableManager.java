//
//  Var.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.pcalculator.variable;

import java.util.List;

import com.ruthlessphysics.pcalculator.Calculator;
import com.ruthlessphysics.util.Config;
import com.ruthlessphysics.util.Debug;

public class VariableManager
{
	/* Variable Manager
  	// Provides the methods to manage variables
	*/

	private static List<Variable> variables;
	
	public static Config json_file = new Config("pcalculator-variables");

	public static void add(Variable v)
	{
		try 
		{
			if(get(v.getName()).getName().equals("MISSINGNO"))
			{
				variables.add(v);
			}
			else if(!(get(v.getName()).getName().equals(null)))
			{
				Debug.alert("That variable is already taken.");
				throw new Exception("Variable already taken.");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			if(Debug.alertDebugErrors(Calculator.config))
			{
				Debug.displayError(e);
			}
		}
	}
	
	public static void remove(Variable v)
	{
		if(!v.constant)
		{
			variables.remove(v);
		}
		if(!(v.getName().equals("MISSINGNO")) && (!v.constant))
		{
			Debug.alert("Variable "+v.getName() + " was removed.");
		}
	}
	
	public static Variable get(String name)
	{
		for(int i = 0; i < variables.size(); i++)
		{
			if(name.equals(variables.get(i).getName()))
			{
				return variables.get(i);
			}
		}
		return new Variable("MISSINGNO", null);
	}
	
	public static void setConstants()
	{
		add(new Variable("PI","3.141592653589793",true));
		add(new Variable("E","2.718281828459045",true));
	}
	
	public static void variablesToJSON()
	{
		for(int i = 0; i < variables.size(); i++)
		{
			json_file.json.put(variables.get(i).getName(), variables.get(i).getValue());
		}
	}
	
	public static void jsonToVariables()
	{
		//
	}

	public static void menu(String[] c)
	{
		if(c[0].equals("add"))
		{
			add(new Variable(c[1],c[2]));
		}
		else if(c[0].equals("get"))
		{
			Variable var = get(c[1]);
			Debug.alert(var.getName() + " holds value " + var.getValue());
		}
		else if(c[0].equals("remove"))
		{
			remove(get(c[1]));
		}
		else if(c[0].equals("write"))
		{
			variablesToJSON();
			json_file.writeConfig();
		}
	}

}
