//
//  LeastCommonMultiple.java
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


public class LeastCommonMultiple
{
  /* LCM
  // Finds the least common multiple
  */
  public static String calculate(String[] c)
  {
    String r = ""; //Result
    long[] l = {};
    try
    {
      if(c.length > 2)
      {
        for(int i = 0; i < c.length; i++)
        {
          l[i] = Long.parseLong(c[i]);
        }
        r = "Least Common Multiple calculated as:\n"+Long.toString(lcm(l));
      }
      else
      {
        r = "Least Common Multiple calculated as:\n"+Long.toString(lcm(Long.parseLong(c[0]),Long.parseLong(c[1])));
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      Debug.displayError(e);
    }
    return r;
  }
  //Code from: http://stackoverflow.com/questions/4201860/how-to-find-gcf-lcm-on-a-set-of-numbers
  //Thanks internet person!
  private static long lcm(long a, long b)
  {
    return a * (b / GreatestCommonDivisor.gcd(a, b));
  }
  private static long lcm(long[] input)
  {
    long result = input[0];
    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
    return result;
  }
}
