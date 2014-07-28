//
//  Add.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.pcalculator.function;

import com.ruthlessphysics.pcalculator.Calculator;
import com.ruthlessphysics.util.Debug;

public class Add
{
	/* Add
// Finds the sum of all the items in the given array
	 */
	public static String calculate(String[] c) //Input command
	{
		double r = 0; //Result
		String m = "The sum of ";
		for(int i = 0; i < c.length; i++)
		{
			//Adds each number in every index together to form the sum
			try
			{
				r += Double.parseDouble(c[i]);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				if(Debug.alertDebugErrors(Calculator.config))
				{
					Debug.displayError(e);
				}
				break;
			}
			if(c.length-i == 2) //Make a message of the end result while it's being calculated
			{
				m += c[i]+", and ";
			}
			else if(c.length-i == 1)
			{
				m += c[i];
			}
			else
			{
				m += c[i]+", ";
			}
		}
		m += " equals "+Double.toString(r);
		return m;
	}

}
