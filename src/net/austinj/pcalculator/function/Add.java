//
//  Add.java
//
//  Java Source File
//
//  Created by Austin Jackson
//  http://austinj.net/
//

package net.austinj.pcalculator.function;

import net.austinj.pcalculator.tool.Interface;

public class Add
{
  /* Add
  // Finds the sum of all the items in the given array
  */
  public static String calculate(String[] c) //Input command
  {
    double r = 0; //Result
    for(int i = 0; i < c.length; i++)
    {
    	try
    	{
    		r += Double.parseDouble(c[i]);
        }
        catch (Exception e)
        {
          Interface.logError(e);
        }
    }
    return Double.toString(r);
  }

}
