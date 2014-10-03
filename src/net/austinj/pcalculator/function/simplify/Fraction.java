//
//  Fraction.java
//
//  Java Source File
//
//  Created by Austin Jackson
//  http://austinj.net/
//

package net.austinj.pcalculator.function.simplify;

import net.austinj.pcalculator.function.GreatestCommonDivisor;
import net.austinj.pcalculator.tool.Interface;

public class Fraction
{
  /* Simplify
  // Simplifies things (fractions only right now)
  */
  public static String calculate(String[] c)
  {
    String r = ""; //Result
    long a,b,gcd;
    try
    {
        for(int i = 1; i < c.length; i+=2)
        {
          a = Long.parseLong(c[i]);
          b = Long.parseLong(c[i+1]);
          gcd = GreatestCommonDivisor.gcd(a, b);
          r += (c[i]+"/"+c[i+1]+" simplified to "+(a / gcd)+"/"+(b / gcd)+"\n");
        }
    }
    catch(Exception e)
    {
      Interface.logError(e);
    }
    return r;
  }
}
