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

package com.macphage.function;

import com.macphage.tool.Debug;

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
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
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
        if(Debug.displayDebug())
        {
          JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
        }
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
