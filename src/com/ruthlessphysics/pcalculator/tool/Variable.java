//
//  Variable.java
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

package com.ruthlessphysics.pcalculator.tool;

import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Variable
{
  public String ref; //Reference name for the variable
  public String s; //String form of the value, retrieve number forms with d(), etc

  public Variable(String newRef, String value)
  {
    ref = newRef;
    s = value;
  }
  /*
  public static double d()
  {
    try
    {
      return Double.parseDouble(s);
    }
    catch(Exception e)
    {
      e.printStackTrace();
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
      return 0;
    }
  }

  public static int i()
  {
    try
    {
      return Integer.parseInteger(s);
    }
    catch(Exception e)
    {
      e.printStackTrace();
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
      return 0;
    }
  }

  public static long l()
  {
    try
    {
      return Long.parseLong(s);
    }
    catch(Exception e)
    {
      e.printStackTrace();
      if(Debug.displayDebug())
      {
        JOptionPane.showMessageDialog(null,e.getStackTrace(),"pCalculator Error",JOptionPane.ERROR_MESSAGE);
      }
      return 0L;
    }
  }*/

}
