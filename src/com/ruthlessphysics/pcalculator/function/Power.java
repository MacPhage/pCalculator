//
//  Power.java
//
//  Java Source File
//
//  Created by Austin Jackson,
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

public class Power
{
  /* Power
  // Raises each number in the current index to the power of the next
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
        r = Math.pow(r,Double.parseDouble(c[i]));
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
