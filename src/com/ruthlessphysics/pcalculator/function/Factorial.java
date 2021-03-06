//
//  Factorial.java
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

public class Factorial
{
  /* Factorial
  // Finds the factorial of things
  */
  public static String calculate(String[] c)
  {
    double a = 0;
    double b = 1; //Result
    String r = "";
    try
    {
      for(int i = 0; i < c.length; i++)
      {
        a = Double.parseDouble(c[i]);
        while(a > 1)
        {
          b *= a;
          a--;
        }
        r += "Factorial of "+c[i]+" is "+b+".\n";
        b = 1;
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      Debug.displayError(e);
    }
    return r;
  }
}
