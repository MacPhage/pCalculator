//
//  QuadraticFormula.java
//
//  Java Source File
//
//  Created by Austin Jackson
//  http://austinj.net/
//

package net.austinj.pcalculator.function;

import net.austinj.pcalculator.tool.Interface;

public class QuadraticFormula
{
  /* Quadratic Formula
  // Performs the quadratic formula
  */
  public static String calculate(String[] in)
  {
    String r = ""; //Result
    double a,b,c;
    try
    {
      a = Double.parseDouble(in[0]);
      b = Double.parseDouble(in[1]);
      c = Double.parseDouble(in[2]);

      r += "Decimal Solution #1 (+): "+( (-(b)) + Math.sqrt(( b * b) - (4 * a * c)) )  / (2 * a)+"\n";
      r += "Decimal Solution #2 (-): "+( (-(b)) - Math.sqrt(( b * b) - (4 * a * c)) )  / (2 * a)+"\n";
    }
    catch(Exception e)
    {
      Interface.logError(e);
    }
    return r;
  }
}
