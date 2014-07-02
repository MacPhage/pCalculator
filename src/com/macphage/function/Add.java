//
//  Add.java
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



public class Add
{
  /* Add
  // Finds the sum of all the items in the given array
  */
  public static String calculate(String[] c) //Input command
  {
    double r = 0; //Result
    String m = "The sum of ";
    for(int i = 0; i < c.length; i++)
    {
      //Adds each number in every index together to form the sum
      try
      {
        r += Double.parseDouble(c[i]);
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
    m += " equals "+Debug.sep()+Double.toString(r);
    return m;
  }

}