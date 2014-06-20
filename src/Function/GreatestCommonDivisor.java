//
//  OtherCipher.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Editted with Atom
//  https://atom.io/
//
//  Further updates
//  http://srchub.org/u/mac
//

package Function;

import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class GreatestCommonDivisor
{
  /* GCD
  // Finds the greatest common divisor
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
        r = "Greatest Common Divisor calculated as:\n"+Long.toString(gcd(l));
      }
      else
      {
        r = "Greatest Common Divisor calculated as:\n"+Long.toString(gcd(Long.parseLong(c[0]),Long.parseLong(c[1])));
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      if(Debug.displayDebug() == true)
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
    }
    return r;
  }
  //Code from: http://stackoverflow.com/questions/4201860/how-to-find-gcf-lcm-on-a-set-of-numbers
  //Thanks internet person!
  public static long gcd(long a, long b)
  {
    while (b > 0)
    {
      long temp = b;
      b = a % b; // % is remainder
      a = temp;
    }
    return a;
  }
  public static long gcd(long[] input)
  {
    long result = input[0];
    for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
    return result;
  }
}
