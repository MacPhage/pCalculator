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

package com.macphage.function;

import com.macphage.tool.Debug;

import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class OtherFunction
{
  /* Name of Function
  // Description of function.
  */
  public static String calculate(String[] c)
  {
    String r = ""; //Result
    try
    {
      //Calculations using input
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