//
//  Fraction.java
//
//  Java Source File
//
//  Created by Austin Jackson
//
//  Further updates
//  http://srchub.org/u/mac
//

package com.ruthlessphysics.pcalculator.function.simplify;

import com.ruthlessphysics.util.Debug;
import com.ruthlessphysics.pcalculator.function.*;

import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Fraction
{
  /* Simplify
  // Simplifies things (fractions only right now)
  */
  public static String calculate(String[] c)
  {
    String r = ""; //Result
    String type = c[0];
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
      e.printStackTrace();
      Debug.displayError(e);
    }
    return r;
  }
}
