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

package net.austinj.pcalculator.function;

import com.ruthlessphysics.util.Debug;

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
				e.printStackTrace();
				Debug.displayError(e);
				break;
			}
		}
		return Double.toString(r);
	}

}
