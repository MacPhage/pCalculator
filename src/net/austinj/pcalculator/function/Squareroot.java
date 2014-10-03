//
//  Squareroot.java
//
//  Java Source File
//
//  Created by Austin Jackson
//  http://austinj.net/
//

package net.austinj.pcalculator.function;

import net.austinj.pcalculator.tool.Interface;

public class Squareroot
{
  /* Squareroot
  // Finds the squareroot of things
  */
  public static String calculate(String[] c)
  {
    double a = 0.0; //Result
    String r = "";
    try
    {
      for(int i = 0; i < c.length; i++)
      {
        a = Math.sqrt(Double.parseDouble(c[i]));
        r += "Squareroot of "+c[i]+" is "+a+".\n";
      }
    }
    catch(Exception e)
    {
      Interface.logError(e);
    }
    return r;
  }

}
