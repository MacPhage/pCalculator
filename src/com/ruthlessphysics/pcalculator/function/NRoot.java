//
//  OtherFunction.java
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

package com.ruthlessphysics.pcalculator.function;

import com.ruthlessphysics.pcalculator.tool.Debug;

import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class NRoot
{
  /* NRoot
  // Finds the specified root of a number, for example, a squareroot of 4 would be 2root of 4.
  */
  public static String calculate(String[] c)
  {
    double a = 0.0;
    double b = 0.0;
    double root = 0.0;
    String r = ""; //Result
    try
    {
      for(int i = 0; i < c.length; i+=2)
      {
        a = Double.parseDouble(c[i]);
        b = Double.parseDouble(c[i+1]);
        root = Math.pow(Math.abs(b), (1.0 / a));
        r += "nRoot of degree "+Double.toString(a)+" and degree "+Double.toString(b)+" is "+root+".\n";
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
