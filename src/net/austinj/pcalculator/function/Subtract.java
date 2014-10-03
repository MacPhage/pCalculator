//
//  Subtract.java
//
//  Java Source File
//
//  Created by Austin Jackson
//  http://austinj.net/
//

package net.austinj.pcalculator.function;

import net.austinj.pcalculator.tool.Interface;

public class Subtract
{
	/* Subtract
  	// Subtracts all other numbers from the first number
	*/
	public static String calculate(String[] c) //Input command
	{
		double r = 0.0; //Result
		for(int i = 1; i < c.length; i++)
		{
			//Subtract each number in every index after 0 continuously to form the difference
			try
			{
				r -= Double.parseDouble(c[i]);
			}
			catch (Exception e)
			{
				Interface.logError(e);
			}
		}
		return Double.toString(r);
	}

}
