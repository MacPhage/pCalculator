//
//  Subtract.java
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
import java.lang.*;

public class Subtract
{
  /* Subtract
  // Subtracts all other numbers from the first number
  */
  public static String calculate(String[] c) //Input command
  {
    double r; //Result
    try
    {
      r = Double.parseDouble(c[0]); //Result;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return c[0];
    }
    for(int i = 1; i < c.length; i++)
    {
      //Subtract each number in every index after 0 continuously to form the difference
      try
      {
        r -= Double.parseDouble(c[i]);
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
    }
    return Double.toString(r);
  }

}
