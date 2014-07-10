//
//  Multiply.java
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
import java.util.*;

public class Multiply
{
  /* Multiply
  // Finds the product of all the items in the given array
  */
  public static String calculate(String[] c)
  {
    double r; //Result
    String m = "The product of "+c[0]+", ";
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
        r *= Double.parseDouble(c[i]);
      }
      catch (Exception e)
      {
        e.printStackTrace();
        Debug.displayError(e);
        break;
      }
      if(c.length-i == 2) //Make a message of the end result while it's being calculated
      {
        m += c[i]+", and ";
      }
      else if(c.length-i == 1)
      {
        m += c[i];
      }
      else
      {
        m += c[i]+", ";
      }
    }
    m += " equals "+r;
    return m;
  }

}
