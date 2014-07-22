//
//  Divide.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.pcalculator.function;

import com.ruthlessphysics.util.Debug;



public class Divide
{
  /* Divide
  // Finds the quotient of all the items in the given array
  */
  public static String calculate(String[] c)
  {
    double r; //Result
    try
    {
      r = Double.parseDouble(c[0]); //Result;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      Debug.displayError(e);
      return c[0];
    }

    for(int i = 1; i < c.length; i++)
    {
      //Adds each number in every index together to form the sum
      try
      {

        r /= Double.parseDouble(c[i]);
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
