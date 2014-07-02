//
//  OtherCipher.java
//
//  Java Source File
//
//  Created by Austin Jackson,
//  Last modified on June 11, 2014.
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
import java.io.*;
import java.util.*;

public class Squareroot
{
  /* Squareroot
  // Finds the squareroot of things
  */
  public static String calculate(String[] c)
  {
    double a = 0; //Result
    String r = "";
    try
    {
      for(int i = 0; i < c.length; i++)
      {
        a = Math.sqrt(Double.parseDouble(c[i]));
        r += "Squareroot of "+c[i]+" is "+a+".\n";
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

}
