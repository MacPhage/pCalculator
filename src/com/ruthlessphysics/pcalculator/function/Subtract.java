//
//  Subtract.java
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

public class Subtract
{
	/* Subtract
// Subtracts all other numbers from the first number
	 */
	public static String calculate(String[] c) //Input command
	{
		double r; //Result
		try
		{
			r = Double.parseDouble(c[0]); //Result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return c[0];
		}
		for(int i = 1; i < c.length; i++)
		{
			//Subtract each number in every index after 0 continuously to form the difference
			try
			{
				r -= Double.parseDouble(c[i]);
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
		}
		return Double.toString(r);
	}
}
