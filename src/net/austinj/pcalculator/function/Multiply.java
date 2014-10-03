//
//  Multiply.java
//
//  Java Source File
//
//  Created by Austin Jackson
//  http://austinj.net/
//

package net.austinj.pcalculator.function;

import net.austinj.pcalculator.tool.Interface;


public class Multiply
{
  /* Multiply
  // Finds the product of all the items in the given array
  */
  public static String calculate(String[] c)
  {
    double r = 0; //Result
    for(int i = 1; i < c.length; i++)
    {
      //Adds each number in every index together to form the sum
      try
      {
        r *= Double.parseDouble(c[i]);
      }
      catch (Exception e)
      {
        Interface.logError(e);
        break;
      }
    }
    return Double.toString(r);
  }

}
