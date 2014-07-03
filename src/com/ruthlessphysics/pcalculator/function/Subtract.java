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

package com.ruthlessphysics.pcalculator.function;

import com.ruthlessphysics.pcalculator.tool.Debug;
import com.ruthlessphysics.pcalculator.tool.Var;
import com.ruthlessphysics.pcalculator.Header;

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
    double var = 0.0;
    String choose = "default";
    double r = 0.0; //Result
    try
    {
      Debug.println("r:"+r+"\n");
      if(Var.isOccupied(c[0]) && Var.isValidDouble(Var.getVar(c[0])))
      {
        var = Var.d(Var.getVar(c[0]));
        r = var;
        choose = "var";
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      Debug.displayError(e);
    }
    if(choose.equals("default"))
    {
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
    }
    choose = "default";
    for(int i = 1; i < c.length; i++)
    {
      //Subtract each number in every index after 0 continuously to form the difference
      try
      {
        if(Var.isOccupied(c[0]) && Var.isValidDouble(Var.getVar(c[0])))
        {
          var = Var.d(Var.getVar(c[0]));
          r -= var;
          choose = "var";
        }
      }
      catch (Exception e)
      {
        e.printStackTrace();
        Debug.displayError(e);
      }

      if(choose.equals("default"))
      {
        try
        {
          r -= Double.parseDouble(c[i]);
        }
        catch (Exception e)
        {
          e.printStackTrace();
          Debug.displayError(e);
          break;
        }
      }
      choose = "default";
    }
    return Double.toString(r);
  }

}
