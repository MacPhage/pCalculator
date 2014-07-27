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

public class VariableManager
{
	/* Variable Manager
  	// Provides the methods to manage variables
	*/

	private static Variable[] vars;
	public static String[][] variables;

	public static void addVar(Variable v)
	{
		vars[vars.length+1] = v;
	}
	
	public static Variable getVar(String name) throws Exception
	{
		for(int i = 0; i < vars.length; i++)
		{
			if(name.equals(vars[i].getName()))
			{
				return vars[i];
			}
		}
		throw new Exception();
	}
	
	public static void menu(String[] c)
	{
		//
	}

}
