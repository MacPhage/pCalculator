//
//  Factorial.java
//
//  Java Source File
//
//  Created by Austin Jackson
//  http://austinj.net/
//

package net.austinj.pcalculator.function;

import net.austinj.pcalculator.tool.Interface;

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
      Interface.logError(e);
    }
    return r;
  }
}
